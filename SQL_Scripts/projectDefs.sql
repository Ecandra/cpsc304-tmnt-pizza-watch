CREATE TABLE User_IsIn
(
    address varchar(100) NOT NULL,
    userID varchar(30) NOT NULL,
    distance INTEGER NOT NULL,
    PRIMARY KEY (userID)
);

CREATE TABLE Users
(
    userID varchar(30) NOT NULL,
    PRIMARY KEY (userID),
    FOREIGN KEY (userID) REFERENCES User_IsIn ON DELETE CASCADE,
    firstName varchar(40) NOT NULL,
    lastName varchar(40) NOT NULL,
    cardNumber char(16) NOT NULL,
    passwordHash char(64) NOT NULL
);

CREATE TABLE PizzaOrder
(
    oid INTEGER,
    PRIMARY KEY (oid),
    deliveryMethod varchar(20) NOT NULL,
    pizzaType varchar(20) NOT NULL,
    isDelivered INTEGER NOT NULL,
    isCancellationRequested INTEGER NOT NULL,
    userID varchar(30) NOT NULL,
    FOREIGN KEY (userID) REFERENCES Users,
    address varchar(100) NOT NULL,
    FOREIGN KEY (userID) REFERENCES User_IsIn ON DELETE CASCADE
);

CREATE TABLE Pizza
(
    pizzaType varchar(50) NOT NULL,
    PRIMARY KEY (pizzaType),
    price DOUBLE PRECISION NOT NULL
);

CREATE TABLE PrivilegedUser
(
    adminLevel INTEGER NOT NULL,
    userID varchar(30) NOT NULL,
    FOREIGN KEY (userID) REFERENCES Users
);
