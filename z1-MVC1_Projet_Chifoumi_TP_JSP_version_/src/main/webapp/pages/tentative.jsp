<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String[] choix = {
        "CHI",
        "FOU",
        "MI"
    };
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CHIFOUMI</title>
    <style>
        img {
            display: block;
            margin: auto;
        }

        .fenetrePrincipal {
            margin: auto;
            background-color: darkblue;
            color: white;
            text-align: center;
            padding: 20px;
        }

        /* Ajout d'un style pour les div contenant les images */
        .cliqueJoueur {
            margin-bottom: 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Page du Chifoumi</h1>

<h2>Veuillez faire votre choix contre l'IA</h2>
<h2>Cliquez sur l'image correspondante</h2>
<div class="fenetrePrincipal">

    <%
    for (String item : choix) {
        if (item.equals("CHI")) {
    %>
    <div class="cliqueJoueur" onclick="faireChoix('<%= item %>')">
        <h2>CHI</h2>
        <img src="<%= request.getContextPath() %>/images/chi.png" alt="illustration image CHI">
    </div>
    <% } else if (item.equals("FOU")) { %>
    <div class="cliqueJoueur" onclick="faireChoix('<%= item %>')">
        <h2>FOU</h2>
        <img src="<%= request.getContextPath() %>/images/fou.png" alt="illustration image FOU">
    </div>
    <% } else if (item.equals("MI")) { %>
    <div class="cliqueJoueur" onclick="faireChoix('<%= item %>')">
        <h2>MI</h2>
        <img src="<%= request.getContextPath() %>/images/mi.png" alt="illustration image MI">
    </div>
    <% }
    } %>

    <!-- Ajout d'un formulaire pour envoyer le choix sélectionné -->
    <form id="choixForm" method="POST" action="<%= request.getContextPath() %>/chifoumi">
        <input type="hidden" name="choixJoueur" id="choixJoueur" >
    	<button type="submit">Envoyer</button>
    </form>

</div>


<script>
    function faireChoix(choix) {
        document.getElementById("choixJoueur").value = choix;
        document.getElementById("choixForm").submit(); 
    }
</script>