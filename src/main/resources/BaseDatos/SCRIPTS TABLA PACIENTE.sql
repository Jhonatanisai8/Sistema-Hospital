USE sistema_hospital;

DESCRIBE paciente;
DESCRIBE provincia;
SELECT * FROM paciente;
SELECT * FROM provincia;

INSERT INTO paciente (nombre,apellido,genero,fechaNacimiento,ciudad,id_provincia,alergias,peso,altura) VALUES (?,?,?,?,?,?,?,?,?);

SELECT 
paciente.id_paciente,
paciente.nombre,
paciente.apellido,
paciente.genero,
paciente.fechaNacimiento,
paciente.ciudad,
provincia.nombre,
paciente.alergias,
paciente.peso,
paciente.altura
FROM paciente 
INNER JOIN provincia ON paciente.id_provincia = provincia.id_provincia
ORDER BY paciente.nombre;