SELECT TenantName 
FROM Tenants 
INNER JOIN 
    (SELECT TenantID FROM TenantApartments GROUP BY TenantID HAVING count(*) > 1) C
ON Tenants.TenantID = C.TenantID
