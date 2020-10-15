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

import model.Address;
import model.Owner;
import model.BookDetails;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewBookServlet")
public class CreateNewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewBookServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddressHelper adh = new AddressHelper();
		String bookName = request.getParameter("bookName");
		System.out.println("Book name: "+ bookName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String ownerName = request.getParameter("ownerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedAddresses = request.getParameterValues("allAddressesToAdd");
		List<Address> selectedAddressesInList = new ArrayList<Address>();
		
		for(int i = 0; i<selectedAddresses.length; i++) {
			System.out.println(selectedAddresses[i]);
			Address c = adh.searchForAddressById(Integer.parseInt(selectedAddresses[i]));
			selectedAddressesInList.add(c);
			
		}
		
		Owner onwer = new Owner(ownerName);
		BookDetails bkd = new BookDetails(bookName, ld, onwer);
		bkd.setBookOfAddresses(selectedAddressesInList);
		BookDetailsHelper bdh = new BookDetailsHelper();
		bdh.insertNewBookDetails(bkd);
		
		System.out.println("Success!");
		System.out.println(bkd.toString());
		
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}