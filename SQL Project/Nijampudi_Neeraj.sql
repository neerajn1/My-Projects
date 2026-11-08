DROP TABLE DESTINATION_T CASCADE CONSTRAINTS;
DROP TABLE FLIGHT_T CASCADE CONSTRAINTS;

CREATE TABLE Major (
    MajorID VARCHAR(10) PRIMARY KEY, --lookup table
    MajorName VARCHAR(100) NOT NULL
);

CREATE TABLE Person ( --supertype
    PersonID INT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    DateOfBirth DATE NOT NULL
);

CREATE TABLE Student ( --subtype
    PersonID INT PRIMARY KEY,
    State VARCHAR(50),
    MajorID VARCHAR(10),
    CONSTRAINT FK_Student_Person FOREIGN KEY (PersonID) REFERENCES Person(PersonID) ON DELETE CASCADE, -- on delete cascade makes deletion of a student's data simple reducing abandoned data
    CONSTRAINT FK_Student_Major FOREIGN KEY (MajorID) REFERENCES Major(MajorID)
);

CREATE TABLE Instructor ( --subtype
    PersonID INT PRIMARY KEY,
    Department VARCHAR(50),
    OfficeLocation VARCHAR(50),
    CONSTRAINT FK_Instructor_Person FOREIGN KEY (PersonID) REFERENCES Person(PersonID) ON DELETE CASCADE
);

CREATE TABLE Course (
    CourseID VARCHAR(10) PRIMARY KEY,
    CourseTitle VARCHAR(100) NOT NULL,
    Credits INT NOT NULL,
    InstructorID INT,
    CONSTRAINT FK_Course_Instructor FOREIGN KEY (InstructorID) REFERENCES Instructor(PersonID)
);

CREATE TABLE Enrollment (
    EnrollmentID INT PRIMARY KEY,
    Semester VARCHAR(20),
    FinalGrade INT, --use whole numbers to prevent number disparity
    StudentID INT,
    CourseID VARCHAR(10),
    CONSTRAINT FK_Enrollment_Student FOREIGN KEY (StudentID) REFERENCES Student(PersonID),
    CONSTRAINT FK_Enrollment_Course FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);

INSERT INTO Major (MajorID, MajorName) VALUES ('CS', 'Computer Science');
INSERT INTO Major (MajorID, MajorName) VALUES ('MATH', 'Mathematics');
INSERT INTO Major (MajorID, MajorName) VALUES ('BIO', 'Biological Sciences');
INSERT INTO Major (MajorID, MajorName) VALUES ('ENG', 'English Literature');
INSERT INTO Major (MajorID, MajorName) VALUES ('ART', 'Fine Arts');

INSERT INTO Person (PersonID, FirstName, LastName, Email, DateOfBirth) VALUES (101, 'Alice', 'Smith', 'alice.smith@umbc.edu', TO_DATE('1995-05-15', 'YYYY-MM-DD'));
INSERT INTO Person (PersonID, FirstName, LastName, Email, DateOfBirth) VALUES (102, 'Bob', 'Jones', 'bjones1@umbc.edu', TO_DATE('1998-08-22', 'YYYY-MM-DD'));
INSERT INTO Person (PersonID, FirstName, LastName, Email, DateOfBirth) VALUES (103, 'Charlie', 'Brown', 'cbrown@umbc.edu', TO_DATE('1999-12-01', 'YYYY-MM-DD'));
INSERT INTO Person (PersonID, FirstName, LastName, Email, DateOfBirth) VALUES (104, 'Diana', 'Prince', 'dprince@umbc.edu', TO_DATE('1997-03-30', 'YYYY-MM-DD'));
INSERT INTO Person (PersonID, FirstName, LastName, Email, DateOfBirth) VALUES (105, 'Evan', 'Wright', 'ewright@umbc.edu', TO_DATE('1996-07-04', 'YYYY-MM-DD'));
INSERT INTO Person (PersonID, FirstName, LastName, Email, DateOfBirth) VALUES (106, 'Frank', 'Stein', 'fstein@umbc.edu', TO_DATE('1970-10-31', 'YYYY-MM-DD'));
INSERT INTO Person (PersonID, FirstName, LastName, Email, DateOfBirth) VALUES (107, 'Grace', 'Hopper', 'ghopper@umbc.edu', TO_DATE('1965-12-09', 'YYYY-MM-DD'));
INSERT INTO Person (PersonID, FirstName, LastName, Email, DateOfBirth) VALUES (108, 'Hank', 'Pym', 'hpym@umbc.edu', TO_DATE('1975-01-15', 'YYYY-MM-DD'));
INSERT INTO Person (PersonID, FirstName, LastName, Email, DateOfBirth) VALUES (109, 'Ivy', 'Doom', 'idoom@umbc.edu', TO_DATE('1980-04-20', 'YYYY-MM-DD'));
INSERT INTO Person (PersonID, FirstName, LastName, Email, DateOfBirth) VALUES (110, 'Jack', 'Frost', 'jfrost@umbc.edu', TO_DATE('2000-01-01', 'YYYY-MM-DD'));

