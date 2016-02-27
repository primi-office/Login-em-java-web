package br.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.model.Usuario;
import br.com.repositorio.UsuarioRepositorio;

@WebServlet({"/", "/login", "/autentica", "/logof" })
public class UsuarioControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioRepositorio repositorio = new UsuarioRepositorio();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);

	}
	private void executa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		String path = request.getContextPath();
		String uri = request.getRequestURI();
		if (uri.equalsIgnoreCase(path+"/login") ||uri.equalsIgnoreCase(path + "/")) {
			login(request, response);
		}else if (uri.equalsIgnoreCase(path+"/autentica")) {
			autentica(request, response);
		}else if (uri.equalsIgnoreCase(path+"/logof")) {
			logof(request, response);
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	 
	}
    private void autentica(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		 String method = request.getMethod();
		 if (!method.equalsIgnoreCase("post")) {
			response.sendError(401);
		}else {
			
			String nome = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			
			Usuario usuario = repositorio.buscarPorNome(nome);
			if (usuario !=null && senha !=null && senha.equals(usuario.getSenha())) {
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogado", usuario);
				response.sendRedirect(request.getContextPath()+"/contatos");
			}else{				
				HttpSession session = request.getSession();
				session.setAttribute("login_erro", "Login e senha inválido");
				response.sendRedirect(request.getContextPath()+"/login");				
			}
			
		}
	 
	}
    private void logof(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	
    	HttpSession session  = request.getSession();
    	session.invalidate();
    	response.sendRedirect(request.getContextPath()+"/login");
    	
    }

}