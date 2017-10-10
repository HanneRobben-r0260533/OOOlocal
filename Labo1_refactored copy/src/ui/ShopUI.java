package ui;

import javax.swing.JOptionPane;

import db.Shop;
import domain.CD;
import domain.Game;
import domain.Movie;
import domain.Product;


public class ShopUI {

	public void start(){
		
		Shop shop = new Shop();
		Product product = new Movie("test movie", "IDmovie");
		Product product2 = new Game("test game", "IDgame");
		Product product3 = new CD("test cd", "IDcd");
		shop.addProduct(product);
		shop.addProduct(product2);
		shop.addProduct(product3);

		String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Show all products\n5. Borrow Item\n6. Return Item\n\n0. Quit";
		int choice = -1;
		while (choice != 0) {
			String choiceString = JOptionPane.showInputDialog(menu);
			choice = Integer.parseInt(choiceString);
			if (choice == 1) {
				addProduct(shop);
			} else if (choice == 2) {
				showProduct(shop);
			} else if (choice == 3){
				showPrice(shop);
			} else if (choice == 4){
				showAllProducts(shop);
			} else if (choice == 5){
				BorrowItem(shop);
			} else if (choice == 6){
				ReturnItem(shop);
			}
		}
		
	}
	
	private void ReturnItem(Shop shop) {
		String id = JOptionPane.showInputDialog("Enter the id:");
		boolean found = false;
		for(int i = 0; i < shop.getProducten().size() && !found; i++){
			if(shop.getProducten().get(i).getID().equals(id)){
				found = true;
			}
		}
		if(found){
			shop.findProduct(id).setBeschikbaar(true);
			JOptionPane.showMessageDialog(null, "The product is returned! Thanks!");
		}
		
	}

	private void BorrowItem(Shop shop) {
		String id = JOptionPane.showInputDialog("Enter the id:");
		boolean found = false;
		for(int i = 0; i < shop.getProducten().size() && !found; i++){
			if(shop.getProducten().get(i).getID().equals(id)){
				found = true;
			}
		}
		if(found){
			String daysString = JOptionPane.showInputDialog("Enter the number of days:");
			int days = Integer.parseInt(daysString);
			shop.findProduct(id).setBeschikbaar(false);
			JOptionPane.showMessageDialog(null, "The product is borrowed! The rental price for " + days + " days is: €" + shop.findProduct(id).getPrice(days));
		}
	}

	private void showAllProducts(Shop shop) {
		JOptionPane.showMessageDialog(null, shop.toString(),"Product overview", JOptionPane.INFORMATION_MESSAGE);
	}

	private void addProduct(Shop shop) {
		String title = JOptionPane.showInputDialog("Enter the title:");
		String id = JOptionPane.showInputDialog("Enter the id:");
		String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/C for cd):");
		
		if(type.equals("M")){
			Product product = new Movie(title, id);
			shop.addProduct(product);
		}
		if(type.equals("G")){
			Product product = new Game(title, id);
			shop.addProduct(product);
		}
		if(type.equals("C")){
			Product product = new CD(title, id);
			shop.addProduct(product);
		}
		
		
				
	}

	private void showPrice(Shop shop) {
		String id = JOptionPane.showInputDialog("Enter the id:");
		boolean found = false;
		for(int i = 0; i < shop.getProducten().size() && !found; i++){
			if(shop.getProducten().get(i).getID().equals(id)){
				found = true;
			}
		}
		if(found){
			String daysString = JOptionPane.showInputDialog("Enter the number of days:");
			int days = Integer.parseInt(daysString);
			JOptionPane.showMessageDialog(null, "The rental price for " + days + " days is: €" + shop.findProduct(id).getPrice(days));
		}
		
	}

	private void showProduct(Shop shop) {
		String id = JOptionPane.showInputDialog("Enter the id:");
		if(shop.findProduct(id) != null){
			JOptionPane.showMessageDialog(null, shop.findProduct(id).toString());
		}
		else{
			JOptionPane.showMessageDialog(null,"Not found");
		}
		
	}

	
}
