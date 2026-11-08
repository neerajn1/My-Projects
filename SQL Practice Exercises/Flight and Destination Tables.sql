DROP TABLE TEAM_T CASCADE CONSTRAINTS;
DROP TABLE SCHEDULE_T CASCADE CONSTRAINTS;

CREATE TABLE DESTINATION_T (
    DestinationID           NUMBER(4)       NOT NULL,
    DestinationCity         VARCHAR(25),    
    DestinationState        VARCHAR(2),     
    DestinationAirportCode  VARCHAR(3),     
    CONSTRAINT DESTINATION_PK PRIMARY KEY (DestinationID)
);

INSERT INTO DESTINATION_T VALUES (5698, 'Philadelphia', 'PA', 'PHI');
INSERT INTO DESTINATION_T VALUES (7558, 'San Francisco', 'CA', 'SFO');
INSERT INTO DESTINATION_T VALUES (8569, 'Chicago', 'IL', 'ORD');
INSERT INTO DESTINATION_T VALUES (6654, 'Denver', 'CO', 'DEN');


CREATE TABLE FLIGHT_T (
    FlightID                NUMBER(6)       NOT NULL,
    AirlineName             VARCHAR(15),    
    FlightNumber            NUMBER(4),
    DepartureDateTime       TIMESTAMP,
    DestinationID           NUMBER(4),
    AirplaneType            VARCHAR(4),

    CONSTRAINT FLIGHT_PK PRIMARY KEY (FlightID),
    CONSTRAINT FLIGHT_DESTINATION_FK FOREIGN KEY (DestinationID) REFERENCES DESTINATION_T(DestinationID),
    CONSTRAINT FLIGHT_AIRPLANE_CHK CHECK (AirplaneType IN ('A350', '737', '747', '767'))
);

INSERT INTO FLIGHT_T VALUES (369987, 'United', 1200, TO_TIMESTAMP('11/15/2023 10:00 AM', 'MM/DD/YYYY HH:MI AM'), 7558, '737');
INSERT INTO FLIGHT_T VALUES (236774, 'Delta', 1645, TO_TIMESTAMP('11/15/2023 04:30 PM', 'MM/DD/YYYY HH:MI PM'), 6654, 'A350');
INSERT INTO FLIGHT_T VALUES (112558, 'Delta', 1842, TO_TIMESTAMP('11/16/2023 08:15 PM', 'MM/DD/YYYY HH:MI PM'), 5698, '767');
INSERT INTO FLIGHT_T VALUES (223698, 'Jet Blue', 9965, TO_TIMESTAMP('11/16/2023 09:20 AM', 'MM/DD/YYYY HH:MI AM'), 5698, '767');
INSERT INTO FLIGHT_T VALUES (857457, 'Southwest', 1269, TO_TIMESTAMP('11/17/2023 07:45 PM', 'MM/DD/YYYY HH:MI PM'), 7558, '747');

UPDATE FLIGHT_T 
SET FlightNumber = 1260
WHERE FlightID = 857457;

SELECT AirlineName, FlightNumber, AirplaneType
FROM FLIGHT_T
WHERE AirplaneType != 'A350';

SELECT
    FLIGHT_T.AirlineName,
    FLIGHT_T.FlightNumber,
    FLIGHT_T.DepartureDateTime,
    DESTINATION_T.DestinationAirportCode
FROM FLIGHT_T
INNER JOIN DESTINATION_T ON FLIGHT_T.DestinationID = DESTINATION_T.DestinationID
WHERE DESTINATION_T.DestinationCity = 'San Francisco'
ORDER BY FLIGHT_T.AirlineName;

SELECT
    DESTINATION_T.DestinationCity, 
    DESTINATION_T.DestinationState, 
    FLIGHT_T.AirlineName,
    FLIGHT_T.FlightNumber,
    FLIGHT_T.DepartureDateTime
FROM FLIGHT_T
INNER JOIN DESTINATION_T ON FLIGHT_T.DestinationID = DESTINATION_T.DestinationID
ORDER BY DESTINATION_T.DestinationCity, FLIGHT_T.AirlineName;

