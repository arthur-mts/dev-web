<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ifpb.dev.web.atividade7.banco.BancoDeDadosImp" %>
<%@ page import="com.ifpb.dev.web.atividade7.banco.BancoDeDados" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ifpb.dev.web.atividade7.entidades.Bebida" %>
<html>
<head>
    <title>Listagem de bebidas</title>
    <style>
        ul > li {
            margin-bottom: 20px;
        }

        ul > li > button {
            margin-top: 10px;
        }

        ul > li > a {
            margin-left: 10px;
        }
    </style>
    <script>
        function deletarBebida(id) {
            fetch("${pageContext.request.contextPath}/bebida/" + id, {
                method: "delete"
            }).then(r => {
                if (!r.ok) {
                    r.text().then(t => alert("Falha ao deletar bebida: " + t))
                } else {
                    location.reload();
                }
            });
        }
    </script>
</head>
<body>
<%BancoDeDados bd = new BancoDeDadosImp();%>
<%List<Bebida> bebidas = bd.listar(null);%>
<%if (bebidas.size() > 0) { %>
<ul>
    <%for (Bebida b : bebidas) {%>
    <li>
        <strong><%=b.nome()%></strong>
        <br/>
        id: <%=b.id()%>
        <br/>
        <%=b.teorAlcoolico()%>% vol
        <br/>
        <%=b.tipo()%>
        <br/>
        <button type="button" onclick="deletarBebida(<%=b.id()%>)">Deletar</button>
        <a href="atualizar.jsp?id=<%=b.id()%>">Atualizar</a>
    </li>
    <%}%>
</ul>
<a href="criar.jsp">Cadastre uma bebida aqui!</a>
<%} else {%>
<h3>Nenhuma bebida cadastrada!</h3>
<br/>
<a href="criar.jsp">Cadastre uma aqui!</a>
<%}%>
</body>
</html>
