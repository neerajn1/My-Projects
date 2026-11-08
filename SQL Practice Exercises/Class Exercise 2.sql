DROP TABLE PERSON_T CASCADE CONSTRAINTS;
DROP TABLE EMPLOYEE_T CASCADE CONSTRAINTS;

CREATE TABLE TEAM_T (
    TeamID      NUMBER(4)       NOT NULL,
    TeamName    VARCHAR2(25)    NOT NULL,
    TeamCity    VARCHAR2(25)    NOT NULL,
    TeamState   VARCHAR2(2)     NOT NULL,
    ManagerName VARCHAR2(25)    NOT NULL,
    StadiumName VARCHAR2(25)    NOT NULL,
    CONSTRAINT TEAM_PK PRIMARY KEY (TeamID)
);

INSERT INTO TEAM_T VALUES (2365, 'Baltimore Orioles', 'Baltimore', 'MD', 'Brandon Hyde', 'Camden Yards');
INSERT INTO TEAM_T VALUES (9876, 'Boston Red Sox', 'Boston',               'MA', 'Alex Cora',     'Fenway Park');
INSERT INTO TEAM_T VALUES (6570, 'New York Yankees', 'Bronx',              'NY', 'Aaron Boone',    'Yankee Stadium');
INSERT INTO TEAM_T VALUES (2399, 'New York Mets',        'Flushing',       'NY',  'Buck Showalter', 'Citi Field');
INSERT INTO TEAM_T VALUES (4630, 'Philadelphia Phillies', 'Philadelphia',  'PA',  'John Doe',       'Citizens Bank Park');


CREATE TABLE SCHEDULE_T (
    ScheduleID     NUMBER(6)       NOT NULL,
    GameTimeofDay  VARCHAR2(5)     CHECK (GameTimeofDay IN ('Day','Night')),
    GameDate       DATE            NOT NULL,
    HomeTeamID     NUMBER(4)          NOT NULL,
    AwayTeamID     NUMBER(4)          NOT NULL,
    HomeScore      NUMBER(2)       NOT NULL,
    AwayScore      NUMBER(2)       NOT NULL,
    CONSTRAINT SCHEDULE_PK PRIMARY KEY (ScheduleID),
    CONSTRAINT SCHEDULE_TEAM_FK1 FOREIGN KEY (HomeTeamID) REFERENCES TEAM_T(TeamID),
    CONSTRAINT SCHEDULE_TEAM_FK2 FOREIGN KEY (AwayTeamID) REFERENCES TEAM_T(TeamID)
);

INSERT INTO SCHEDULE_T VALUES (678965, 'Day',   TO_DATE('04/01/2023', 'MM/DD/YYYY'), 2365, 9876, 5, 2);
INSERT INTO SCHEDULE_T VALUES (639874, 'Night', TO_DATE('04/01/2023', 'MM/DD/YYYY'), 6570, 4630, 5, 7);
INSERT INTO SCHEDULE_T VALUES (792580, 'Night', TO_DATE('04/03/2023', 'MM/DD/YYYY'), 2399, 6570, 11,1);
INSERT INTO SCHEDULE_T VALUES (569001, 'Day',   TO_DATE('04/04/2023', 'MM/DD/YYYY'), 9876, 4630, 6, 5);
INSERT INTO SCHEDULE_T VALUES (325987, 'Night', TO_DATE('04/04/2023', 'MM/DD/YYYY'), 6570, 2365, 1, 0);


UPDATE TEAM_T 
SET ManagerName = 'John Schneider' 
WHERE TeamName = 'Philadelphia Phillies';


SELECT TeamName, ManagerName
FROM TEAM_T
WHERE TeamState IN ('NY')
ORDER BY TeamName;


SELECT TEAM_T.StadiumName, TEAM_T.TeamCity, TEAM_T.TeamState, SCHEDULE_T.GameTimeofDay, SCHEDULE_T.GameDate, SCHEDULE_T.HomeScore, SCHEDULE_T.AwayScore
FROM TEAM_T
INNER JOIN SCHEDULE_T
ON TEAM_T.TEAMID = SCHEDULE_T.HomeTeamID
WHERE SCHEDULE_T.GameTimeofDay = 'Day'
AND TEAM_T.TeamState != 'NY'
ORDER BY Team_T.StadiumName;

DROP TABLE TEAM_T CASCADE CONSTRAINTS;