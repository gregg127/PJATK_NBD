MATCH path=SHORTESTPATH((t:town {name: 'Darjeeling'})-[r*]->(p:peak {name: 'Sandakphu'}))
WHERE ALL(re IN r WHERE re.winter = 'true')
RETURN path