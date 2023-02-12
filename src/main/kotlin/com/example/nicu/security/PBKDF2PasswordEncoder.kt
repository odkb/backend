package com.example.nicu.security

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.crypto.password.PasswordEncoder
import java.nio.charset.StandardCharsets
import java.security.NoSuchAlgorithmException
import java.security.spec.InvalidKeySpecException
import java.security.spec.KeySpec
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import kotlin.system.exitProcess

private val logger = KotlinLogging.logger {}

class PBKDF2PasswordEncoder : PasswordEncoder {
    val DEFAULT_ITERATIONS = 390000
    val algorithm = "pbkdf2_sha256"

    @Value("\${app.jwtSecret}")
    private val secretCode = ""

    override fun encode(rawPassword: CharSequence?): String {
        val hash: String = getEncodedHash(rawPassword, secretCode, DEFAULT_ITERATIONS)
        return String.format("%s$%d$%s$%s", algorithm, DEFAULT_ITERATIONS, secretCode, hash)
    }


    private fun encode(password: String?, salt: String?, iterations: Int): String {
        val hash = getEncodedHash(password, salt!!, iterations)
        return String.format("%s$%d$%s$%s", algorithm, iterations, salt, hash)
    }

    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {

        val parts: Array<String> = encodedPassword?.split("\\$".toRegex())?.dropLastWhile { it.isEmpty() }!!.toTypedArray()
        if (parts.size != 4) {
            return false
        }
        val iterations = parts[1].toInt()
        val salt = parts[2]
        val hash = encode(rawPassword.toString(), salt,  iterations)
        return hash == encodedPassword
    }

    private fun getEncodedHash(password: CharSequence?, salt: String, iterations: Int): String {
        var keyFactory: SecretKeyFactory? = null
        try {
            keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        } catch (e: NoSuchAlgorithmException) {
            System.err.println("Could NOT retrieve PBKDF2WithHmacSHA256 algorithm")
            exitProcess(1)
        }
        val keySpec: KeySpec = PBEKeySpec(
            password.toString().toCharArray(),
            salt.toByteArray(StandardCharsets.UTF_8),
            iterations,
            256
        )
        var secret: SecretKey? = null
        try {
            secret = keyFactory!!.generateSecret(keySpec)
        } catch (e: InvalidKeySpecException) {
            println("Could NOT generate secret key")
            e.printStackTrace()
        }
        val rawHash = secret!!.encoded
        val hashBase64 = Base64.getEncoder().encode(rawHash)
        return hashBase64.toString(Charsets.UTF_8)
    }

}