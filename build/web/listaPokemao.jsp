<%-- 
    Document   : listaPokemao
    Created on : 01/11/2016, 11:02:54
    Author     : strudel
--%>

<%@page import="java.util.List"%>
<%@page import="DAOs.PokemonDAO"%>
<%@page import="models.Pokemon"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
             <%
        PokemonDAO dao = new PokemonDAO();
        List<Pokemon> pokemons = dao.getAll();
        
        
        for (Pokemon pokemon : pokemons ) { 
        %>
        <tr>
          
            
        <td>Nome: <%=pokemon.getName() %></td> <br>
        <td>ID: <%=pokemon.getId() %></td> <br>
        <td>Weight: <%=pokemon.getWeight() %></td> <br>
        <td>Height: <%=pokemon.getHeight() %></td> <br>
        <td>HP: <%=pokemon.getHp() %></td> <br>
        <td>Attack: <%=pokemon.getAttack() %></td> <br>
        <td>Defense: <%=pokemon.getDefense() %></td> <br>
     
        
        <br>
        <br>
        </tr> <%
        }
        %> 
        </body>
    </html>
</f:view>
