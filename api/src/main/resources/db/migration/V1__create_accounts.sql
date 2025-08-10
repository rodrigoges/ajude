CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE accounts (
    account_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    national_identifier VARCHAR(11) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
