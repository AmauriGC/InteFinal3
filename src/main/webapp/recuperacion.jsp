<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recuperacion</title>
    <link href="CSS/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="CSS/recuperacion.css">

    <link href="${pageContext.request.contextPath}/CSS/bootstrap.css" >
    <link href="${pageContext.request.contextPath}/CSS/datatables.css" >
</head>
<body>
<form method="post" action="updateContra">
    <div class="form-container">
        <h2 class="text-center mt-5">Recuperación de contraseña</h2>
    <label>Nueva Contraseña: </label>
        <input type="password" name="contra">

    <input type="hidden" name="codigo" value="<%= request.getParameter("codigo") %>">
    <br>

    <input type="submit" value="Cambiar" class="btn btn-dark botonesApp btn-block">

    </div>
</form>
</body>
</html>
