<%@page import="Bean.Departamentos"%>
<%@ page isThreadSafe="false"  %>
<%@ page import="java.util.*" %>
<jsp:useBean id="datos" scope="request" class="Bean.Departamentos" />
<h2> (verdatosservlet.jsp) Los datos recibidos del servlet son estos :</h2>
Departamento:<jsp:getProperty name="datos" property="deptno"/> <br>
Nombre:<jsp:getProperty name="datos" property="dnombre"/> <br>
Localidad: <jsp:getProperty name="datos" property="loc"/>
<%
Bean.Departamentos d =
(Bean.Departamentos)request.getAttribute("datos");//obtener los datos del bean datos
out.write("<p>(verdatosservlet.jsp) Recibo el objeto, estos son los datos:" + 
d.getDeptno()+ ","+ d.getDnombre()+","+d.getLoc()+"</p>");
out.write("<a href='entradabean_y_llamada.jsp'>Volver al formulario </a>");
%>