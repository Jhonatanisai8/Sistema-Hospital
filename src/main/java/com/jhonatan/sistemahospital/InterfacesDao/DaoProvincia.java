package com.jhonatan.sistemahospital.InterfacesDao;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Provincia;
import java.util.List;

public interface DaoProvincia {

    public List<Provincia> listarProvincias();

    public int insertarProvincia(Provincia provincia);

    public int modificarProvincia(Provincia provincia);

    public int eliminarProvincia(Provincia provincia);

    public Provincia obtenerInformacion(int id);
}
