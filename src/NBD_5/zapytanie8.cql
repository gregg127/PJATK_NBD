MATCH (p:Person {name: "Hugo Weaving"})-[:ACTED_IN]-(m)-[:ACTED_IN]-(p2:Person {name: "Keanu Reeves"})
RETURN m
