<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!-- En esta página creo el bean y lo cargo con los datos del formulario.-->
<jsp:useBean id="depart" scope="request" class="Bean.Departamentos" />
<jsp:setProperty name="depart" property="deptno" param ="dep"/>
<jsp:setProperty name="depart" property="dnombre" param ="nom"/> 
<jsp:setProperty name="depart" property="loc" param="loc"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h2>ENTRADA DE DATOS DE DEPARTAMENTOS. EN BEAN</h2>
<br/>
<form method="post" action ="Servlet">
<p>Número de departamento: <input name="dep" type="text" size="5"> </p>
<p>Nombre: <input name="nom" type="text" size="15"> </p>
<p>Localidad: <input name="loc" type="text" size="15"> </p>
<input type="submit" name="insertar" value="Insertar departamento.">
<input type="reset" name="cancelar" value="Cancelar entrada.">
</form>
</center>
<br />
<!-- Antes de visualizar pregunto si se ha tecleado el botón insertar -->
<!-- dep, nom, loc son los INPUT del formulario. los visualizo -->


</body>
</html>
