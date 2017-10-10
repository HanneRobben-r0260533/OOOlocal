package domain;

public abstract class Product {
	
	protected String title;
	protected String iD;
	protected boolean beschikbaar;
	
	public Product(String title, String iD){
		setTitle(title);
		setID(iD);
		setBeschikbaar(true);
	}
	
	public abstract double getPrice(int days);

	public String toString(){
		String beschikbaarheid;
		if(beschikbaar) beschikbaarheid = "Beschikbaar";
		else{
			beschikbaarheid = "Uitgeleend";
		}
		return getTitle() + " (" + getID() + "): " + beschikbaarheid;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getID() {
		return iD;
	}

	public void setID(String iD) {
		this.iD = iD;
	}

	public boolean isBeschikbaar() {
		return beschikbaar;
	}

	public void setBeschikbaar(boolean beschikbaar) {
		this.beschikbaar = beschikbaar;
	}
	
	
	

}
