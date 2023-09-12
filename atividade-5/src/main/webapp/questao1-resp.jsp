<jsp:useBean id="avgDistancePerConsumption" scope="request" type="java.lang.Double"/>
<jsp:useBean id="avgSpeed" scope="request" type="java.lang.Double"/>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Questão 1</title>
</head>
<body>

<h1>
    Cálculo de velocidade média
</h1>
<p>Velocidade média: ${"%.1f km/h".formatted(avgSpeed)}</p>
<p>Consumo médio: ${"%.1f km/l".formatted(avgDistancePerConsumption)}</p>
</body>
</html>