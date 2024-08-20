<%-- 
    Document   : NovoFilme
    Created on : 13/08/2024, 17:11:31
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
        
        <style>
            h1{
                text-align: center;
                color: blue
            }
            .form-container {
                width: 80%;
                margin: 0 auto;
            }
            .btn-secondary {
                
               
                margin: 0 auto;
                
            }
            
            
        </style>
        
    </head>
    <body>
        <h1>CADASTRAR FILME</h1>
        <form action="./NovoFilme" class="form-container" method="post">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInput" name="titulo" placeholder="TITULO">
            <label for="floatingInput">Título</label>
        </div>
            
        <div class="form-floating" >
            <input type="text" class="form-control" id="floatingPassword" name="descricao" placeholder="DESCRIÇÃO">
            <label for="floatingPassword">Descrição</label>
        </div>
            
        <div class="form-floating" >
            <input type="number" class="form-control" id="floatingPassword" name="ano" placeholder="ANO">
            <label for="floatingPassword">Ano</label>
        </div>
            
             <div class="form-floating mb-3">
                <button class="btn btn-secondary" type="submit">Cadastrar</button>
            </div>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
