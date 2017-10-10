package domain;

public class CD extends Product{

	public CD(String title, String iD) {
		super(title, iD);
}

	@Override
	public double getPrice(int days) {
		return 1.5 * days;
	}
}
