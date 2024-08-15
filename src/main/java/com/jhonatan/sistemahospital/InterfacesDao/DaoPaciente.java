package com.jhonatan.sistemahospital.InterfacesDao;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Paciente;
import java.util.List;

public interface DaoPaciente {

    public List<Paciente> listarPacientes(String nombre);

    public int insertarPaciente(Paciente paciente);

    public int modificarPaciente(Paciente paciente);

    public int eliminarPaciente(Paciente paciente);

    public Paciente obtenerInformacionPaciente(int id);

}
