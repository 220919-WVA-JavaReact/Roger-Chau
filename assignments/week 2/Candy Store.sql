-- Create a table named inventory with the following fields
CREATE TABLE inventory(
	ID int PRIMARY KEY,
	"name" varchar(25),
	price decimal(5,2),
	description varchar(255),
	quantity int
);

-- Insert the following records to your table so that it looks like the following:
INSERT INTO inventory
VALUES
	(1001, 'Hershey Bar', 3.45, 'A small chocolate bar', 50),
	(1002, 'Skittles', 3.05, 'A bag of rainbow colored candies', 100),
	(2003, 'Gummy Bears', 5.55, 'A large bag of chewy fruit-flavored bears', 48),
	(2005, 'Sour Gummy Worms', 9.55, 'A very large bag of gelatin worms', 20),
	(3008, 'Lollipop', 2.25, 'A hard candy atop a stick', 268),
	(9007, 'M&Ms', 1.95, 'A bag of small chocolate candies', 58);
	
-- Run a query to read and display all records in our table
SELECT * FROM inventory i;

-- A customer has just purchased 2 Hershey Candy Bars. Update the inventory to be 48 now.
UPDATE inventory SET quantity = 48 WHERE "name" = 'Hershey Bar';

-- Run a query to return only the descriptions of all records in the table.
SELECT description FROM inventory;

-- A customer wants to see all items in your store and their prices. Run a query to return the name and price only of all records in the table.
SELECT "name", price FROM inventory;

-- Change the description of the Sour Gummy Worms to be 'A very large, delicious bag of worms'.
UPDATE inventory SET description = 'A very large, delicious bag of worms' WHERE "name" = 'Sour Gummy Worms';

-- You've received a shipment of M&Ms just now! Update the quantity to 100.
UPDATE inventory SET quantity = 100 WHERE "name" = 'M&Ms';

-- You are getting a lot of demand for lollipops. Update the price to $2.50.
UPDATE inventory SET price = 2.50 WHERE ID = 3008;

-- Create a table named employees with the following fields
CREATE TABLE employee(
	ID int,
	"name" varchar(50),
	favorite_candy int REFERENCES inventory
);

-- Insert the following data into your employees table so it looks like the following
INSERT INTO employee
VALUES
	(4001, 'Willy Wonka', 2005),
	(4002, 'Milton Hershey', 1001),
	(4003, 'Franklin Mars', 9007),
	(4004, 'John Cadbury', null)

-- Run a query to print the name of each employee and their favorite candy if they have one
SELECT "name", favorite_candy
FROM employee

-- Run a query to display the names of all candies and the name of the corresponding employee who likes them. For this make sure the names of all the candies print out, even if none of the employees like them.
SELECT i."name", e."name"
FROM inventory i 
LEFT JOIN employee e ON i.ID = e.favorite_candy

-- Bonus Questions:
-- What is the total cost to purchase all remaining M&Ms in your store?
