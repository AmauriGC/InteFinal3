
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="CSS/index.css" />
    <link href="${pageContext.request.contextPath}/CSS/bootstrap.css">
    <link href="${pageContext.request.contextPath}/CSS/datatables.css">
    <title>Login</title>
</head>
<body>

<main>
    <div class="container">
        <div class="box-area">
            <div class="left-box">
                <div class="featured-image">
                    <img src="img/1.png" alt="Imagen alusiva" />
                </div>
            </div>
            <div class="right-box">

                <form id="loginForm" method="post" action="login">
                    <div class="form-group mt-5 mb-2">

                        <label for="correo">Correo: </label>
                        <input type="text" name="correo" id="correo" >

                    </div>
                    <div class="form-group mt-5 mb-2">

                        <label for="contraseña">Contraseña:</label>
                        <input type="password" name="contra" id="contraseña" />


                        <%
                            HttpSession sesion = request.getSession();
                            String mensaje = (String) sesion.getAttribute("mensaje");

                            if (mensaje != null) { %>
                        <p style="color: #ff0000;"><%=mensaje%></p>
                        <% } %>

                    </div>
                    <div class="input-group">
                        <div class="form-check">
                            <br />
                            <label ><a href="solicitudRecuperacion.jsp">¿Olvidaste la contraseña?</a></label>
                        </div>
                    </div>
                    <br />
                    <input class="btn" type="submit" value="Iniciar sesión"/>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
