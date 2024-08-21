USE sistema_hospital;

SELECT * FROM doctor;

insert into doctor (nombre,apellido,especialidad) values (?,?,?);

update doctor set nombre = ?, apellido = ?, especialidad = ? where id_doctor = ?;

delete from doctor where id_doctor = ?;

SELECT * FROM doctor WHERE id_doctor = ? LIMIT 1;

SELECT id_doctor,nombre,apellido,especialidad FROM doctor;

SELECT COUNT(*),especialidad FROM doctor GROUP BY especialidad;