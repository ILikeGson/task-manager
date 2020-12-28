
CREATE TABLE IF NOT EXISTS users
(
    user_id bigserial PRIMARY KEY,
    user_email varchar(128) NOT NULL UNIQUE,
    user_name varchar(128) NOT NULL,
    user_password varchar(128) NOT NULL
);