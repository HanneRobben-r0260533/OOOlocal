package domain;

public class Movie extends Product{

	
	public Movie(String title, String iD) {
		super(title, iD);
	}

	@Override
	public double getPrice(int days) {
		int price = 5;
		int daysLeft = days - 3;
		if (daysLeft > 0) {
			price += (daysLeft * 2);
		}
		return price;
	}

}
