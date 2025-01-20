CREATE TABLE tasks (
    id BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    status VARCHAR(50) NOT NULL,
    user_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,
    created_by BIGINT NOT NULL,
    created_at VARCHAR(255) NOT NULL,
    description TEXT NOT NULL
);
