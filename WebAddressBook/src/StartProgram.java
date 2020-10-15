//Brogan Avery

import java.util.List;
import java.util.Scanner;

import controller.AddressHelper;
import model.Address;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static AddressHelper lih = new AddressHelper();

		private static void addAnItem() {
			System.out.print("Enter a store: ");
			String store = in.nextLine();
			System.out.print("Enter an item: ");
			String item = in.nextLine();
			
			Address toAdd = new Address(store, item);
			lih.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			System.out.print("Enter the store to delete: ");
			String store = in.nextLine();
			System.out.print("Enter the item to delete: ");
			String item = in.nextLine();
			Address toDelete =	new	Address(store,	item);
			lih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Store");
			System.out.println("2 : Search by Item");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<Address> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the store name: ");
				String storeName = in.nextLine();
				foundItems = lih.searchForItemByStore(storeName);
				
			} 
			
			else {
				System.out.print("Enter the item: ");
				String itemName = in.nextLine();
				foundItems = lih.searchForItemByItem(itemName);

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (Address l : foundItems) {
					System.out.println(l.getId() + " : " + l.returnItemDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Address toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getItem() + " from " + toEdit.getStore());
				System.out.println("1 : Update Store");
				System.out.println("2 : Update Item");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Store: ");
					String newStore = in.nextLine();
					toEdit.setStore(newStore);
				} 
				
				else if (update == 2) {
					System.out.print("New Item: ");
					String newItem = in.nextLine();
					toEdit.setItem(newItem);
				}

				lih.updateItem(toEdit);

			} 
			
			else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			runMenu();
			
		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<Address>	allItems = lih.showAllItems();
			for(Address singleItem : allItems){
				System.out.println(singleItem.returnItemDetails());
			}

		}

	}