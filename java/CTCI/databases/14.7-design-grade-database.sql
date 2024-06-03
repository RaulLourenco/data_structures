DECLARE @GPACutOff float;
SET @GPACutOff = (SELECT min(GPA) as 'GPAMin' FROM (
    SELECT TOP 10 PERCENT AVG(CourseEnrollment.Grade) as GPA
    FROM CourseEnrollment
    GROUP BY CourseEnrollment.StudentID
    ORDER BY GPA desc) Grades);

SELECT StudentName, GPA
FROM (SELECT AVG(CourseEnrollment.Grade) as GPA, CourseEnrollment.StudentID
      FROM CourseEnrollment
      GROUP BY CourseEnrollment.StudentID
      HAVING AVG(CourseEnrollment.Grade) >= @GPACutOff) Honors
INNER JOIN Students ON Honors.StudentID = StudentID.StudentID