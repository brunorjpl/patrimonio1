package edu.infnet.patrimonio.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.infnet.patrimonio.modelo.Patrimonio;
import edu.infnet.patrimonio.negocio.servico.PatrimonioService;

@WebServlet(name="PatrimonioServlet", urlPatterns = {"/PatrimonioSrv"})
public class PatrimonioServlet extends HttpServlet{
	
	private PatrimonioService service;
	
	private List<Patrimonio> listarPatrimonio;
	
	
	public PatrimonioServlet() {
		service = new PatrimonioService();
		
	}
	
	private static final long serialVersionUID = 1L;
	

	
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
			String action = req.getParameter("action");
			String pagina = "patrimonio_list.jsp";
			
			if("new".equals(action)) {
				pagina = "patrimonio_cadastro.jsp";
				resp.sendRedirect("patrimonio_list.jsp");
			}
			
			listarPatrimonio = service.listaPatrimonio();
			req.setAttribute("patrimonio", listarPatrimonio);
			req.getRequestDispatcher("patrimonio_list.jsp").forward(req, resp);						

			
		}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String action = req.getParameter("action");		
			
			if("new".equals(action)) {
				Patrimonio patrimonio = iniciarPatrimonio(req);
				service.salvarPatrimonio(patrimonio);
			}
			
			listarPatrimonio = service.listaPatrimonio();
			req.setAttribute("patrimonio", listarPatrimonio);			
			req.getRequestDispatcher("patrimonio_list.jsp").forward(req, resp);
			
			
			
			
		}
		

		
		private Patrimonio iniciarPatrimonio(HttpServletRequest req) {			

			
			String identificacao = req.getParameter("numero");
			String nome = req.getParameter("nome");
			String local = req.getParameter("local");			
			
			return new Patrimonio(identificacao, nome, local);
		}

}
