<!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.beans.Product"%>
<%@page import="java.util.List" errorPage="error.jsp"
	isErrorPage="false"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Fruit</title>
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<%-- <%@ include file="header.jsp"%> --%>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- #home -->


	<section id="products" class="section">
		<div class="container">
			<h2 class="headline">Products</h2>

			<%
				if (session.getAttribute("cart") != null) {
			%>
			<p>
				<span id="size"
					title="<%=((ArrayList) session.getAttribute("cart"))%>">Items
					in Cart: <%=((ArrayList) session.getAttribute("cart")).size()%></span>
			</p>
			<%
				} else {
			%>
			<span id="size">Items in Cart :0</span>
			<%
				}
			%>
		</div>


		<div class="productContainer">
			<!-- display products through scriptlet and expression -->
			<%
				List<Product> products = (ArrayList) request.getAttribute("products");
				Iterator<Product> iterator = products.iterator();
				while (iterator.hasNext()) {
					Product product = iterator.next();
			%>
			<form action="addProducts" method="get">

				<div class="productContainerItem">
					<img id="pic1" src="<%=product.getProductImgPath()%>"> <input
						type="text" name="product" value="<%=product.getProductName()%>"><br />
					<button>Add to Cart</button>
				</div>
			</form>
			<%
				}
			%>

		</div>
	</section>
	<!-- #products -->

</body>
</html>