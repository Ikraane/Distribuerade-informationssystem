package com.test.servlets;

import com.test.beans.Product;
import com.test.dao.DBUser;
import com.test.dao.DBConnection;
import com.test.dao.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addProducts")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//get the HTTPSession object
		HttpSession session = request.getSession();
		
		//create a cart as arraylist for the user
		List<String> cart = (ArrayList<String>)session.getAttribute("cart");
		
		if(cart==null){
			cart = new ArrayList<>();
		}

		//add the selected product to the cart
		if(request.getParameter("product")!=null){
			cart.add(request.getParameter("product"));
		}
		
		session.setAttribute("cart", cart);


		//get search criteria from search servlet
		
		String search = (String)session.getAttribute("search");
		
		
		//get the search results from dao
		Connection connection = DBConnection.getConnectionToDatabase();
				/*(Connection)getServletContext().getAttribute("dbconnection");*/
		List<ProductDB> products = ProductDB.searchProducts(search, connection);
		
		//set the search results in request scope
		request.setAttribute("products", products);
		
		//forward to searchResults.jsp
		request.getRequestDispatcher("/searchResults.jsp").forward(request, response);


	}


	
}