import dao.BD;
import modelo.Odontologo;
import servicio.OdontologoServicio;

public class Main {
    public static void main(String[] args) {
        // Crear la tabla de Odontólogos
        BD.createTable();

        // Crear el servicio para manejar odontólogos
        OdontologoServicio servicio = new OdontologoServicio();

        // Crear y guardar algunos odontólogos
        Odontologo odontologo1 = new Odontologo("12345", "Juan", "Pérez");
        Odontologo odontologo2 = new Odontologo("67890", "Ana", "García");

        servicio.guardar(odontologo1);
        servicio.guardar(odontologo2);

        // Listar todos los odontólogos
        servicio.listarTodos().forEach(System.out::println);
    }
}
/*
IDAO<Odontologo> odontologo = new ImplementacionOdontologoH2();
OdontologoServicio odontologoServicio = new OdontologoServicio(odontologo);

IDAO<Odontologo> odontologo = new ImplementacionOdontologoList();
OdontologoServicio odontologoServicio = new OdontologoServicio(odontologo);

 */