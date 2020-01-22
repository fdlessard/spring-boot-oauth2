INSERT INTO user (id, version, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
VALUES (0, 0, 'test@email.com', 'password', true, true, true, true);

INSERT INTO authority(id, version, user_id, authority)
VALUES (0, 0, 0, 'role:admin');
INSERT INTO authority(id, version, user_id, authority)
VALUES (1, 0, 0, 'role:user');
