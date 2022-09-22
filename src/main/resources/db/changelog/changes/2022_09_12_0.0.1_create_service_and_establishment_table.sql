
CREATE TABLE establishment (
                          id SERIAL PRIMARY KEY NOT NULL,
                          name TEXT,
                          adress TEXT,
                          telephone TEXT
);

CREATE TABLE services (
                            id SERIAL PRIMARY KEY NOT NULL,
                            name TEXT );

INSERT INTO establishment (name,adress,telephone) VALUES
                                     ('Barbershop #1','st.Bayseitova 113','+77273094024'),
                                     ('Thai-Massage Center','st.Abay 17' ,'+77273085666'),
                                     ('Elite Nails','st.Seifullin 178'   ,'+77273525543'),

                                     ('Marriage Registry #1','st.Riskulov 57','+77273686698'),
                                     ('Mayors Office Almaty ','st.Satpayev 88','+772735872878'),
                                     ('Сlinics #4','st.Zheltoksan 57','+77273228585'),

                                     ('Sing a Song KaraokeBar','st.Bazarbayev 7','+77273228585'),
                                     ('Salsa Dance Club','st.Zholdasbekov 44'   ,'+77273245435'),
                                     ('Alatau Cinema','st.Baykadamov 5'         ,'+77273528288'),

                                     ('CarCare Detailing Center','st.Baykadamov 5','+77273528288'),
                                     ('American Motors','st.Zholdasbekov 44','+77273245435'),
                                     ('Japans Tuning','st.Zheltoksan 57','+77273228585'),

                                     ('English lessons','st.Satpayev 88','+772735872878'),
                                     ('Psychologist','st.Seifullin 178','+77273525543'),
                                     ('Driving Instructor','st.Bayseitova 113','+77273094024'),

                                     ('Veterinarian','st.Riskulov 57','+77273686698'),
                                     ('Pet walking','st.Abay 17' ,'+77273085666'),
                                     ('Grooming','st.Abay 17' ,'+77273085666')
;

INSERT INTO services (name) VALUES
                                        ('Beauty and Health'),
                                        ('State institutions'),
                                        ('Entertaiments'),
                                        ('Car services'),
                                        ('Education and Science'),
                                        ('Animal Care');