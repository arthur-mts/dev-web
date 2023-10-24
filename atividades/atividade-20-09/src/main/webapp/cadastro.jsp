<%--
  Created by IntelliJ IDEA.
  User: arthur
  Date: 20/09/2023
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de contatos</title>
    <style>
        form > label {
            width: 4vw;
            max-width: 4vw;
            padding-right: 1vw;
            display: inline-block;
            margin-bottom: 12px;
        }

        form > input[type="submit"] {
            padding: 2px 12px;
        }
        form > input[name="numero1"]:valid {
            background-color: palegreen;
        }
        form > input[name="numero1"]:invalid {
            background-color: red;
        }
    </style>
</head>
<body>
<h2>Cadastro de contato</h2>
<form action="${pageContext.request.contextPath}/cadastro" method="post">
    <label for="nome">Nome: </label>
    <input type="text" name="nome" id="nome" required>
    <br/>
    <label for="numero">Telefone: </label>
    <input type="text" name="numero" id="numero" required pattern="\(\d{2}\)\s?9\d{4}(\s|-)?\d{4}$" title="Digite um telefone do tipo: (83)91111-1111">
    <br/>
    <label for="email">Email: </label>
    <input type="email" name="email" id="email">
    <br/>
    <input type="submit" value="Enviar">
</form>
</body>
</html>
