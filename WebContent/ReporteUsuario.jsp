<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	ArrayList<Usuario> datos = new ArrayList<Usuario>();
Class.forName("com.mysql.jdbc.Driver");
try {
	Connection miCX = DriverManager.getConnection("jdbc:mysql://localhost:3306/mibdventas", "root", "81434345Br");
	Statement miStatement = miCX.createStatement();
	String comandoSQL = "select * from usuarios";
	ResultSet rs = miStatement.executeQuery(comandoSQL);
	while (rs.next()) {
		datos.add(new Usuario(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
	}
	rs.close();
	miCX.close();
} catch (Exception e) {
	out.println("Ocurrio un error!!!!");
}
pageContext.setAttribute("losUsuarios", datos);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<style>
.cabecera{
font-weight: bold;
}
</style>

<body>
	<table border="1">
		<tr class="cabecera">
			<td>Id</td>
			<td>Documento</td>
			<td>Nombre</td>
			<td>Correo</td>
			<td>Estado</td>
			<td>Password</td>
			<td>Rol</td>

			<c:forEach var="Usuariostemporal" items="${losUsuarios}">
				<tr>
					<td>${Usuariostemporal.id}</td>
					<td>${Usuariostemporal.documento}</td>
					<td>${Usuariostemporal.nombre}</td>
					<td>${Usuariostemporal.correo}</td>
					<td>${Usuariostemporal.estado}</td>
					<td>${Usuariostemporal.password}</td>
					<td>${Usuariostemporal.rol}</td>
				</tr>
			</c:forEach>
	</table>
	    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
			integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
			integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
			crossorigin="anonymous"></script>
</body>
</html>