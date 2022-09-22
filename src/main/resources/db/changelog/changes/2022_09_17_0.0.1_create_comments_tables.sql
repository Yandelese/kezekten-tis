CREATE TABLE feedback(
                       id SERIAL PRIMARY KEY NOT NULL,
                       content TEXT,
                       establishment_id INT NOT NULL,
                       author_id INT NOT NULL,
                       postdate date
);



INSERT INTO feedback  (content, establishment_id, author_id, postdate) VALUES
('Nice Service',1,3,'17-09-2022'),
('Bad Service',1,4,'18-09-2022'),
('Too Expensive',1,5,'19-09-2022'),
('Not Professional',1,4,'18-09-2022')
;
