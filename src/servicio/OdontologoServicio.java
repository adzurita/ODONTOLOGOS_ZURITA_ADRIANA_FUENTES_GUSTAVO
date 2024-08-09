package servicio;

import dao.IDAO;
import dao.impl.ImplementacionOdontologoH2;
import modelo.Odontologo;
import java.util.List;

public class OdontologoServicio {
    private IDAO<Odontologo> interfazDAO = new ImplementacionOdontologoH2();

    public Odontologo guardar(Odontologo odontologo) {
        return interfazDAO.guardar(odontologo);
    }

    public List<Odontologo> listarTodos() {
        return interfazDAO.listarTodos();
    }
}
