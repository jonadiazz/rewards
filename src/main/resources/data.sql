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

Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (5, 2, '10/03/2022', 100);
Insert into Purchase (purchase_id, customer_Id, purchase_Date, amount) values (6, 2, '10/03/2022', 1000);