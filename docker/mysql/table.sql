CREATE TABLE Persons (
                         PersonID int UNIQUE AUTO_INCREMENT NOT NULL,
                         LastName varchar(255) NOT NULL,
                         FirstName varchar(255) NOT NULL,
                         Gender varchar(80) NOT NULL,
                         Title varchar(255) NOT NULL,
                         Nat varchar(255) NOT NULL
);

CREATE TABLE Phone (
                        ProductID varchar(255) NOT NULL,
                        ProductName varchar(255) NOT NULL,
                );
INSERT INTO Phone (ProductID, ProductName) VALUES ('TestProductID', 'TestProductName');
select * from Phone;
DELETE from Phone;


INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES ('Jane', 'Doe', 'female', 'Mrs', 'US');

select * from Persons;

DELETE from Persons ;