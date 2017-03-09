---
  layout: post
  title: SQL-PRIME-PALINDROME
---

* Algorithm prime & palindrome
```sql
WITH INPUT AS
(
-- (0) INPUT PARAMETER : GIVEN VALUES....
          SELECT  1 T,     1 A,     10 B FROM DUAL
UNION ALL SELECT  2 T,   101 A,    300 B FROM DUAL
UNION ALL SELECT  3 T,  2000 A,   3000 B FROM DUAL
UNION ALL SELECT  4 T,  1000 A,  50000 B FROM DUAL
UNION ALL SELECT  5 T,     2 A,  80000 B FROM DUAL
UNION ALL SELECT  6 T,     1 A, 100000 B FROM DUAL ),
-- (1) ALL NUMBERS
AN AS (
  SELECT
         ROWNUM N
    FROM DUAL
 CONNECT BY LEVEL <= 100000 ),
-- (2) HOEMOON NUMBERS
HN AS (
SELECT
       N
  FROM AN
 WHERE TO_CHAR(N) = REVERSE(TO_CHAR(N))),
-- (3) PRIME NUMBERS ( include PALINDROME )
PN AS (
SELECT --+ MATERIALIZE
       N
  FROM HN
 WHERE HN.N > 1
   AND NOT EXISTS ( SELECT 1 FROM AN
                     WHERE AN.N > 1
                       AND AN.N <= round(power(10000,1/2))                       

                       AND AN.N < HN.N
                       AND MOD(HN.N, AN.N) = 0 ))
/******************* MAIN QUERY *******************/
SELECT T                                                                 AS "Test_Case",
       (SELECT COUNT(1) FROM PN WHERE PN.N BETWEEN INPUT.A AND INPUT.B)  AS "Answer"
  FROM INPUT;
```

* Reverse
``` sql
WITH PARAM AS (
SELECT P_STR         P_STR,
       LENGTH(P_STR) P_LEN
  FROM
      (
      -- Input Parameter Here...
      SELECT 'abcde' P_STR
        FROM DUAL
      )
)
SELECT LISTAGG(P_CHR) WITHIN GROUP (ORDER BY RN DESC) RESULT
  FROM
(
 SELECT P_STR,
        ROWNUM RN,
        SUBSTR(P_STR,ROWNUM,1) P_CHR
   FROM PARAM
CONNECT BY LEVEL <= P_LEN
)
--GROUP BY P_STR;
/
```
