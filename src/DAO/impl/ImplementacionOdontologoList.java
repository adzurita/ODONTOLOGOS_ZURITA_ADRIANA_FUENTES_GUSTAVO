package dao.impl;

import modelo.Odontologo;
import dao.IDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementacionOdontologoList implements IDAO<Odontologo> {
    private Map<Integer, Odontologo> odontologos = new HashMap<>();
    private int idCounter = 1;

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(idCounter++);
        odontologos.put(odontologo.getId(), odontologo);
        return odontologo;
    }

    @Override
    public void eliminarPorId(Integer id) {
        odontologos.remove(id);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return new ArrayList<>(odontologos.values());
    }

    @Override
    public Odontologo consultarPorId(Integer id) {
        return odontologos.get(id);
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        odontologos.put(odontologo.getId(), odontologo);
        return odontologo;
    }
}
