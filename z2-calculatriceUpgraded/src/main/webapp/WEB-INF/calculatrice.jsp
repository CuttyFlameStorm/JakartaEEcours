<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
    Double result = (Double)request.getAttribute("resultat");
    %>
     <%
    Double resultop1 = (Double)request.getAttribute("op1");
    %>
     <%
    Double resultop2 = (Double)request.getAttribute("op2");
    %>
      <%
    String resultop = (String)request.getAttribute("op");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{
color : green;
}
h2{
color : red;}
</style>
</head>
<body>
<h1>Calculatrice</h1>
	<main>	
	
	<!-- debut du formulaire -->
		<form action="<%= request.getContextPath() %>/calculetteReady" method="post">
			<div>
				<input type ="number" name="op1" placeholder="ex.5">
			</div>
			<div>
				<select name="op">
					<option>+</option>
					<option>*</option>
					<option>/</option>
					<option>-</option>
					<option>%</option>
		
				</select>
			</div>
			<div>
				<input type ="number" name="op2" placeholder="ex.9">
			</div>
			
			<button type="submit">
				calculer
			</button>
		</form>
	<!-- debut du formulaire -->
	
	<!-- Panneau affichage -->
	<div>
	<h3>resultat</h3>
	<h4><%= resultop1 %> <%= resultop %> <%= resultop2 %> </h4>
	<h4>=</h4>
	<h2><%= result %></h2>
	</div>
	<!-- Fin Panneau affichage -->	
	</main>
	
</body>
</html>