package mx.edu.utez.inte.dao;

import mx.edu.utez.inte.model.Aspirante;
import mx.edu.utez.inte.model.Usuario;
import mx.edu.utez.inte.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Estas clases DAO permiten el uso de funciones CRUD
public class UsuarioDao {

    //Programar una función R (lectura) para obtener un usuario
    //con el fin de hacer el inicio de sesión

    public Usuario getOne(String nombre, String contra) {
        Usuario u = new Usuario();
        String query = "select * from usuarios where nombre = ? and contra = sha2(?,256)";

        try {
            //1) conectarnos a la BD
            Connection con = DatabaseConnectionManager.getConnection();
            //2) Configurar el query y ejecutarlo
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, contra);
            ResultSet rs = ps.executeQuery();
            //3) Obtener la información
            if (rs.next()) {
                //Entonces llenamos la información del usuario
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setCorreo(rs.getString("correo"));
                u.setContra(rs.getString("contra"));
                u.setTelefono(rs.getInt("telefono"));
                u.setCurp(rs.getString("curp"));
                u.setEstatus(rs.getInt("estatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    //insertar usuarios
    public boolean insert(Usuario u) {
        boolean flag = false;
        String query = "insert into usuarios (nombre,apellidos,correo,contra,telefono,curp,estatus) values(?,?,?,sha2(?,256),?,?,?) ";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getContra());
            ps.setInt(5, u.getTelefono());
            ps.setString(6, u.getCurp());
            ps.setInt(7, u.getEstatus());
            if (ps.executeUpdate() == 1) {
                flag = true;//Porque significa que si se inserto en la BD
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //Seria la R del CRUD
    public ArrayList<Usuario> getAll() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String query = "select * from usuarios";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                //Entonces llenamos la información del usuario
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setCorreo(rs.getString("correo"));
                u.setContra(rs.getString("contra"));
                u.setTelefono(rs.getInt("telefono"));
                u.setCurp(rs.getString("curp"));
                u.setEstatus(rs.getInt("estatus"));
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Usuario getOne(int id_usuario) {
        Usuario u = new Usuario();
        String query = "select * from usuarios where id_usuario = ? ";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_usuario);
            // Ejecutamos la consulta
            if (ps.execute()) {
                // Obtenemos el resultado
                var rs = ps.getResultSet();
                if (rs.next()) {
                    u.setId_usuario(rs.getInt("id_usuario"));
                    u.setNombre(rs.getString("nombre"));
                    u.setApellidos(rs.getString("apellidos"));
                    u.setCorreo(rs.getString("correo"));
                    u.setContra(rs.getString("contra"));
                    u.setTelefono(rs.getInt("telefono"));
                    u.setCurp(rs.getString("curp"));
                    u.setEstatus(rs.getInt("estatus"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public boolean update(Usuario u) {
        boolean flag = false;
        String query = "update usuarios set nombre = ?, apellidos = ?, correo = ?, telefono = ?, curp = ?, estatus = ? where id_usuario = ? ";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getCorreo());
            ps.setInt(4, u.getTelefono());
            ps.setString(5, u.getCurp());
            ps.setInt(6, u.getEstatus());
            ps.setInt(7, u.getId_usuario());
            // Ejecutamos la actualización
            if (ps.executeUpdate() > 0) {
                flag = true; // La actualización fue exitosa
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //Seria la R del CRUD
    public ArrayList<Aspirante> getAllA() {
        ArrayList<Aspirante> lista = new ArrayList<>();
        String query = "select * from aspirantes";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Aspirante a = new Aspirante();
                //Entonces llenamos la información del usuario
                a.setId_aspirante(rs.getInt("id_aspirante"));
                a.setNombre(rs.getString("nombre"));
                a.setApellidos(rs.getString("apellidos"));
                a.setCorreo(rs.getString("correo"));
                a.setTelefono(rs.getInt("telefono"));
                a.setCurp(rs.getString("curp"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    //insertar aspirante
    public boolean insertA(Aspirante a) {
        boolean flag = false;
        String query = "insert into aspirantes (nombre,apellidos,correo,telefono,curp) values(?,?,?,?,?) ";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
            ps.setString(3, a.getCorreo());
            ps.setInt(4, a.getTelefono());
            ps.setString(5, a.getCurp());
            if (ps.executeUpdate() == 1) {
                flag = true;//Porque significa que si se inserto en la BD
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

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

    public boolean updateA(Aspirante a) {
        boolean flag = false;
        String query = "update aspirantes set nombre = ?, apellidos = ?, correo = ?, telefono = ?, curp = ? where id_aspirante = ? ";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
            ps.setString(3, a.getCorreo());
            ps.setInt(4, a.getTelefono());
            ps.setString(5, a.getCurp());
            ps.setInt(6, a.getId_aspirante());
            // Ejecutamos la actualización
            if (ps.executeUpdate() > 0) {
                flag = true; // La actualización fue exitosa
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Usuario getByEmail(String correo) {
        Usuario u = null;
        String query = "select * from usuarios where correo = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setCorreo(rs.getString("correo"));
                u.setCodigoRecuperacion(rs.getString("codigo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public boolean actualizacionCodigoRecuperacion(Usuario u) {
        boolean flag = false;
        String query = "update usuarios set codigo = ? where id_usuario = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, u.getCodigoRecuperacion());
            ps.setInt(2, u.getId_usuario());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Usuario getCodigoRecuperacion(String codigo) {
        Usuario u = null;
        String query = "select * from usuarios where codigo = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setCodigoRecuperacion(rs.getString("codigo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    public boolean actContraCodigo(Usuario u) {
        boolean flag = false;
        String query = "update usuarios set contra = sha2(?,256), codigo = null where id_usuario = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,u.getContra());
            ps.setInt(2, u.getId_usuario());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}