MATCH path=SHORTESTPATH((t:town {name: "Darjeeling"})-[*]->(p:peak {name: "Sandakphu"}))
RETURN path