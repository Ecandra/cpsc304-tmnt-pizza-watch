SELECT u.userID
FROM Users u, PriviligedUser pu
WHERE u.userID = pu.userID AND pu.admin = 1;