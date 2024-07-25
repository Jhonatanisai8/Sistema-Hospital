package com.jhonatan.sistemahospital.InterfacesDao;

import java.util.List;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Doctor;

public interface DaoDoctor {
    public List<Doctor> listarDoctores();

    public int insertarDoctor(Doctor doctor);

    public int modificarDoctor(Doctor doctor);

    public int eliminarDoctor(Doctor doctor);
}

