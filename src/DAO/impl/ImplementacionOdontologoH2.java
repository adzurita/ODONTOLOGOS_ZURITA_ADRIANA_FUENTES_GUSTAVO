package dao.impl;

import dao.IDAO;
import modelo.Odontologo;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionOdontologoH2 implements IDAO<Odontologo> {
    private static final Logger logger = Logger.getLogger(ImplementacionOdontologoH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Guardando odontólogo: " + odontologo);
        try (Connection connection = BD.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)")) {
            ps.setString(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.executeUpdate();
            logger.info("Odontólogo guardado correctamente");
        } catch (Exception e) {
            logger.error("Error al guardar odontólogo", e);
        }
        return odontologo;
    }

    @Override
    public void eliminarPorId(Integer id) {
        logger.info("Eliminando odontólogo con ID: " + id);
        try (Connection connection = BD.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
            logger.info("Odontólogo eliminado correctamente");
        } catch (Exception e) {
            logger.error("Error al eliminar odontólogo", e);
        }
    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Listando todos los odontólogos");
        List<Odontologo> odontologos = new ArrayList<>();
        try (Connection connection = BD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM ODONTOLOGOS")) {
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(
                        rs.getString("MATRICULA"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO")
                );
                odontologos.add(odontologo);
            }
            logger.info("Odontólogos listados correctamente");
        } catch (Exception e) {
            logger.error("Error al listar odontólogos", e);
        }
        return odontologos;
    }

    @Override
    public Odontologo consultarPorId(Integer id) {
        // Implementación similar con logging
        return null;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        // Implementación similar con logging
        return null;
    }
}
