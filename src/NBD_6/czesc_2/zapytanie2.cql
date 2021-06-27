MATCH p = (a:Airport {name:"LAX"})<-[r:ORIGIN|DESTINATION*..5]->(a2:Airport)
WITH p, REDUCE(price = 0, node IN [n IN NODES(p) WHERE 'Flight' IN LABELS(n)] | price + [(node)<-[:ASSIGN]-(t: Ticket {class: "economy"}) | t.price][0])
AS totalPrice, a2
WHERE totalPrice < 3000 AND a2.name <> "LAX" AND TYPE(head(relationships(p))) = 'ORIGIN'
RETURN p, totalPrice
ORDER BY totalPrice DESC