MATCH (p:Person)-[:ACTED_IN]-(m)
RETURN p, count(m)