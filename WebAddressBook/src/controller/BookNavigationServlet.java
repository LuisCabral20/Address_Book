//Brogan Avery
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookDetails;

/**
 * Servlet implementation class BookNavigationServlet
 */
@WebServlet("/bookNavigationServlet")
public class BookNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookNavigationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				BookDetailsHelper bdh = new BookDetailsHelper();
				String act = request.getParameter("doThisToBook");
		
				if (act == null) {
					// no button has been selected
					getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
		
				} else if (act.equals("delete")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						BookDetails bookToDelete = bdh.searchForBookDetailsById(tempId);
						bdh.deleteBook(bookToDelete);
		
					} catch (NumberFormatException e) {
						System.out.println("Forgot to click a button");
					} finally {
						getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
					}
		
				} else if (act.equals("edit")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						BookDetails bookToEdit = bdh.searchForBookDetailsById(tempId);
						request.setAttribute("bookToEdit", bookToEdit);
						request.setAttribute("month", bookToEdit.getBookStartedDate().getMonthValue());
						request.setAttribute("date", bookToEdit.getBookStartedDate().getDayOfMonth());
						request.setAttribute("year", bookToEdit.getBookStartedDate().getYear());
						AddressHelper daoForAddresses = new AddressHelper();
		
						request.setAttribute("allAddresses", daoForAddresses.showAllAddresses());
		
						if (daoForAddresses.showAllAddresses().isEmpty()) {
							request.setAttribute("allAddresses", " ");
						}
						getServletContext().getRequestDispatcher("/edit-book.jsp").forward(request, response);
					} catch (NumberFormatException e) {
						getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
					}
		
				} else if (act.equals("createNewBook")) {
					AddressHelper daoForAddresses = new AddressHelper();
					request.setAttribute("allAddresses", daoForAddresses.showAllAddresses());
					getServletContext().getRequestDispatcher("/new-book.jsp").forward(request, response);
				}

	}

}