<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/media.css" />
    <link rel="stylesheet" href="CSS/admin.css" />
    <link href="${pageContext.request.contextPath}/CSS/bootstrap.css">
    <link href="${pageContext.request.contextPath}/CSS/datatables.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@400&display=swap" />
</head>
<body>
<div>
    <header class="top"></header>
    <div class="top">
        <div class="img-admin-parent">
            <img class="img-admin-icon" loading="lazy" alt="" src="img/avatar.png" />
            <div class="administrador-wrapper">
                <div class="administrador">Administrador</div>
            </div>
        </div>
        <div class="cerrar-sesion-wrapper">
            <a class="cerrar-sesion" href="index.jsp">Cerrar sesion</a>
        </div>
        </header>
    </div>
    <div class="left">
        <a class="registrarAspirante" href="registrarAspirante.jsp" target="contenido">Registrar Aspirantes </a>
        <a class="gestionAspirante" href="gestionAspirante.jsp" target="contenido">Consultar Aspirantes </a>
        <a class="registrarDocente" href="registrarUsuario.jsp" target="contenido">Registrar Docentes </a>
        <a class="gestionDocente" href="gestionUsuario.jsp" target="contenido">Consultar Docentes </a>
        <a class="registrarGrupos" href="registrarGrupos.jsp" target="contenido">Registrar Grupos </a>
        <a class="gestionGrupos" href="gestiongrupos.jsp" target="contenido">Consultar Grupos </a>
    </div>
    <div class="content">
        <iframe name="contenido" style="width:100%; height:100vh;"></iframe>
    </div>
</div>
</body>
<script src="JS/bootstrap.js"></script>
</html>
