<%@ page import="mx.edu.utez.inte.model.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Docentes</title>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<link rel="stylesheet" href="CSS/registrar_usuario.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@400&display=swap" />
</head>
<body>

<!-- un formulario para insertar el usuario -->

<%  HttpSession sesion = request.getSession();
    Usuario u = (Usuario) sesion.getAttribute("usuario");
    if (u == null) { // Que estoy registrando %>

<form method="post" action="sign_in">

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
            <label>Contraseña: </label>
            <input type="password" name="contra1">
        </div>
        <div>
            <label>Confirme contraseña: </label>
            <input type="password" name="contra2">
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
            <label>Estatus: </label>
            <input type="number" name="estatus">

        </div>
        <div>
            <input type="hidden" name="operacion" value="registrar">
            <input type="submit" value="Registrarse" class="btn">
        </div>
    </div>
</form>

<% } else { %>

<form method="post" action="sign_in">

    <div class="form-container">
        <div>
            <label class="titulo">ACTUALIZAR</label>
        </div>
        <div>
            <label>Nombre: </label>
            <input type="text" name="nombre" value="<%=u.getNombre()%>">
        </div>
        <div>
            <label>Apellidos: </label>
            <input type="text" name="apellidos" value="<%=u.getApellidos()%>">
        </div>
        <div>
            <label>Correo: </label>
            <input type="email" name="correo" value="<%=u.getCorreo()%>">
        </div>

        <div>
            <label>Telefono: </label>
            <input type="tel" name="telefono" value="<%=u.getTelefono()%>">
        </div>
        <div>
            <label>CURP: </label>
            <input type="text" name="curp" value="<%=u.getCurp()%>">
        </div>
        <div>
            <label>Estatus: </label>
            <input type="number" name="estatus" value="<%=u.getEstatus()%>">
        </div>
        <div>
            <input type="hidden" name="operacion" value="actualizar">
            <input type="hidden" name="id_usuario" value="<%=u.getId_usuario()%>">
            <input type="submit" value="Actualizar" class="btn">
        </div>
    </div>
</form>
<% } %>
<%
    sesion.removeAttribute("usuario");
    sesion.removeAttribute("mensaje");
%>
</body>
</html>
