package ua.dimakoshlyak.deals;

abstract class Product {
	private static final int DISCOUNT = 0;
	private String title;
	private double price;
	private int qty;
	
	public double getCost() {
		double priceWODiscount = price * qty; 
		return priceWODiscount - priceWODiscount*discountCalc()/100;
	}
	
	protected int discountCalc(){
		if(qty>10){
			return DISCOUNT;
		} else {
			return 0;
		}
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
