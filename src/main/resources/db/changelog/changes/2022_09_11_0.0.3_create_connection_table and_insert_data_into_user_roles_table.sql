CREATE TABLE users_roles_list(
   user_id INT NOT NULL,
   roles_list_id INT NOT NULL,
   CONSTRAINT fk_name1
                FOREIGN KEY (user_id)
                    REFERENCES users (id),
   CONSTRAINT fk_name2
       FOREIGN KEY (roles_list_id)
           REFERENCES roles (id)

);



INSERT INTO users_roles_list(user_id, roles_list_id) VALUES
(1,1),
(1,2),
(2,2)
