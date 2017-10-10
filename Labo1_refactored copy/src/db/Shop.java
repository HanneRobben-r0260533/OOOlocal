package db;

import java.util.ArrayList;

import domain.Product;

public class Shop {

	private ArrayList<Product> producten;
	
	public Shop(){
		producten = new ArrayList<Product>();
	}
	
	public String toString(){
		String output = "";
		for(Product p: producten){
			output += p.toString() +"\n";
		}
		return output;
	}
	
	public void addProduct(Product product){
		if(product != null){
			producten.add(product);
		}
	}
	
	public Product findProduct(String iD){
		for(Product p: producten){
			if(p.getID().equals(iD)){
				return p;
			}
		}
		return null;
	}

	public ArrayList<Product> getProducten() {
		return producten;
	}
	
	
	
}
