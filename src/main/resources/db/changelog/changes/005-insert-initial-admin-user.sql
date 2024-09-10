-- Password is 'admin123' (bcrypt encoded)
INSERT INTO users (id, email, password)
VALUES ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'admin@serviceup.com', '$2a$10$uQnYmfLAqQiNzNXNNLZXZOJZOZLZCt3yCJMjXVNYMOhKBZCUgZXOK');

INSERT INTO user_roles (user_id, role_id)
VALUES ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', (SELECT id FROM roles WHERE name = 'ROLE_ADMIN'));