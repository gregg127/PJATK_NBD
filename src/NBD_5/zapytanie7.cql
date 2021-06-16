MATCH (p:Person)-[:WROTE]-(m:Movie)-[:DIRECTED]-(p2:Person)
WHERE p = p2
RETURN p, m.title
