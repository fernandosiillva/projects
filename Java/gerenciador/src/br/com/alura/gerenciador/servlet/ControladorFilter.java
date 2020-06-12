package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain) throws IOException, ServletException {
				
		System.out.println("ControladorFilter");
		
		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		
		String parameter = request.getParameter("acao");
				
		String nome = null;

		String nomeDaClasse = "br.com.alura.gerenciador.acao." + parameter;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] split = nome.split(":");

		if (split[0].equals("forward")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + split[1]);
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect(split[1]);
		}	
	}

}
