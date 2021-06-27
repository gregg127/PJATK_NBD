// Dodanie danych testowych
MATCH (dar:town {name:"Darjeeling"}), (sanda:peak {name: "Sandakphu"})
MERGE (dar)-[:twowheeler{distance:10,name:'Darjeeling -> Sandakphu',summer:'true',winter:'true'}]-(sanda)
MERGE (dar)-[:twowheeler{distance:9,name:'Darjeeling -> Sandakphu',summer:'true',winter:'true'}]-(sanda)
MERGE (dar)-[:twowheeler{distance:8,name:'Darjeeling -> Sandakphu',summer:'false',winter:'true'}]-(sanda)
MERGE (dar)-[:trek{distance:7,name:'Darjeeling -> Sandakphu', summer:'true',winter:'true'}]-(sanda)

// Zadanie
MATCH (dar:town {name: "Darjeeling"})-[rels:twowheeler*]->(san:peak {name:"Sandakphu"})
WHERE ALL(r IN rels WHERE r.summer = "true")
UNWIND [r IN rels] AS paths
RETURN rels, SUM(paths.distance) AS dist
ORDER BY dist ASC
