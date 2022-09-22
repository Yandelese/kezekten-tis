CREATE TABLE t_tables (
                       id SERIAL PRIMARY KEY NOT NULL,
                       day TEXT,
                       time TEXT,
                       status boolean,
                       establishment_id INT NOT NULL,
                           CONSTRAINT fk_name1
                           FOREIGN KEY (establishment_id)
                           REFERENCES establishment (id)
);



INSERT INTO t_tables (day, time, establishment_id,status) VALUES
('Monday','12:00-13:00',1,false),
('Thusday','09:00-10:00',1,false),
('Wednesday','10:00-12:00',1,false),
('Thursday','15:00-16:00',1,false),
('Friday','14:00-13:00',1,false),
('Saturday','17:00-18:00',1,false),

('Monday','12:00-13:00',2,false),
('Thusday','09:00-10:00',2,false),
('Wednesday','10:00-12:00',2,false),
('Thursday','15:00-16:00',2,false),
('Friday','14:00-13:00',2,false),
('Saturday','17:00-18:00',2,false),

('Monday','12:00-13:00',3,false),
('Thusday','09:00-10:00',3,false),
('Wednesday','10:00-12:00',3,false),
('Thursday','15:00-16:00',3,false),
('Friday','14:00-13:00',3,false),
('Saturday','17:00-18:00',3,false),

('Monday','12:00-13:00',4,false),
('Thusday','09:00-10:00',4,false),
('Wednesday','10:00-12:00',4,false),
('Thursday','15:00-16:00',4,false),
('Friday','14:00-13:00',4,false),
('Saturday','17:00-18:00',4,false),

('Monday','12:00-13:00',5,false),
('Thusday','09:00-10:00',5,false),
('Wednesday','10:00-12:00',5,false),
('Thursday','15:00-16:00',5,false),
('Friday','14:00-13:00',5,false),
('Saturday','17:00-18:00',5,false),

('Monday','12:00-13:00',6,false),
('Thusday','09:00-10:00',6,false),
('Wednesday','10:00-12:00',6,false),
('Thursday','15:00-16:00',6,false),
('Friday','14:00-13:00',6,false),
('Saturday','17:00-18:00',6,false),

('Monday','12:00-13:00',7,false),
('Thusday','09:00-10:00',7,false),
('Wednesday','10:00-12:00',7,false),
('Thursday','15:00-16:00',7,false),
('Friday','14:00-13:00',7,false),
('Saturday','17:00-18:00',7,false),

('Monday','12:00-13:00',8,false),
('Thusday','09:00-10:00',8,false),
('Wednesday','10:00-12:00',8,false),
('Thursday','15:00-16:00',8,false),
('Friday','14:00-13:00',8,false),
('Saturday','17:00-18:00',8,false),

('Monday','12:00-13:00',9,false),
('Thusday','09:00-10:00',9,false),
('Wednesday','10:00-12:00',9,false),
('Thursday','15:00-16:00',9,false),
('Friday','14:00-13:00',9,false),
('Saturday','17:00-18:00',9,false),

('Monday','12:00-13:00',10,false),
('Thusday','09:00-10:00',10,false),
('Wednesday','10:00-12:00',10,false),
('Thursday','15:00-16:00',10,false),
('Friday','14:00-13:00',10,false),
('Saturday','17:00-18:00',10,false),

('Monday','12:00-13:00',11,false),
('Thusday','09:00-10:00',11,false),
('Wednesday','10:00-12:00',11,false),
('Thursday','15:00-16:00',11,false),
('Friday','14:00-13:00',11,false),
('Saturday','17:00-18:00',11,false),

('Monday','12:00-13:00',12,false),
('Thusday','09:00-10:00',12,false),
('Wednesday','10:00-12:00',12,false),
('Thursday','15:00-16:00',12,false),
('Friday','14:00-13:00',12,false),
('Saturday','17:00-18:00',12,false),

('Monday','12:00-13:00',13,false),
('Thusday','09:00-10:00',13,false),
('Wednesday','10:00-12:00',13,false),
('Thursday','15:00-16:00',13,false),
('Friday','14:00-13:00',13,false),
('Saturday','17:00-18:00',13,false),

('Monday','12:00-13:00',14,false),
('Thusday','09:00-10:00',14,false),
('Wednesday','10:00-12:00',14,false),
('Thursday','15:00-16:00',14,false),
('Friday','14:00-13:00',14,false),
('Saturday','17:00-18:00',14,false),

('Monday','12:00-13:00',15,false),
('Thusday','09:00-10:00',15,false),
('Wednesday','10:00-12:00',15,false),
('Thursday','15:00-16:00',15,false),
('Friday','14:00-13:00',15,false),
('Saturday','17:00-18:00',15,false),

('Monday','12:00-13:00',16,false),
('Thusday','09:00-10:00',16,false),
('Wednesday','10:00-12:00',16,false),
('Thursday','15:00-16:00',16,false),
('Friday','14:00-13:00',16,false),
('Saturday','17:00-18:00',16,false),

('Monday','12:00-13:00',17,false),
('Thusday','09:00-10:00',17,false),
('Wednesday','10:00-12:00',17,false),
('Thursday','15:00-16:00',17,false),
('Friday','14:00-13:00',17,false),
('Saturday','17:00-18:00',17,false),

('Monday','12:00-13:00',18,false),
('Thusday','09:00-10:00',18,false),
('Wednesday','10:00-12:00',18,false),
('Thursday','15:00-16:00',18,false),
('Friday','14:00-13:00',18,false),
('Saturday','17:00-18:00',18,false);
