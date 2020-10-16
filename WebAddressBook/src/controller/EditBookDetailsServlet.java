//Brogan Avery
package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookDetails;
import model.Address;
import model.Owner;

/**
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editBookDetailsServlet")
public class EditBookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBookDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDetailsHelper bdh = new BookDetailsHelper();
		AddressHelper adh = new AddressHelper();
		OwnerHelper oh = new OwnerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		BookDetails bookToUpdate = bdh.searchForBookDetailsById(tempId);

		String newBookName = request.getParameter("bookName");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String ownerName = request.getParameter("ownerName");
		//find our add the new shopper
		Owner newOwner = oh.findOwner(ownerName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
			//items are selected in list to add
			String[] selectedAddresses = request.getParameterValues("allAddressesToAdd");
			List<Address> selectedAddressesInBook = new ArrayList<Address>();

			for (int i = 0; i < selectedAddresses.length; i++) {
				System.out.println(selectedAddresses[i]);
				Address c = adh.searchForAddressById(Integer.parseInt(selectedAddresses[i]));
				selectedAddressesInBook.add(c);

			}
			bookToUpdate.setBookOfAddresses(selectedAddressesInBook);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Address> selectedAddressesInBook = new ArrayList<Address>();
			bookToUpdate.setBookOfAddresses(selectedAddressesInBook);
		}

		bookToUpdate.setBookName(newBookName);
		bookToUpdate.setBookStartedDate(ld);
		bookToUpdate.setOwner(newOwner);
		bdh.updateBook(bookToUpdate);
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
	}

}