package domain;

public class Game extends Product {

	
	public Game(String title, String iD) {
		super(title, iD);
	}

	@Override
	public double getPrice(int days) {
		return 3 * days;
	}
	
	

}
