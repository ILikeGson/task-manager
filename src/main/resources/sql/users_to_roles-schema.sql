
CREATE TABLE IF NOT EXISTS users_to_roles
(
    user_id bigint references users(user_id),
    role_id bigint references roles(role_id),

    PRIMARY KEY (user_id, role_id)
);