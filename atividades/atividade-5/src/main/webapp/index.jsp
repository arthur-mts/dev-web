<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Atividade 5 - Desenvolvimento WEB</title>
</head>
<body>
<h1>Atividade 5 - Desenvolvimento WEB</h1>
<p><%= "Olha um número aleatorio: ".concat(String.valueOf(Math.round(Math.random() * 10.0))) %></p>
<h2>Questão 1 (Velocidade)</h2>
<a href="questao1.html">Questão 1</a>

<h2>Questão 2 (Tabuada) </h2>
<form action="${pageContext.request.contextPath}/questao2-servlet" method="post" id="questao2">
    <label for="number">Digite um número: </label>
    <input required id="number" name="number" type="number" step="1" min="1"/>
    <button type="submit">Enviar</button>
</form>

<h2>Questão 3 (Temperatura)</h2>
<form action="${pageContext.request.contextPath}/questao3-servlet" method="post" id="questao3">
    <label for="temperature">Digite a temperatura em graus célsius: </label>
    <input required id="temperature" name="temperature" type="number" step="1" min="1"/>
    <button type="submit">Enviar</button>
</form>
</body>
</html>