INSERT INTO Student (PersonID, State, MajorID) VALUES (101, 'NY', 'MATH');
INSERT INTO Student (PersonID, State, MajorID) VALUES (102, 'NJ', 'CS');
INSERT INTO Student (PersonID, State, MajorID) VALUES (103, 'CA', 'BIO');
INSERT INTO Student (PersonID, State, MajorID) VALUES (104, 'NY', 'CS');
INSERT INTO Student (PersonID, State, MajorID) VALUES (105, 'TX', 'ENG');
INSERT INTO Student (PersonID, State, MajorID) VALUES (110, 'FL', 'ART');

INSERT INTO Instructor (PersonID, Department, OfficeLocation) VALUES (101, 'Mathematics', 'Building A - 101');
INSERT INTO Instructor (PersonID, Department, OfficeLocation) VALUES (106, 'Biological Sciences', 'Science Hall 304');
INSERT INTO Instructor (PersonID, Department, OfficeLocation) VALUES (107, 'Computer Science', 'ITE 505');
INSERT INTO Instructor (PersonID, Department, OfficeLocation) VALUES (108, 'Physics', 'Lab 2');
INSERT INTO Instructor (PersonID, Department, OfficeLocation) VALUES (109, 'Biological Sciences', 'Greenhouse 1');

INSERT INTO Course (CourseID, CourseTitle, Credits, InstructorID) VALUES ('CS101', 'Intro to Java', 4, 107);
INSERT INTO Course (CourseID, CourseTitle, Credits, InstructorID) VALUES ('BIO200', 'Anatomy', 3, 106);
INSERT INTO Course (CourseID, CourseTitle, Credits, InstructorID) VALUES ('MATH101', 'Calculus I', 4, 101);
INSERT INTO Course (CourseID, CourseTitle, Credits, InstructorID) VALUES ('ENG300', 'Shakespeare', 3, 101);
INSERT INTO Course (CourseID, CourseTitle, Credits, InstructorID) VALUES ('ART101', 'Painting Basics', 2, 109);

INSERT INTO Enrollment (EnrollmentID, Semester, FinalGrade, StudentID, CourseID) VALUES (1, 'Fall 2024', 95, 102, 'CS101');
INSERT INTO Enrollment (EnrollmentID, Semester, FinalGrade, StudentID, CourseID) VALUES (2, 'Fall 2024', 88, 104, 'CS101');
INSERT INTO Enrollment (EnrollmentID, Semester, FinalGrade, StudentID, CourseID) VALUES (3, 'Fall 2024', 92, 103, 'BIO200');
INSERT INTO Enrollment (EnrollmentID, Semester, FinalGrade, StudentID, CourseID) VALUES (4, 'Spring 2025', 75, 105, 'ENG300');
INSERT INTO Enrollment (EnrollmentID, Semester, FinalGrade, StudentID, CourseID) VALUES (5, 'Spring 2025', 100, 101, 'ART101');
INSERT INTO Enrollment (EnrollmentID, Semester, FinalGrade, StudentID, CourseID) VALUES (6, 'Spring 2025', 85, 110, 'ART101');
INSERT INTO Enrollment (EnrollmentID, Semester, FinalGrade, StudentID, CourseID) VALUES (7, 'Fall 2024', 60, 102, 'MATH101');

SELECT PersonID, State, MajorID  --get all NY students
FROM Student 
WHERE State = 'NY';

SELECT CourseID, CourseTitle, InstructorID  --get all courses that equal to 4 credits
FROM Course 
WHERE Credits = 4;

SELECT Person.FirstName, Person.LastName, Major.MajorName -- inner join for students and their majors
FROM Person
JOIN Student ON Person.PersonID = Student.PersonID
JOIN Major ON Student.MajorID = Major.MajorID;

SELECT Course.CourseTitle, Person.FirstName, Person.LastName, Enrollment.FinalGrade --inner join of class list of which student is in what course
FROM Enrollment
JOIN Course ON Enrollment.CourseID = Course.CourseID
JOIN Student ON Enrollment.StudentID = Student.PersonID
JOIN Person ON Student.PersonID = Person.PersonID;

SELECT Person.LastName, Course.CourseTitle --guve our instructors and the courses they teach
FROM Instructor
JOIN Person ON Instructor.PersonID = Person.PersonID
LEFT JOIN Course ON Instructor.PersonID = Course.InstructorID;

SELECT Person.FirstName, Person.LastName, Course.CourseTitle, Enrollment.Semester, Enrollment.FinalGrade --get transcript of Bob from multiple tables (equi join)
FROM Person
JOIN Student ON Person.PersonID = Student.PersonID
JOIN Enrollment ON Student.PersonID = Enrollment.StudentID
JOIN Course ON Enrollment.CourseID = Course.CourseID
WHERE Person.FirstName = 'Bob' AND Person.LastName = 'Jones';

SELECT Major.MajorName, COUNT(Student.PersonID) --how many students in each major
FROM Major
JOIN Student ON Major.MajorID = Student.MajorID
GROUP BY Major.MajorName;

SELECT Course.CourseTitle, AVG(Enrollment.FinalGrade) --calculate avg grade of each course
FROM Course
JOIN Enrollment ON Course.CourseID = Enrollment.CourseID
GROUP BY Course.CourseTitle;

UPDATE Enrollment --correct grade
SET FinalGrade = 70
WHERE EnrollmentID = 7;

UPDATE Instructor --change location of instructor to new office
SET OfficeLocation = 'ITE 302'
WHERE PersonID = 106;