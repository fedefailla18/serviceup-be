--liquibase formatted sql
--changeset federicofailla@serviceup.com:008-create-service-types.sql
--comment: create service_types and inserting some things

CREATE TABLE service_types (
                               id UUID PRIMARY KEY,
                               name VARCHAR(100) NOT NULL UNIQUE,
                               description TEXT,
                               created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               created_by TEXT,
                               updated_at TIMESTAMP,
                               updated_by TEXT
);

-- Insert some initial service types
INSERT INTO service_types (id, name, description) VALUES
                                                      (gen_random_uuid(), 'Kitchen', 'Services related to kitchen area'),
                                                      (gen_random_uuid(), 'Bathroom', 'Services related to bathroom area'),
                                                      (gen_random_uuid(), 'Living Room', 'Services for living room area'),
                                                      (gen_random_uuid(), 'Exterior', 'Outdoor and exterior services');