SELECT I.*, IL. NAME
FROM ISSUES I
JOIN ISSUESLISTS IL ON I.ISSUESLIST_ID = IL.ID;

SELECT I.*, U.*
FROM USERS U
JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNEDTO;

SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS QUANTITY
FROM ISSUES I JOIN USERS U ON U.ID = I.USER_ID_ASSIGNEDTO
GROUP BY I.USER_ID_ASSIGNEDTO
HAVING COUNT(*) >= 1;

