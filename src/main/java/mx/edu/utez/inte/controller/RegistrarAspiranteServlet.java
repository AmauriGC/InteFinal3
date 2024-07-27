package mx.edu.utez.inte.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.inte.dao.AspiranteDao;
import mx.edu.utez.inte.dao.UsuarioDao;
import mx.edu.utez.inte.model.Aspirante;

import java.io.IOException;

@WebServlet(name = "RegistrarAspiranteServlet", value = "/sign_in_a")
public class RegistrarAspiranteServlet extends HttpServlet {

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id_aspirante = Integer.parseInt(req.getParameter("id_aspirante"));
            //regresa comillas vacias ya que busca el id_aspirante pero manda " " y hace que marque el error
            //puedo hacer
            AspiranteDao dao = new AspiranteDao();
            Aspirante a = dao.getOneA(id_aspirante);
            HttpSession sesion = req.getSession();
            sesion.setAttribute("aspirante",a);
            resp.sendRedirect("registrarAspirante.jsp");

        }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operacion = req.getParameter("operacion");

        if (operacion.equals("registrar")) {

            String nombre = req.getParameter("nombre");
            String apellidos = req.getParameter("apellidos");
            String correo = req.getParameter("correo");
            int telefono = Integer.parseInt(req.getParameter("telefono"));
            String curp = req.getParameter("curp");
            String ruta = "gestionAspirante.jsp";

            HttpSession sesion = req.getSession();

            Aspirante a = new Aspirante();
            a.setNombre(nombre);
            a.setApellidos(apellidos);
            a.setCorreo(correo);
            a.setTelefono(telefono);
            a.setCurp(curp);

            UsuarioDao dao = new UsuarioDao();
            boolean insertado = dao.insertA(a);

            if (insertado) {
                sesion.setAttribute("mensaje2", "Registro exitoso");
                resp.sendRedirect(ruta);
            } else {
                sesion.setAttribute("mensaje3", "El aspirante no se registró correctamente");
                resp.sendRedirect("registrarAspirante.jsp");
            }

        } if (operacion.equals("actualizar")) {

            String nombre = req.getParameter("nombre");
            String apellidos = req.getParameter("apellidos");
            String correo = req.getParameter("correo");
            int telefono = Integer.parseInt(req.getParameter("telefono"));
            String curp = req.getParameter("curp");
            int id_aspirante = Integer.parseInt(req.getParameter("id_aspirante"));

            Aspirante a = new Aspirante();
            a.setNombre(nombre);
            a.setApellidos(apellidos);
            a.setCorreo(correo);
            a.setTelefono(telefono);
            a.setCurp(curp);
            a.setId_aspirante(id_aspirante);

            UsuarioDao dao = new UsuarioDao();

            if (dao.updateA(a)) {
                //Si se hizo el update
                resp.sendRedirect("gestionAspirante.jsp");
            } else {
                //pues no y mando un error
                req.getSession().setAttribute("mensaje", "No se pudo actualizar");
                resp.sendRedirect("gestionAspirante.jsp");
            }
        } if (operacion.equals("calificar")) {

            double calificacion = Integer.parseInt(req.getParameter("calificacion"));
            int id_aspirante = Integer.parseInt(req.getParameter("id_aspirante"));

            Aspirante a = new Aspirante();
            a.setNombre(String.valueOf(calificacion));
            a.setId_aspirante(id_aspirante);

            AspiranteDao dao = new AspiranteDao();

            if (dao.updateAs(a)) {
                //Si se hizo el update
                resp.sendRedirect("gestionAspirante.jsp");
            } else {
                //pues no y mando un error
                req.getSession().setAttribute("mensaje", "No se pudo actualizar");
                resp.sendRedirect("gestionAspirante.jsp");
            }
        }
    }
}