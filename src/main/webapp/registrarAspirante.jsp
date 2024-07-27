<%@ page import="mx.edu.utez.inte.model.Aspirante" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aspirantes</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <link rel="stylesheet" href="CSS/registrar_aspirante.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@400&display=swap" />
</head>
<body>
<!-- un formulario para insertar el usuario -->
<%
    HttpSession sesion = request.getSession();
    Aspirante a = (Aspirante) sesion.getAttribute("aspirante");
    if (a == null) { // Que estoy registrando %>

<form method="post" action="sign_in_a">

    <div class="form-container">
        <div>
            <label class="titulo">REGISTRAR</label>
        </div>
        <div>
            <label>Nombre: </label>
            <input type="text" name="nombre">
        </div>
        <div>
            <label>Apellidos: </label>
            <input type="text" name="apellidos">
        </div>
        <div>
            <label>Correo: </label>
            <input type="email" name="correo">
        </div>
        <div>
            <label>Telefono: </label>
            <input type="tel" name="telefono">
        </div>
        <div>
            <label>CURP: </label>
            <input type="text" name="curp">
        </div>
        <div>
            <input type="hidden" name="operacion" value="registrar">
            <input type="submit" value="Registrar" class="btn">
            <input type="submit" value="Registrar Excel" class="btn">
        </div>
    </div>
</form>
<%
    sesion.removeAttribute("aspirante");
    sesion.removeAttribute("mensaje");
%>
<% } else { %>

<form method="post" action="sign_in_a">

    <div class="form-container">
        <div>
        <label class="titulo">ACTUALIZAR</label>
        </div>
        <div>
            <label>Nombre: </label>
            <input type="text" name="nombre" value="<%=a.getNombre()%>">
        </div>
        <div>
            <label>Apellidos: </label>
            <input type="text" name="apellidos" value="<%=a.getApellidos()%>">
        </div>
        <div>
            <label>Correo: </label>
            <input type="email" name="correo" value="<%=a.getCorreo()%>">
        </div>
        <div>
            <label>Telefono: </label>
            <input type="tel" name="telefono" value="<%=a.getTelefono()%>">
        </div>
        <div>
            <label>CURP: </label>
            <input type="text" name="curp" value="<%=a.getCurp()%>">
        </div>
        <div>
            <input type="hidden" name="operacion" value="actualizar">
            <input type="hidden" name="id_aspirante" value="<%=a.getId_aspirante()%>">
            <input type="submit" value="Actualizar" class="btn">
        </div>
    </div>
</form>

<% } %>
<%
    sesion.removeAttribute("aspirante");
    sesion.removeAttribute("mensaje");
%>
</body>
</html>
