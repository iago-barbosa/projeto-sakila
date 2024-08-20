<%-- 
    Document   : sakila
    Created on : 13/08/2024, 15:17:41
    Author     : Senai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
        
        <style>
            td{
                
                border: 1px solid gray;
                
            }
          
              
             h1{
                text-align: center;
                
            }
           .btn-primary {
    padding: 10px 20px; /* Ajuste o padding conforme necessário */
    background-color: #007bff; /* Cor de fundo do botão */
    color: #fff; /* Cor do texto do botão */
    border: none; /* Remove a borda padrão */
    border-radius: 5px; /* Arredonda os cantos do botão */
    cursor: pointer; /* Muda o cursor para uma mãozinha */
}
           
            
        </style>
        
    </head>
    <body>
        <h1>sakila</h1>
        <a href="./NovoFilme" class="btn btn-primary"> CADASTRAR FILMES</a> 
        <table class="tabela-filmes m-auto" >
            <thead>
                <tr> 
                    <td class="p-3">ID</td>
                    <td class="p-3">TITULO</td>
                    <td class="p-3">DESCRICAO</td>
                    <td class="p-3">ANO</td>
                    <td>AÇÕES</td>
                    
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="filme" items="${lista}" begin="1000">
            
                <tr>
                    <td class="p-3">${filme.film_id}</td>
                    <td class="p-3">${filme.title}</td>
                    <td class="p-3">${filme.description}</td>
                    <td class="p-3">${filme.release_year}</td>
                    <td>  
                        <a href="./editar?filme=${filme.film_id}"> <%-- O PONTO DE INTERROGAÇÃO SERVE PARA DEFINIR O PARÂMETRO--%>
                        <button type="button" class="btn btn-danger">Excluir</button>
                        <button type="button" class="btn btn-warning">Editar</button> 
                        </a>
                    </td>
                </tr>
        

        </c:forEach>
            </tbody>
        </table>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
