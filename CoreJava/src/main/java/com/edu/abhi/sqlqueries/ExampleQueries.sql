
-- http://java67.blogspot.com/2013/04/10-frequently-asked-sql-query-interview-questions-answers-database.html
--http://www.programmerinterview.com/index.php/database-sql/differences-between-primary-and-foreign-keys/
-- http://www.programmerinterview.com/index.php/database-sql/natural-key-in-database/
--http://www.programmerinterview.com/index.php/database-sql/what-is-an-index/

-- Second maximum salary
-- retrieve the unique values for the employee_location without using the DISTINCT keyword
SELECT employee_location from employee GROUP BY employee_location

Select MAX(OrderID) from OrderDetails WHERE OrderID NOT IN (select MAX(OrderID) from OrderDetails )
SELECT max(salary) FROM Employee WHERE salary NOT IN (SELECT max(salary) FROM Employee);


SELECT max(OrderID) FROM OrderDetails WHERE OrderID < (SELECT max(OrderID) FROM OrderDetails)
SELECT max(salary) FROM Employee WHERE salary < (SELECT max(salary) FROM Employee);


SELECT TOP 1 OrderID FROM ( SELECT TOP 2 OrderID FROM OrderDetails ORDER BY OrderID DESC) AS order ORDER BY OrderID ASC
SELECT TOP 1 salary FROM ( SELECT TOP 2 salary FROM employees ORDER BY salary DESC) AS emp ORDER BY salary ASC

-- SQL Query to find Max Salary from each department.
SELECT DeptID, MAX(Salary) FROM Employee  GROUP BY DeptID.
SELECT ProductID, MAX(Quantity) FROM OrderDetails  GROUP BY ProductID.

-- In Above print department name instead of department id.
SELECT DeptName, MAX(Salary) FROM Employee e RIGHT JOIN Department d ON e.DeptId = d.DeptID GROUP BY DeptName;
SELECT ProductName, MAX(Quantity) FROM OrderDetails e RIGHT JOIN Products d ON e.ProductID = d.ProductID GROUP BY ProductName;

-- Write a SQL Query to print the name of distinct employee whose DOB is between 01/01/1960 to 31/12/1975.
SELECT DISTINCT EmpName FROM Employees WHERE DOB  BETWEEN ‘01/01/1960’ AND ‘31/12/1975’;
SELECT DISTINCT (FirstName|' '|LastName) FROM Employees WHERE BirthDate  BETWEEN ‘01/01/1960’ AND ‘31/12/1975’;

-- find all Employee records containing the word "Joe", regardless of whether it was stored as JOE, Joe, or joe.
SELECT * from Employees  WHERE  UPPER(EmpName) like '%JOE%';

--There is a table which contains two column Student and Marks, you need to find all the students, whose marks are greater than average marks i.e. list of above average students.
SELECT student, marks from table where marks > SELECT AVG(marks) from table)
SELECT ProductID, Quantity from OrderDetails where Quantity > (SELECT AVG(Quantity) from OrderDetails)

-- How do you find all employees which are also manager? ####################### IMP #############################
SELECT e.name, m.name FROM Employee e, Employee m WHERE e.mgr_id = m.emp_id;
-- One follow-up is to modify this query to include employees which doesn't have manager. To solve that, instead of using inner join, just use left outer join, this will also include employees without managers.

