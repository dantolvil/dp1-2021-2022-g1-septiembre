-- ADMINS --
INSERT INTO users(username,password,enabled) VALUES ('admin','admin',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (1,'admin','admin');

INSERT INTO users(username,password,enabled) VALUES ('admin1','admin1',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (2,'admin1','admin');

INSERT INTO users(username,password,enabled) VALUES ('admin2','admin2',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (3,'admin2','admin');

-- USERS --
INSERT INTO users(username, password,enabled) VALUES ('player1', 'player1',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (4,'player1','player');

INSERT INTO users(username, password,enabled) VALUES ('player2', 'player2',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (5,'player2','player2');

INSERT INTO users(username, password,enabled) VALUES ('player3', 'player3',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (6,'player3','player3');

INSERT INTO users(username, password,enabled) VALUES ('player4', 'player4',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (7,'player4','player4');