<%@ page import="mx.edu.utez.inte.model.Aspirante" %>
<%@ page import="mx.edu.utez.inte.dao.UsuarioDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Docente</title>
    <link rel="stylesheet" href="CSS/gestion_aspirante.css" />
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
        <th>calificacion</th>
        <th>...</th>
    </tr>
    </thead>
    <tbody>
    <%
        UsuarioDao dao = new UsuarioDao();
        ArrayList<Aspirante> lista = dao.getAllA();
        for(Aspirante a : lista){%>
    <tr>
        <td><%=a.getId_aspirante()%></td>
        <td><%=a.getNombre()%></td>
        <td><%=a.getApellidos()%></td>
        <td><%=a.getCorreo()%></td>
        <td><%=a.getTelefono()%></td>
        <td><%=a.getCurp()%></td>
        <td>
            <button class="boton">
                <a href="calificacionA?id_aspirante=<%=a.getId_aspirante()%>" >Calificacion</a>            </button>
        </td>
        <td>
            <button class="boton">
                <a href="sign_in_a?id_aspirante=<%=a.getId_aspirante()%>">Actualizar</a>
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
