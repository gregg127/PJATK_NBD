MATCH (a1:Airport)<-[:ORIGIN]-(f:Flight)-[:DESTINATION]->(a2:Airport)
WITH [a1.name, a2.name, f.airline] AS conn, f
RETURN f.airline AS airline_number, COUNT(DISTINCT conn) AS distinct_count