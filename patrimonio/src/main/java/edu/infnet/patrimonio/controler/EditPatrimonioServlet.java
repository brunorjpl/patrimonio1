package edu.infnet.patrimonio.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.infnet.patrimonio.modelo.Patrimonio;
import edu.infnet.patrimonio.negocio.servico.PatrimonioService;

@WebServlet(name="patrimonio_edit", urlPatterns = "/EditPatrimonioSrv")
public class EditPatrimonioServlet extends HttpServlet {
	
	private PatrimonioService service;
	
	public EditPatrimonioServlet() {
		
		service = new PatrimonioService();
	}
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		Patrimonio patrimonio = service.buscarID(id);
		req.setAttribute("patrimonio", patrimonio);
        req.getRequestDispatcher("patrimonio_edit.jsp").forward(req, resp);
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String identificacao = req.getParameter("numero");
		String nome = req.getParameter("nome");
		String local = req.getParameter("local");
		
		Patrimonio patrimonio = service.buscarID(id);
		
		patrimonio.setIdentificacao(identificacao);
		patrimonio.setNome(nome);
		patrimonio.setLocal(local);
		
		service.editarPatrimonio(patrimonio);
		
		resp.sendRedirect(req.getContextPath());
	}

}
