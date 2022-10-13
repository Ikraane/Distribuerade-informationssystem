<%@page import="ui.Cart"%>
<%@page import="ui.ItemInfo"%>
<%@page import="bo.ItemHandler"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.Item"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            #myform1{
                position:absolute;
                float:right;
                top: 60px;
                right: 16px;
            }
            .topRight{
                position: absolute;
                top: 8px;
                right: 16px;
                font-size: 18px;
            }
        </style>
    </head>
    <body>
        <%
            ArrayList<ItemInfo> items = new ArrayList<>();
            Cart cart = new Cart();
        %>

        <h1>Search The Catalog</h1>
        <form id="myform1" action="cart.jsp">
            <input type="submit" value="cart"><br/>
        </form>

        <form action="web.jsp" method ="post">
            <input type="text" placeholder="Search.." name="search">
            <input type="submit" value="Search"><br/>
        </form>

        <%
            if (request.getParameter("search") != null) {
                items = ItemHandler.getItems(request.getParameter("search"));
                session.setAttribute("searchedItems", items);
            }
            items = (ArrayList) session.getAttribute("searchedItems");
            if (items != null) {
        %>

        <table>
            <tr><td>Name</td><td>Price</td></tr>

            <% for (int i = 0; i < items.size(); i++) {%>
            <tr>
                <td><%=items.get(i).getName()%></td>
                <td><%=items.get(i).getPrice()%></td>
                <td>
                    <form action="web.jsp" method ="post">
                        <button type ="submit" name="button" value=<%=i%>>Add to cart</button>
                    </form>
                </td>
            </tr>
            <%  } %>
        </table>
        <%  }
            String buttonId = request.getParameter("button");
            if (buttonId != null) {
                cart.addToCart(items.get(Integer.parseInt(buttonId)));
                session.setAttribute("cart", cart);
            }
        %>

        <div class = "topRight">
            <p>
                <% if (cart.getCart().isEmpty()) {%>
                Empty cart
                <% } else {%>
                Number of items in cart: <%=cart.getCart().size()%>
                <%}%>
            </p>
        </div>
    </body>
</html>