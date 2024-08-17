package com.jhonatan.sistemahospital.InterfacesDao;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Admision;
import java.util.List;


public interface DaoAdmision {

    public List<Admision> listarAdmisiones();

    public int insertarAdmision(Admision admision);

    public int modificarAdmision(Admision admision);

    public int eliminarAdmision(Admision admision);

    public Admision obtenerInformacion(int idAdmision);

}
