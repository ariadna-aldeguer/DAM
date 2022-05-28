package Bean;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bean
 */


public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		String op=request.getParameter("accion");
		if(op.equals("datos")) { // Obtener los datos*/
			Departamentos dep=(Departamentos)request.getAttribute("depart");
			
 			int num = Integer.valueOf( request.getParameter("dep"));
			String nom = request.getParameter("nom");
			String loc = request.getParameter("loc");

			
			// Ahora llevo datos del servlet a un javabean
			//System.out.println("Abro la página verdatosdeservlet, llevando un objeto departamento");
			
			Departamentos de = new Departamentos(num, nom, loc);
			
			BaseDatos db = new BaseDatos();
			db.insertarDepartamento(de);
			
			request.setAttribute("datos",de); //se preparan para enviar datos al jsp
			
			RequestDispatcher rd =request.getRequestDispatcher("/verdatosservlet.jsp");
			rd.forward(request,response);
	}

}
