CREATE TABLE services_establishment_list(
      services_id INT NOT NULL,
      establishment_list_id INT NOT NULL,
          CONSTRAINT fk_name1
                  FOREIGN KEY (services_id)
                        REFERENCES services (id),
          CONSTRAINT fk_name2
                  FOREIGN KEY (establishment_list_id)
                        REFERENCES establishment (id)

);

INSERT INTO services_establishment_list(services_id, establishment_list_id) VALUES
      (1,1),
      (1,2),
      (1,3),

      (2,4),
      (2,5),
      (2,6),

      (3,7),
      (3,8),
      (3,9),

      (4,10),
      (4,11),
      (4,12),

      (5,13),
      (5,14),
      (5,15),

      (6,16),
      (6,17),
      (6,18)







                                                                                  ;
