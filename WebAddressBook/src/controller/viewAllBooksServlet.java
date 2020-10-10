//Brogan Avery
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookDetails;

/**
 * Servlet implementation class viewAllShoppingLists
 */
@WebServlet("/viewAllListsServlet")
public class viewAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllBooksServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDetailsHelper slh = new BookDetailsHelper();
		List<BookDetails> abc = slh.getLists();
		request.setAttribute("allLists", abc);
		
		if(abc.isEmpty()){
				request.setAttribute("allLists", " ");
		}

		getServletContext().getRequestDispatcher("/shopping-list-by-user.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}