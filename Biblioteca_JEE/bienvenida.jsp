<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Bienvenido</title>
	</head>
	<body>
		<%
			String usuario = request.getParameter("usuario");
			String iniciado = request.getParameter("iniciado");
			String method = request.getParameter("method");
			StringBuilder pepe = new StringBuilder();
			if (iniciado.equals("false")){
				pepe.append("<h1>Conectado a la BD</h1>");
			}
			pepe.append("<h1>Bienvenido usuario " + usuario + " (llamada " + method + ")</h1>");
			out.println(pepe.toString());
		%>
		<form method=GET action=ConsultaLibrosServlet>
			Selección de Libro: <input type="text" name="titulo"><br><br>
			<input type="submit" value="Consulta Libros" name="submit">
		</form>
	</body>
</html>