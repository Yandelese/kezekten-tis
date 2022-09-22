CREATE TABLE roles (
                       id SERIAL PRIMARY KEY NOT NULL,
                       status TEXT
);


CREATE TABLE users (
                        id SERIAL PRIMARY KEY NOT NULL,
                        email TEXT,
                        password TEXT,
                        full_name TEXT
);



