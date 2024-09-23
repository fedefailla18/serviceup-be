--liquibase formatted sql
--changeset federicofailla@serviceup.com:007-create-service-provider-categories.sql
--comment: create service_provider_categories and inserting some things

CREATE TABLE service_provider_categories (
                                             id UUID PRIMARY KEY,
                                             name VARCHAR(100) NOT NULL UNIQUE,
                                             description TEXT,
                                             created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                             created_by TEXT,
                                             updated_at TIMESTAMP,
                                             updated_by TEXT
);

-- Insert some initial categories
INSERT INTO service_provider_categories (id, name, description) VALUES
                                                                    (gen_random_uuid(), 'Plumbing', 'Services related to water systems and pipes'),
                                                                    (gen_random_uuid(), 'Electrical', 'Services related to electrical systems'),
                                                                    (gen_random_uuid(), 'Carpentry', 'Woodworking and furniture services'),
                                                                    (gen_random_uuid(), 'Painting', 'Interior and exterior painting services');