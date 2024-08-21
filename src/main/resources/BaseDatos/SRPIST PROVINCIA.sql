USE sistema_hospital;

DESCRIBE provincia;

SELECT * FROM provincia;

INSERT INTO provincia(nombre) VALUES (?);

DELETE FROM provincia WHERE id_provincia = ?;

SELECT id_provincia,nombre FROM provincia ORDER BY nombre;

UPDATE provincia SET nombre = ? WHERE id_provincia =?;



