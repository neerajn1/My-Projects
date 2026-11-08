CREATE TABLE Department (
    DepartmentID VARCHAR(10) PRIMARY KEY, 
    DepartmentName VARCHAR(50) NOT NULL
);

INSERT INTO Department (DepartmentID, DepartmentName) VALUES (1, 'IT');
INSERT INTO Department (DepartmentID, DepartmentName) VALUES (2, 'HR');


CREATE TABLE Employee (
    EmployeeID VARCHAR(10) PRIMARY KEY, 
    EmployeeName VARCHAR(100) NOT NULL,
    DepartmentID VARCHAR(10) NOT NULL,
    CONSTRAINT FK_Department_ID FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    HireDate Date NOT NULL,
    Salary INT NOT NULL
);

INSERT INTO Employee (EmployeeID, EmployeeName, DepartmentID, HireDate, Salary) VALUES (E1, 'Jeff', 1, TO_DATE('2005-01-01', 'YYYY-MM-DD'), 70000);
INSERT INTO Employee (EmployeeID, EmployeeName, DepartmentID, HireDate, Salary) VALUES (E2, 'Susan', 2, TO_DATE('2005-06-01', 'YYYY-MM-DD'), 50000);
INSERT INTO Employee (EmployeeID, EmployeeName, DepartmentID, HireDate, Salary) VALUES (E3, 'Bob', 1, TO_DATE('2000-01-01', 'YYYY-MM-DD'), 90000);
INSERT INTO Employee (EmployeeID, EmployeeName, DepartmentID, HireDate, Salary) VALUES (E4, 'Steve', 1, TO_DATE('2006-01-01', 'YYYY-MM-DD'), 80000);

SELECT *
FROM Department;

SELECT *
FROM Employee;

SELECT *
FROM Employee
WHERE HireDate >= Date '2005-01-01';

SELECT E2.EmployeeName
FROM Employee E1, Employee E2
WHERE E1.EmployeeName = 'Jeff' and E2.HireDate > E1.HireDate;

CREATE TABLE Project (
    ProjectID VARCHAR(10) PRIMARY KEY, 
    ProjectName VARCHAR(100) NOT NULL
);

CREATE TABLE Employee_Project (
    EmployeeID VARCHAR(10) NOT NULL,
    ProjectID VARCHAR(10) NOT NULL,
    CONSTRAINT FK_Employee_ID FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID), 
    CONSTRAINT FK_Project_ID FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID)
);

SELECT EmployeeName
FROM Employee E, Project P, Employee_Project EP
WHERE E.EmployeeID, EP.EmployeeID AND P.ProjectID = EP.ProjectID
AND ProjectName = "UMBC Library";



