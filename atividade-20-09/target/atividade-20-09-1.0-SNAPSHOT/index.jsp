<%@ page import="com.ifpb.edu.web.atividade2009.Contato" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ifpb.edu.web.atividade2009.ListaTelefonica" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listagem de contatos</title>
    <style>
        .container {
            display: flex;
        }
        .container > a {
            flex-shrink: 0;
            height: 100%;
        }
        .container > ul {
            margin-right: 8vh;
        }
    </style>
</head>
<body>
<h1>Sua lista telefônica</h1>


<div class="container">

    <% if( ListaTelefonica.listarContatos().size() > 0) {%>
    <ul>
        <%for (Contato contato : ListaTelefonica.listarContatos()) { %>
        <li>
            <%=contato.getNome()%>: <%=contato.getNumero()%>
            <%if(contato.getEmail() != null && !contato.getEmail().isBlank()){ %>
            <br/>
            Email: <%=contato.getEmail()%>
            <%}%>
        </li>
        <br/>
        <%}%>
    </ul>
    <%}%>

    <a href="cadastro.jsp">Cadastrar novo contato</a>
</div>



</body>
</html>