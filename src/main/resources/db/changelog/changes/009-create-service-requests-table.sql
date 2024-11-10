--liquibase formatted sql
--changeset federicofailla@serviceup.com:008-create-service-types.sql
--comment: create service_requests

CREATE TABLE service_requests (
                                  id UUID PRIMARY KEY,
                                  customer_id UUID NOT NULL,
                                  service_type_id UUID NOT NULL,
                                  title VARCHAR(255) NOT NULL,
                                  description VARCHAR(1000) NOT NULL,
                                  status VARCHAR(20) NOT NULL,
                                  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  updated_at TIMESTAMP,
                                  FOREIGN KEY (customer_id) REFERENCES users(id),
                                  FOREIGN KEY (service_type_id) REFERENCES service_types(id)
);