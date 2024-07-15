-- Insert data into user table
INSERT INTO users (name, password) VALUES ('user1', 'pass1');
INSERT INTO users (name, password) VALUES ('user2', 'pass2');

-- Insert data into role table
INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_DEVOPS');


INSERT INTO user_role (user_id, role_id) VALUES (1,1);
INSERT INTO user_role (user_id, role_id) VALUES (1,2);
INSERT INTO user_role (user_id, role_id) VALUES (2,1);
INSERT INTO user_role (user_id, role_id) VALUES (2,3);