package br.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/contatos")
public class ContatoControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 executa(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 executa(request, response);
	}
	
	private void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uri = request.getRequestURI();
		 String path = request.getContextPath();
		 if (uri.equals(path+"/contatos")) {
			request.getRequestDispatcher("/contatos.jsp").forward(request, response);
		}
	}

}
