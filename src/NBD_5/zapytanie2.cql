MATCH (p:Person {name: "Hugo Weaving"})-[:ACTED_IN]->(m)
RETURN p, m