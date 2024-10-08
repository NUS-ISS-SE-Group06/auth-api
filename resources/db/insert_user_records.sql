
USE auth;

-- CREATE USERS
INSERT INTO user_info(user_id,group_id,`role`, name, username, email, password, password_change_mandatory,created_by, created_date, modified_by, modified_date, delete_flag)
SELECT 1,1,'ROLE_ADMIN','Bruce Wilson', 'user1', 'test1@test.com','password1','FALSE','admin','2024-08-31 00:00:00',NULL,NULL, 'FALSE'
FROM DUAL
WHERE NOT EXISTS(SELECT 1 FROM user_info WHERE user_id=1);

INSERT INTO user_info(user_id,group_id,`role`, name, username, email, password, password_change_mandatory,created_by, created_date, modified_by, modified_date, delete_flag)
SELECT 2,1,'ROLE_USER','Kelly Young', 'user2', 'test2@test.com','password1','FALSE','admin','2024-08-31 00:00:00',NULL,NULL, 'FALSE'
FROM DUAL
WHERE NOT EXISTS(SELECT 1 FROM user_info WHERE user_id=2);

INSERT INTO user_info(user_id,group_id,`role`, name, username, email, password, password_change_mandatory,created_by, created_date, modified_by, modified_date, delete_flag)
SELECT 3,1,'ROLE_USER','Tanoto Salim', 'user3', 'test3@test.com','password1','FALSE','admin','2024-08-31 00:00:00',NULL,NULL, 'FALSE'
FROM DUAL
WHERE NOT EXISTS(SELECT 1 FROM user_info WHERE user_id=3);

-- CREATE GROUP
INSERT INTO group_info(group_id,group_name,group_description,created_by, created_date, modified_by, modified_date, delete_flag)
SELECT 1,'Marketing Team','Team responsible for marketing strategies and campaigns.','admin','2024-08-31 00:00:00',NULL,NULL, 'FALSE'
FROM DUAL
WHERE NOT EXISTS(SELECT 1 FROM group_info WHERE group_id=1);

INSERT INTO group_info(group_id,group_name,group_description,created_by, created_date, modified_by, modified_date, delete_flag)
SELECT 2,'Development Team','Group focused on software development projects.','admin','2024-08-31 00:00:00',NULL,NULL, NULL
FROM DUAL
WHERE NOT EXISTS(SELECT 1 FROM group_info WHERE group_id=2);

COMMIT;