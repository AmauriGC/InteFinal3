package mx.edu.utez.inte.controller;

import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {
        "/administrador.jsp",
        "/docente.jsp",
        "/gestionAspirante.jsp",
        "/gestiongrupo.jsp",
        "/gestionUsuario.jsp",
        "/olvide.jsp",
        "/recuperacion.jsp",
        "/registrarAspirantes.jsp",
        "/registrarGrupos.jsp",
        "/registrarUsuarios.jsp",
        "/solicitudRecuperacion.jsp"
}) //Direcciones que va a proteger este filtro
public class filtroAdministrador implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // Obtener la sesión, si no existe devolverá null
        HttpSession session = httpRequest.getSession(false);

        // Variable para verificar si el usuario es cliente registrado
        boolean isAdmin = false;

        // Verificar si la sesión no es nula y si el atributo tipoRol está presente y es igual a "Cliente"
        if (session != null && "1".equals(session.getAttribute("id_rol"))) {
            isAdmin = true;
        }

        // Si es cliente, permitir el acceso
        if (isAdmin) {
            // Prevenir almacenamiento en caché
            httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
            httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0
            httpResponse.setDateHeader("Expires", 0); // Proxies
            chain.doFilter(request, response);
        } else {
            // Si no es cliente o no hay sesión, redirigir a la página de acceso denegado
            httpResponse.sendRedirect("accesoDenegado.jsp");
        }
    }
}