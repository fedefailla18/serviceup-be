-- Drop the existing user_roles table
DROP TABLE IF EXISTS user_roles;

-- Recreate the user_roles table
CREATE TABLE user_roles (
    user_id UUID NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Grant necessary permissions
ALTER TABLE roles OWNER TO serviceup_user;
ALTER TABLE user_roles OWNER TO serviceup_user;