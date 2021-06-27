MATCH p = (a1:Airport)<-[r:ORIGIN|DESTINATION*4..4]->(a2:Airport)
WHERE a1 <> a2
WITH p, REDUCE(price = 0, node IN [n IN NODES(p)
    WHERE 'Flight' IN LABELS(n)] | price + [(node)<-[:ASSIGN]-(t: Ticket {class: "economy"}) | t.price][0])
    AS totalPrice
WHERE TYPE(head(relationships(p))) = 'ORIGIN'
RETURN p, totalPrice
ORDER BY totalPrice ASC
LIMIT 1;