#!/bin/bash
set -e
psql -v --username "$POSTGRES_USER" --dbname "bank" <<-EOSQL
  CREATE DATABASE $APP_DB_NAME;
EOSQL