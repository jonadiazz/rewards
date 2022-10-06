-- Create table Customer (
--     customerId int primary key,
--     customerUniqueName varchar(100)
-- );

-- Create table Purchase (
--     purchaseId int primary key,
--     purchaseDate varchar(10) not null,
--     amount int not null,
--     customerId int,
--     foreign key (customerId) references Customer(customerId) 
-- );

Insert into Customer (customer_id, customer_Unique_Name) values (1, 'Charter');
Insert into Customer (customer_id, customer_Unique_Name) values (2, 'Jhonatan');
Insert into Customer (customer_id, customer_Unique_Name) values (3, 'Vasquez');

Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (1, 1, '10/06/2022', 120);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (2, 1, '10/05/2022', 150);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (3, 1, '10/04/2022', 50);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (4, 1, '10/03/2022', 70);

Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (5, 1, '09/05/2022', 60);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (6, 1, '09/04/2022', 75);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (7, 1, '09/03/2022', 75);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (8, 1, '09/02/2022', 125);

Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (9, 1, '08/05/2022', 70);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (10, 1, '08/04/2022', 70);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (11, 1, '08/03/2022', 70);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (12, 1, '08/02/2022', 70);


Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (13, 2, '10/03/2022', 100);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (14, 2, '10/03/2022', 1000);