package mx.edu.utez.inte.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.inte.dao.UsuarioDao;
import mx.edu.utez.inte.model.Usuario;

import java.io.IOException;

@WebServlet(name = "RegistrarUsuarioServlet", value = "/sign_in")
public class RegistrarUsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String operacion = req.getParameter("operacion");
        if (operacion.equals("registrar")) {

            String nombre = req.getParameter("nombre");
            String apellidos = req.getParameter("apellidos");
            String correo = req.getParameter("correo");
            String contra1 = req.getParameter("contra1");
            String contra2 = req.getParameter("contra2");
            int telefono = Integer.parseInt(req.getParameter("telefono"));
            String curp = req.getParameter("curp");
            int estatus = Integer.parseInt(req.getParameter("estatus"));
            String ruta = "gestionUsuario.jsp";

            HttpSession sesion = req.getSession();

            if (!contra1.equals(contra2)) {
                sesion.setAttribute("mensaje2", "Las contraseñas no coinciden");
                resp.sendRedirect("registrarUsuario.jsp");
                return;
            }

            Usuario u = new Usuario();
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setCorreo(correo);
            u.setContra(contra1);
            u.setTelefono(telefono);
            u.setCurp(curp);
            u.setEstatus(estatus);

            UsuarioDao dao = new UsuarioDao();
            boolean insertado = dao.insert(u);

            if (insertado) {
                sesion.setAttribute("mensaje2", "Registro exitoso");
                resp.sendRedirect(ruta);
            } else {
                sesion.setAttribute("mensaje3", "El usuario no se registró correctamente");
                resp.sendRedirect("registrarUsuario.jsp");
            }

        } if (operacion.equals("actualizar")) {

            String nombre = req.getParameter("nombre");
            String apellidos = req.getParameter("apellidos");
            String correo = req.getParameter("correo");
            int telefono = Integer.parseInt(req.getParameter("telefono"));
            String curp = req.getParameter("curp");
            int estatus = Integer.parseInt(req.getParameter("estatus"));
            int id_usuario = Integer.parseInt(req.getParameter("id_usuario"));

            Usuario u = new Usuario();
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setCorreo(correo);
            u.setTelefono(telefono);
            u.setCurp(curp);
            u.setEstatus(estatus);
            u.setId_usuario(id_usuario);

            UsuarioDao dao = new UsuarioDao();

            if (dao.update(u)) {
                //Si se hizo el update
                resp.sendRedirect("gestionUsuario.jsp");
            } else {
                //pues no y mando un error
                req.getSession().setAttribute("mensaje", "No se pudo actualizar");
                resp.sendRedirect("gestionUsuario.jsp");
            }
        }
    }
}