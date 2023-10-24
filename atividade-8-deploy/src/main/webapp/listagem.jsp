<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ifpb.dev.web.atividade7.banco.BancoDeDadosImp" %>
<%@ page import="com.ifpb.dev.web.atividade7.banco.BancoDeDados" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ifpb.dev.web.atividade7.entidades.Bebida" %>
<html>
<head>
    <title>Listagem de bebidas</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
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
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Concentração alcoolica</th>
        <th>Tipo</th>
        <th>Deletar</th>
        <th>Atualizar</th>
    </tr>
    <%for (Bebida b: bebidas) {%>
        <tr>
            <td><%=b.id()%></td>
            <td><%=b.nome()%></td>
            <td><%=b.teorAlcoolico()%></td>
            <td><%=b.tipo()%></td>
            <td>
                <button type="button" onclick="deletarBebida(<%=b.id()%>)">Deletar</button>
            </td>
            <td>
                <a href="atualizar.jsp?id=<%=b.id()%>">Atualizar</a>
            </td>
        </tr>
    <%}%>
</table>
<a href="criar.jsp">Cadastre uma bebida aqui!</a>
<%} else {%>
<h3>Nenhuma bebida cadastrada!</h3>
<br/>
<a href="criar.jsp">Cadastre uma aqui!</a>
<%}%>
</body>
</html>