-- http://www.programmerinterview.com/index.php/database-sql/introduction/
-- Look into MYSQL DB
-- The names of all salespeople that have an order with Samsonic.
Select * from Salesperson where id in (Select salesperson_id from Orders where cust_id in (Select ID from Customer where name = 'Samsonic'));
select Salesperson.Name from Salesperson where Salesperson.ID = {select Orders.salesperson_id from Orders, Customer where Orders.cust_id = Customer.id and Customer.name = 'Samsonic';

-- The names of all salespeople that do not have any order with Samsonic.
Select * from Salesperson where id in (Select salesperson_id from Orders where cust_id not in (Select ID from Customer where name = 'Samsonic'));
select Salesperson.Name from Salesperson where Salesperson.ID NOT IN(select Orders.salesperson_id from Orders, Customer where Orders.cust_id = Customer.ID  and Customer.Name = 'Samsonic')
-- The names of salespeople that have 2 or more orders.
SELECT name FROM Orders, Salesperson WHERE Orders.salesperson_id = Salesperson.id GROUP BY name, salesperson_id HAVING COUNT( salesperson_id ) >1

-- d. Write a SQL statement to insert rows into a table called highAchiever(Name, Age), where a salesperson must have a salary of 100,000 or greater to be included in the table.
insert into highAchiever (name, age) (select name, age from salesperson where salary > 100000);

-- INNER JOIN: Returns all rows when there is at least one match in BOTH tables.
SELECT * FROM Salesperson INNER JOIN orders ON Salesperson.id=orders.salesperson_id;
-- LEFT JOIN: Return all rows from the left table, and the matched rows from the right table. Left table + Intersection.
SELECT * FROM Salesperson LEFT JOIN orders ON Salesperson.id=orders.salesperson_id;
-- RIGHT JOIN: Return all rows from the right table, and the matched rows from the left table. Right Table + Intersection
SELECT * FROM Salesperson RIGHT JOIN orders ON Salesperson.id=orders.salesperson_id;
-- FULL JOIN: Return all rows when there is a match in ONE of the tables.
-- IF It says only join it means inner join.INNER JOIN is the same as JOIN. its the intersection.
-- The FULL OUTER JOIN keyword returns all rows from the left table (table1) and from the right table (table2). 
-- The FULL OUTER JOIN keyword combines the result of both LEFT and RIGHT joins.
-- The FULL OUTER JOIN keyword returns all the rows from the left table (Customers), and all the rows from the right table (Orders).
-- If there are rows in "Customers" that do not have matches in "Orders", or if there are rows in "Orders" that do not have matches in "Customers", those rows will be listed as well.
-- We can see that an inner join will only return rows in which there is a match based on the join predicate. But, with a left or right outer join, the result set will retain all of the rows from either the left or right table.
-- The UNION operator is used to combine the result-set of two or more SELECT statements.
-- Notice that each SELECT statement within the UNION must have the same number of columns. 
-- The columns must also have similar data types. Also, the columns in each SELECT statement must be in the same order.
--  The UNION operator selects only distinct values by default. To allow duplicate values, use the ALL keyword with UNION.
-- It is important to note that the performance of UNION ALL will typically be better than UNION, 
-- since UNION requires the server to do the additional work of removing any duplicates. 
-- So, in cases where is is certain that there will not be any duplicates, or where having duplicates is not a problem, 
-- use of UNION ALL would be recommended for performance reasons.

-- The SELECT INTO statement selects data from one table and inserts it into a new table.
SELECT * INTO newtable [IN externaldb] FROM table1; 
SELECT column_name(s) INTO newtable [IN externaldb] FROM table1;
-- The SELECT INTO statement can also be used to create a new, empty table using the schema of another. Just add a WHERE clause that causes the query to return no data:

-- The INSERT INTO SELECT statement selects data from one table and inserts it into an existing table. Any existing rows in the target table are unaffected.
INSERT INTO table2 SELECT * FROM table1;


-- SQL aggregate functions return a single value, calculated from values in a column.

-- AVG() - Returns the average value, works only on numeric columns.The AVG() function returns the average value of a numeric column.
SELECT AVG(Price) AS PriceAverage FROM Products;
SELECT ProductName, Price FROM Products WHERE Price>(SELECT AVG(Price) FROM Products);
-- COUNT() - Returns the number of rows.The COUNT() function returns the number of rows that matches a specified criteria.
SELECT COUNT(CustomerID) AS OrdersFromCustomerID7 FROM Orders WHERE CustomerID=7;
SELECT COUNT(*) AS NumberOfOrders FROM Orders;
SELECT COUNT(DISTINCT CustomerID) AS NumberOfCustomers FROM Orders;
-- MAX() - Returns the largest value.The MAX() function returns the largest value of the selected column. Works for both numeric and alphanumeric columns.
SELECT MAX(Price) AS HighestPrice FROM Products;
SELECT MAX(PRODUCTNAME) FROM Products;
-- MIN() - Returns the smallest value.The MIN() function returns the smallest value of the selected column.Works for both numeric and alphanumeric columns.
SELECT MIN(Price) AS SmallestOrderPrice FROM Products;
SELECT MIN(PRODUCTNAME) FROM Products;
-- SUM() - Returns the sum. The SUM() function returns the total sum of a numeric column.works only on numeric columns.
SELECT SUM(PRICE) FROM [Products];

---------------------- GROUP BY -----------------
-- Aggregate functions often need an added GROUP BY statement.The GROUP BY statement is used in conjunction with the aggregate functions to group the result-set by one or more columns.
SELECT Shippers.ShipperName,COUNT(Orders.OrderID) AS NumberOfOrders FROM Orders LEFT JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID GROUP BY ShipperName;

SELECT Shippers.ShipperName, Employees.LastName, COUNT(Orders.OrderID) AS NumberOfOrders FROM ((Orders INNER JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID) INNER JOIN Employees ON Orders.EmployeeID=Employees.EmployeeID) GROUP BY ShipperName,LastName;

---------------------- HAVING -----------------
-- The HAVING clause was added to SQL because the WHERE keyword could not be used with aggregate functions.

SELECT Employees.LastName, COUNT(Orders.OrderID) AS NumberOfOrders FROM (Orders INNER JOIN Employees ON Orders.EmployeeID=Employees.EmployeeID) GROUP BY LastName HAVING COUNT(Orders.OrderID) > 10;

SELECT Employees.LastName, COUNT(Orders.OrderID) AS NumberOfOrders FROM Orders INNER JOIN Employees ON Orders.EmployeeID=Employees.EmployeeID WHERE LastName='Davolio' OR LastName='Fuller' GROUP BY LastName HAVING COUNT(Orders.OrderID) > 25;

-- http://www.toptal.com/sql/interview-questions
-- null is not equal to itself! The reason for this is that the proper way to compare a value to null in SQL is with the is operator, not with =.
-- If the set being evaluated by the SQL NOT IN condition contains any values that are null, then the outer query here will return an empty set, even if there are many runner ids that match winner_ids in the races table.
-- SQL Server uses three-valued logic, which can be troublesome for programmers accustomed to the more satisfying two-valued logic (TRUE or FALSE) most programming languages use. In most languages, if you were presented with two predicates: ReferredBy = 2 and ReferredBy <> 2, you would expect one of them to be true and one of them to be false, given the same value of ReferredBy. In SQL Server, however, if ReferredBy is NULL, neither of them are true and neither of them are false. Anything compared to NULL evaluates to the third value in three-valued logic: UNKNOWN.


SELECT I.id, I.date,c.name,r.name FROM test.Invoices AS I JOIN Customers as c ON c.id = I.cust_id  LEFT JOIN Customers r ON c.ReferredBy = r.Id order by I.date;

-- Given a table SALARIES, such as the one below, that has m = male and f = female values. Swap all f and m values (i.e., change all f values to m and vice versa) 
-- with a single update query and no intermediate temp table. ####################### IMP ####################.
UPDATE SALARIES SET sex = CASE sex WHEN 'm' THEN 'f' ELSE 'm' END

-- Given a table TBL with a field Nmbr that has rows with the following values: 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 
-- Write a query to add 2 where Nmbr is 0 and add 3 where Nmbr is 1. ################# IMP ##############.
update TBL set Nmbr = case when Nmbr > 0 then Nmbr+3 else Nmbr+2 end;

-- Write a SQL query to find the 10th highest employee salary from an Employee table. 
SELECT TOP (1) Salary FROM( SELECT DISTINCT TOP (10) Salary FROM Employee ORDER BY Salary DESC) AS Emp ORDER BY Salary

-- What is an execution plan? When would you use it? How would you view the execution plan?
-- An execution plan is basically a road map that graphically or textually shows the data retrieval methods chosen by the SQL server’s query optimizer for a stored procedure 
--or ad hoc query. Execution plans are very useful for helping a developer understand and analyze the performance characteristics of a query or stored procedure, 
--since the plan is used to execute the query or stored procedure.

-- --3rd Highest Salary
select min(Emp_Sal) from Employee_Test where Emp_Sal in (select distinct top 3 Emp_Sal from Employee_Test order by Emp_Sal desc)

-- Get employee details from employee table whose first name ends with 'n' and name contains 4 letters
Select * from EMPLOYEE where FIRST_NAME like '___n' (Underscores)

-- Select department,total salary with respect to a department from employee table where total salary greater than 800000 order by Total_Salary descending
Select Department,SUM(SALARY) AS TOT_SAL from Employee Group By Department having SUM(SALARY) > 800000 ORDER BY SALARY;

-- Select Last Name from employee from a table, where LAST_NAME contain only numbers
Select * from EMPLOYEE where lower(LAST_NAME)=upper(LAST_NAME)



