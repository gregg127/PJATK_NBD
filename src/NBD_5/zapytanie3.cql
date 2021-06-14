MATCH (p:Person {name: "Hugo Weaving"})-[:ACTED_IN]->(m)<-[:DIRECTED]-(d)
RETURN m, d