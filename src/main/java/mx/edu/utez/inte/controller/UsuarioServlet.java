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

@WebServlet(name = "UsuarioServlet", value = "/login")
public class UsuarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_usuario = Integer.parseInt(req.getParameter("id_usuario"));
        int id_rol = Integer.parseInt(req.getParameter("id_rol"));
        //regresa comillas vacias ya que busca el id_aspirante pero manda " " y hace que marque el error
        //puedo hacer
        UsuarioDao dao = new UsuarioDao();
        Usuario u = dao.getOne(id_usuario);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("usuario",u);
        sesion.setAttribute("id_rol",id_rol);
        resp.sendRedirect("registrarUsuario.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1) Obtener la información del formulario
        String correo = req.getParameter("correo");
        String contra = req.getParameter("contra");
        String ruta = "index.jsp";

        //2) conectarme a la base de datos y buscar al usuario segun
        // las credenciales del form
        UsuarioDao dao = new UsuarioDao();
        Usuario u = dao.getOne(correo, contra);

        if (u.getNombre() == null) {
            //El usuario no existe en la base de datos
            HttpSession sesion = req.getSession();
            sesion.setAttribute("mensaje", "El usuario no existe en la base de datos");
            resp.sendRedirect(ruta);
        } else {
            //el usuario si existe en la base de datos
            //ruta = "administrador.jsp";
            HttpSession sesion = req.getSession();
            sesion.setAttribute("usuario",u);
            //resp.sendRedirect(ruta);

            sesion.setAttribute("id_usuario", u.getId_usuario());
            sesion.setAttribute("id_rol", u.getId_rol());

            int id_rol = u.getId_rol();

            switch(id_rol){
                case 1: // es administrador
                    ruta="administrador.jsp";

                    sesion.removeAttribute("usuario");
                    sesion.removeAttribute("id_rol");
                    sesion.removeAttribute("mensaje");

                    break;
                case 2: // es cliente registrado
                    ruta="docente.jsp";
                    sesion.removeAttribute("usuario");
                    sesion.removeAttribute("id_rol");
                    sesion.removeAttribute("mensaje");
                    break;
                default:
                    ruta="index.jsp";
                    sesion.removeAttribute("usuario");
                    sesion.removeAttribute("id_rol");
                    sesion.removeAttribute("mensaje");
                    break;
            }
            resp.sendRedirect(ruta);
        }
    }
}