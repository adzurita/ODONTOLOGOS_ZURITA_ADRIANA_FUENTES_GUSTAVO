import modelo.Odontologo;
import org.junit.Before;
import org.junit.Test;
import servicio.OdontologoServicio;
import dao.impl.ImplementacionOdontologoH2;
import java.util.List;
import static org.junit.Assert.*;

public class OdontologoServicioTest {
    private OdontologoServicio servicio;

    @Before
    public void setUp() {
        servicio = new OdontologoServicio(new ImplementacionOdontologoH2());
        BD.createTable(); // Inicializa la tabla antes de cada prueba
    }

    @Test
    public void testGuardarYListar() {
        Odontologo odontologo1 = new Odontologo("123", "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo("456", "Ana", "Garcia");

        servicio.guardar(odontologo1);
        servicio.guardar(odontologo2);

        List<Odontologo> odontologos = servicio.listarTodos();
        assertEquals(2, odontologos.size());
        assertEquals("Juan", odontologos.get(0).getNombre());
        assertEquals("Ana", odontologos.get(1).getNombre());
    }
}
