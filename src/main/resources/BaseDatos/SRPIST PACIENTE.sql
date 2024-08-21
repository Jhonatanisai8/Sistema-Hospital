USE sistema_hospital;

INSERT INTO paciente (nombre,apellido,genero,fechaNacimiento,ciudad,id_provincia,alergias,peso,altura) VALUES (?,?,?,?,?,?,?,?,?);

select * from paciente;

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

-- para eliminar
DELETE FROM paciente WHERE id_paciente = ?;

-- para actualizar / modificar los datos
UPDATE paciente 
	SET nombre = ?,
    apellido = ?,
    genero = ?,
    fechaNacimiento = ?,
    ciudad = ?,
    id_provincia = ?,
    allergias = ?,
    peso = ?,
    altura = ?
    WHERE id_paciente = ?;
DESCRIBE paciente;