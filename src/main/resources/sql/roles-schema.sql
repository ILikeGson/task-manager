
CREATE TABLE IF NOT EXISTS roles
(
    role_id bigserial PRIMARY KEY,
    role_name varchar(128) NOT NULL UNIQUE
);