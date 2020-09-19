CREATE TABLE ISSUESLISTS
(
	ID SERIAL PRIMARY KEY,
    NAME VARCHAR(100)
);

CREATE TABLE ISSUES
(
	ID SERIAL PRIMARY KEY,
    ISSUESLIST_ID  BIGINT UNSIGNED NOT NULL,
	SUMMARY VARCHAR(1024),
	DESCRIPTION VARCHAR(1024),
	USER_ID_ASSIGNEDTO BIGINT UNSIGNED NOT NULL,
	FOREIGN KEY (ISSUESLIST_ID) REFERENCES ISSUESLISTS(ID),
    FOREIGN KEY (USER_ID_ASSIGNEDTO) REFERENCES USERS(ID)
);

INSERT INTO ISSUESLISTS (NAME)
VALUES  ("ToDo"),
        ("In Progress"),
        ("Done");

INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION, USER_ID_ASSIGNEDTO)
VALUES  (1, "Working", "make a plan", 1),
        (1, "Resting", "drink coffe", 3),
        (1, "Learning", "MySQL", 5),
        (1, "Bakeing", "Bake a chocolate cake", 2),
        (1, "Cleaning", "wash floor", 8),
        (2, "Working", "make a plan", 8),
        (2, "Resting", "drink coffe", 2),
        (2, "Learning", "MySQL", 6),
        (2, "Bakeing", "Bake a chocolate cake", 5),
        (2, "Cleaning", "wash floor", 1),
        (3, "Working", "make a plan", 3),
        (3, "Resting", "drink coffe", 1),
        (3, "Learning", "MySQL", 7),
        (3, "Bakeing", "Bake a chocolate cake", 5),
        (3, "Cleaning", "wash floor", 9),

COMMIT;