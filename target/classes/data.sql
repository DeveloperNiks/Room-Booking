DROP TABLE IF EXISTS USER;
 
CREATE TABLE USER(
  user_id VARCHAR(250) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  user_name VARCHAR(250) NOT NULL,
  user_points DOUBLE NOT NULL
);
 
INSERT INTO USER ( user_id,user_name, user_points) VALUES
  ('100','Aliko', '500'),
  ('104','Bill', '600'),
  ('201','Folrunsho', '800');

DROP TABLE IF EXISTS ROOM;
 
CREATE TABLE ROOM(
  room_id VARCHAR(250) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  room_price REAL NOT NULL,
  room_status VARCHAR(250) NOT NULL
);
 
INSERT INTO ROOM ( room_id, room_price, room_status) VALUES
  ('1001','500', 'NA'),
  ('1002','700', 'NA'),
  ('2001','400', 'NA');