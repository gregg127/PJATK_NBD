MATCH (m:Movie {title: "The Matrix"})-[:ACTED_IN]-(p)-[:ACTED_IN]-(m2)
RETURN p, m2