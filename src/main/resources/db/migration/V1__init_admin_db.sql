create role admin_db with CREATEDB CREATEROLE;
create SCHEMA IF NOT EXISTS nicu_op AUTHORIZATION admin_db;