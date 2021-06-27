// Dodanie danych testowych
MATCH (lax:Airport {name:"LAX"}), (far:Airport {name:"FAR"}), (day:Airport {name: "DAY"}), (grr:Airport {name: "GRR"})
CREATE
(f1:Flight { date:'01/01/2021 06:06:06', duration:100, distance:500, airline:'19977' }),
(f1)-[:ORIGIN]->(far),(f1)-[:DESTINATION]->(day),
(t1f1:Ticket { class:'economy', price:300 }),
(t1f1)-[:ASSIGN]->(f1),(t2f1:Ticket { class:'business', price:500 }),
(t2f1)-[:ASSIGN]->(f1),(t3f1:Ticket { class:'firstClass', price:600 }),
(t3f1)-[:ASSIGN]->(f1),

(f2:Flight { date:'01/02/2021 06:06:06', duration:400, distance:2000, airline:'19977' }),
(f2)-[:ORIGIN]->(lax),(f2)-[:DESTINATION]->(far),
(t1f2:Ticket { class:'economy', price:1000 }),
(t1f2)-[:ASSIGN]->(f2),(t2f2:Ticket { class:'business', price:1200 }),
(t2f2)-[:ASSIGN]->(f2),(t3f2:Ticket { class:'firstClass', price:1400 }),
(t3f2)-[:ASSIGN]->(f2),

(f3:Flight { date:'01/03/2021 06:06:06', duration:500, distance:2500, airline:'19977' }),
(f3)-[:ORIGIN]->(lax),(f3)-[:DESTINATION]->(day),
(t1f3:Ticket { class:'economy', price:1500 }),
(t1f3)-[:ASSIGN]->(f3),(t2f3:Ticket { class:'business', price:1800 }),
(t2f3)-[:ASSIGN]->(f3),(t3f3:Ticket { class:'firstClass', price:2000 }),
(t3f3)-[:ASSIGN]->(f3),

(f4:Flight { date:'01/04/2021 06:06:06', duration:500, distance:2500, airline:'19977' }),
(f4)-[:ORIGIN]->(lax),(f4)-[:DESTINATION]->(grr),
(t1f4:Ticket { class:'economy', price:1200 }),
(t1f4)-[:ASSIGN]->(f4),(t2f4:Ticket { class:'business', price:1500 }),
(t2f4)-[:ASSIGN]->(f4),(t3f4:Ticket { class:'firstClass', price:1850 }),
(t3f4)-[:ASSIGN]->(f4),

(f5:Flight { date:'01/06/2021 06:06:06', duration:333, distance:777, airline:'19977' }),
(f5)-[:ORIGIN]->(grr),(f5)-[:DESTINATION]->(day),
(t1f5:Ticket { class:'economy', price:777 }),
(t1f5)-[:ASSIGN]->(f5),(t2f5:Ticket { class:'business', price:888 }),
(t2f5)-[:ASSIGN]->(f5),(t3f5:Ticket { class:'firstClass', price:999 }),
(t3f5)-[:ASSIGN]->(f5);

// Zadanie
MATCH p = (a1:Airport {name:"LAX"})<-[r:ORIGIN|DESTINATION*..5]->(a2:Airport {name: "DAY"})
WITH p, REDUCE(price = 0, node IN [n IN NODES(p)
    WHERE 'Flight' IN LABELS(n)] | price + [(node)<-[:ASSIGN]-(t: Ticket {class: "economy"}) | t.price][0])
    AS totalPrice
WHERE TYPE(head(relationships(p))) = 'ORIGIN'
RETURN p, totalPrice
ORDER BY totalPrice ASC
LIMIT 1;

// Sprzątanie
MATCH (f:Flight { date:'01/01/2021 06:06:06', duration:100, distance:500, airline:'19977' })
DETACH DELETE f;
MATCH (f:Flight { date:'01/02/2021 06:06:06', duration:400, distance:2000, airline:'19977' })
DETACH DELETE f;
MATCH (f:Flight { date:'01/03/2021 06:06:06', duration:500, distance:2500, airline:'19977' })
DETACH DELETE f;
MATCH (f:Flight { date:'01/04/2021 06:06:06', duration:500, distance:2500, airline:'19977' })
DETACH DELETE f;
MATCH (f:Flight { date:'01/06/2021 06:06:06', duration:333, distance:777, airline:'19977' })
DETACH DELETE f;


