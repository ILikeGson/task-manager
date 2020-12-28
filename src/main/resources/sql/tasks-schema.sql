
CREATE TABLE IF NOT EXISTS tasks
(
    task_id bigserial PRIMARY KEY,
    task_date VARCHAR(64),
    task_starttime VARCHAR(64),
    task_stoptime VARCHAR(64),
    task_description VARCHAR(256),
    user_id bigint references users(user_id)
);