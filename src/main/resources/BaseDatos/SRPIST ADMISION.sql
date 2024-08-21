USE sistema_hospital;

-- para seleccionar el nombre y apellido concatenado de la tabla paciente; 
SELECT id_paciente,CONCAT(nombre,' ',apellido) FROM paciente;

-- para seleccionar solo el nombre y apellido concatenado de la tabla doctor
SELECT id_doctor,CONCAT(nombre,' ',apellido) FROM doctor;

-- para insertar en la  tabla admision
INSERT INTO admision(id_paciente,fecha_admision,fecha_alta,diagnostico,id_doctor) VALUES (?,?,?,?,?);

-- para mostrar las admisiones
SELECT 
             admision.id_admision,
             admision.id_paciente,
             CONCAT(paciente.nombre,' ',paciente.apellido),
             admision.fecha_admision,
             admision.fecha_alta,
             admision.diagnostico,
             admision.id_doctor,
             CONCAT(doctor.nombre,' ',doctor.apellido)
             FROM admision
             INNER JOIN paciente ON admision.id_paciente = paciente.id_paciente
             INNER JOIN doctor ON admision.id_doctor = doctor.id_doctor
            ORDER BY admision.id_admision DESC;
            
-- para eliminar una admision: 
DELETE FROM admision WHERE id_admision = ?

