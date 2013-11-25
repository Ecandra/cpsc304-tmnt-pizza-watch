CREATE TABLE Users
(
    userID INTEGER,
    PRIMARY KEY (userID),
    name varchar(70) NOT NULL,
    cardNumber char(16) NOT NULL
);

CREATE TABLE PrivilegedUser
(
    adminLevel INTEGER,
    userID INTEGER,
    FOREIGN KEY (userID) REFERENCES Users
);

CREATE TABLE PizzaPlace
(
    branchID varchar(50),
    PRIMARY KEY (branchID)
);

CREATE TABLE Branch_IsIn
(
    address varchar(100) NOT NULL,
    branchID varchar(50),
    userID INTEGER,
    PRIMARY KEY (address),
    FOREIGN KEY (userID) REFERENCES Users,
    FOREIGN KEY (branchID) REFERENCES PizzaPlace
);

CREATE TABLE PizzaOrder
(
    oid INTEGER,
    PRIMARY KEY (oid),
    branchID varchar(50),
    deliveryMethod varchar(20) NOT NULL,
    pizzaType varchar(20) NOT NULL,
    FOREIGN KEY (branchID) REFERENCES PizzaPlace,
    userID INTEGER,
    FOREIGN KEY (userID) REFERENCES Users,
    address varchar(100) NOT NULL,
    FOREIGN KEY (address) REFERENCES Branch_IsIn
);

CREATE TABLE Pizza
(
    pizzaType varchar(50) NOT NULL,
    PRIMARY KEY (pizzaType),
    price DOUBLE PRECISION,
    oid INTEGER,
    FOREIGN KEY (oid) REFERENCES PizzaOrder
);

CREATE TABLE PizzaPlaceBranchIsIn
(
    branchID varchar(50),
    FOREIGN KEY (branchID) REFERENCES PizzaPlace,
    address varchar(100) NOT NULL,
    FOREIGN KEY (address) REFERENCES Branch_IsIn
);
