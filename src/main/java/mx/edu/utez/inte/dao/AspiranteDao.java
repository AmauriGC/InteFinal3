package mx.edu.utez.inte.dao;

import mx.edu.utez.inte.model.Aspirante;
import mx.edu.utez.inte.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AspiranteDao {

    //Programar una función R (lectura) para obtener un Aspirante
    //con el fin de hacer el inicio de sesión

    public Aspirante getOneA(int id_aspirante) {
        Aspirante a = new Aspirante();
        String query = "select * from aspirantes where id_aspirante = ? ";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_aspirante);
            // Ejecutamos la consulta
            if (ps.execute()) {
                // Obtenemos el resultado
                var rs = ps.getResultSet();
                if (rs.next()) {
                    a.setId_aspirante(rs.getInt("id_aspirante"));
                    a.setNombre(rs.getString("nombre"));
                    a.setApellidos(rs.getString("apellidos"));
                    a.setCorreo(rs.getString("correo"));
                    a.setTelefono(rs.getInt("telefono"));
                    a.setCurp(rs.getString("curp"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public boolean updateAs(Aspirante a) {
        boolean flag = false;
        String query = "update aspirantes set calificacion = ? where id_aspirante = ? ";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, a.getCalificacion());
            ps.setInt(2, a.getId_aspirante());

            // Ejecutamos la actualización
            if (ps.executeUpdate() > 0) {
                flag = true; // La actualización fue exitosa
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}