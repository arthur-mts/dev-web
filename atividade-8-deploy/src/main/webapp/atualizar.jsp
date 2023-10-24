<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.ifpb.dev.web.atividade7.banco.BancoDeDadosImp" %>
<%@ page import="com.ifpb.dev.web.atividade7.banco.BancoDeDados" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ifpb.dev.web.atividade7.entidades.Bebida" %>
<%@ page import="com.ifpb.dev.web.atividade7.entidades.Tipo" %>
<!DOCTYPE html>
<html>
<head>
    <title>Atualizar bebida</title>
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
<%String id = request.getParameter("id");%>
<%BancoDeDados bd = new BancoDeDadosImp();%>
<%Bebida bebida = bd.consultar(Integer.parseInt(id));%>
<%System.out.println(bebida);%>
<form action="${pageContext.request.contextPath}/bebida/atualizar" method="post">
    <label for="id" hidden></label>
    <input id="id" name="id" type="number" hidden="hidden" value="<%=bebida.id()%>">
    <div class="entry">
        <label for="nome">Nome: </label>
        <input id="nome" name="nome" type="text" minlength="5" required value="<%=bebida.nome()%>"/>
    </div>
    <br/>
    <div class="entry">
        <label for="teorAlcolico">Teor Alcólico: </label>
        <input id="teorAlcolico" name="teor" type="number" min="0" max="100" step="0.1" required value="<%=bebida.teorAlcoolico()%>"/>
    </div>
    <br/>
    <div class="entry">
        <label for="tipo">Tipo: </label>
        <select id="tipo" name="tipo" required>
            <%if (bebida.tipo().equals(Tipo.FERMENTADO)) {%>
            <option>
                Destilado
            </option>
            <option selected>
                Fermentado
            </option>
            <%} else {%>
            <option selected>
                Destilado
            </option>
            <option>
                Fermentado
            </option>
            <%}%>
        </select>
    </div>
    <br/>
    <input type="submit" value="Enviar">
</form>
</body>
</html>