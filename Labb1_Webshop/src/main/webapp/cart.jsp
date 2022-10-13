<%@page import="ui.Cart"%>
<%@page import="ui.ItemInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your cart</h1>
        <%Cart cart = (Cart) session.getAttribute("cart");%>
        <table>
            <tr><td>Name</td><td>Price</td></tr>

            <% for (int i = 0; i < cart.getCart().size(); i++) {%>
            <tr>
                <td><%=cart.getCart().get(i).getName()%></td>
                <td><%=cart.getCart().get(i).getPrice()%></td>
            </tr>
            <%  }%>
        </table>
    </body>
</html>