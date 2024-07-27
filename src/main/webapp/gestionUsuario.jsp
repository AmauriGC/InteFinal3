<%@ page import="mx.edu.utez.inte.dao.UsuarioDao" %>
<%@ page import="mx.edu.utez.inte.model.Usuario" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrador</title>
    <link rel="stylesheet" href="CSS/gestion_usuario.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/bootstrap.css">
</head>
<body>
<div class="table-container">
    <table id="example" style="width: 100%">
        <thead>
        <tr>
            <th>folio</th>
            <th>nombre</th>
            <th>apellidos</th>
            <th>correo</th>
            <th>telefono</th>
            <th>curp</th>
            <th>estatus</th>
            <th>actualizar</th>
        </tr>
        </thead>
        <tbody>
        <%
            UsuarioDao dao = new UsuarioDao();
            ArrayList<Usuario> lista = dao.getAll();
            for(Usuario u : lista){%>
        <tr>
            <td><%=u.getId_usuario()%></td>
            <td><%=u.getNombre()%></td>
            <td><%=u.getApellidos()%></td>
            <td><%=u.getCorreo()%></td>
            <td><%=u.getTelefono()%></td>
            <td><%=u.getCurp()%></td>
            <td><%=u.getEstatus()%></td>
            <td>
                <button class="boton">
                    <a href="login?id_usuario=<%=u.getId_usuario()%>">Actualizar</a>
                </button>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<script src="${pageContext.request.contextPath}/JS/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/JS/jquery-3.7.0.js"></script>
<script src="${pageContext.request.contextPath}/JS/es-MX.json"></script>
<script>
    //Inicializar Data tables en la tabla objetivo
    document.addEventListener('DOMContentLoaded', () => {
        const table = document.getElementById('example');
        new DataTable(table, {
            language: {
                url: '${pageContext.request.contextPath}/JS/es-MX.json'
            }
        });
    });
</script>
</body>
</html>
