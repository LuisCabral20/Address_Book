//Brogan Avery 
//import java.time.LocalDate;
//import java.util.List;
//
//import controller.ListDetailsHelper;
//import controller.ShopperHelper;
//import model.ListDetails;
//import model.Shopper;
//import controller.LocalDateAttributeConverter;
//
//public class ShoppingTester {
//	public static void main(String[] args) {
//		
//		Shopper bill = new Shopper("Bill");
//		
//		ShopperHelper sh = new ShopperHelper();
//		
//		sh.insertShopper(bill);
//
//		ListDetailsHelper ldh = new ListDetailsHelper();
//		
//		ListDetails billList = new ListDetails("Bill's List", LocalDate.now(), bill);
//		
//		ldh.insertNewListDetails(billList);
//		
//		List<ListDetails> allLists = ldh.getLists();
//			
//		for(ListDetails a : allLists) {
//				System.out.println(a.toString());
//		}
//	}	
//
//}
