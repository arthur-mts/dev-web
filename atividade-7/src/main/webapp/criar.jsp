<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Criar bebida</title>
  <style>
    .entry {
      width: 40vw;
    }
    .entry > label {
      padding-right: 1vw;
      display: inline-block;
      width: 30%;
    }
    .entry > input {
      width: 70%;
    }
  </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/bebida" method="post">
  <div class="entry">
    <label for="nome" >Nome: </label>
    <input id="nome" name="nome" type="text" minlength="5" required/>
  </div>
  <br/>
  <div class="entry">
    <label for="teorAlcolico" >Teor Alcólico: </label>
    <input id="teorAlcolico" name="teor" type="number" min="0" max="100" step="0.1" required/>
  </div>
  <br/>
  <div class="entry">
    <label for="tipo" >Tipo: </label>
    <select id="tipo" name="tipo" required>
      <option>
        Destilado
      </option>
      <option>
        Fermentado
      </option>
    </select>
  </div>
  <br/>
  <input type="submit" value="Enviar">
</form>
</body>
</html>