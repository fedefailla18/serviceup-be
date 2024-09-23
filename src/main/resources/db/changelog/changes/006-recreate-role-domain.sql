-- Drop the existing user_roles table
DROP TABLE IF EXISTS user_roles;

-- Recreate the roles table
CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE
);

-- Insert default roles
INSERT INTO roles (name) VALUES ('ROLE_CUSTOMER'), ('ROLE_SERVICE_PROVIDER');

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