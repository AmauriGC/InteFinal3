<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Solicitud de Recuperación</title>
    <link href="CSS/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="CSS/solicitudRecuperacion.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
    <form method="post" action="recuContra">
        <div class="form-container">
            <h2 class="text-center mt-5">Solicitud de Recuperación</h2>
                    <label>Ingrese su correo:</label>
            <input type="email" name="correo" required>
            <br>
                <%
                    HttpSession sesion = request.getSession();
                    String mensaje = (String) sesion.getAttribute("mensaje");
                    if(mensaje != null){ %>
                <p class="text-danger"><%=mensaje%></p>
                <% } %>

            <button type="submit" class="btn btn-dark botonesApp btn-block">Solicitar</button>
        </div>
    </form>
</body>
</html>
