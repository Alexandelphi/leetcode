#Runtime: 458 ms, faster than 66.65% of MySQL online submissions for Students With Invalid Departments.
#Memory Usage: 0B, less than 100.00% of MySQL online submissions for Students With Invalid Departments.

SELECT id, name
FROM Students s
WHERE s.department_id NOT IN (SELECT id as department_id FROM Departments);