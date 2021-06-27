MATCH (a:Airport)<-[:ORIGIN*]-(f:Flight)
WITH a.name AS airport_name, COUNT(f) AS flights
RETURN airport_name, flights
ORDER BY flights DESC