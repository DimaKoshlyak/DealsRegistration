package ua.dimakoshlyak.deals;

import java.util.Date;

public class Deal {

	private Date date = new Date();
	private Party buyer;
	private Party seller;
	private Product[] products;

	public Date getDate() {
		return date;
	}
	public Party getBuyer() {
		return buyer;
	}
	public Party getSeller() {
		return seller;
	}
	public Product[] getProducts() {
		return products;
	}
	
	public Deal (Party buyer, Party seller, Product[] products){
		this.buyer = buyer;
		this.seller = seller;
		this.products = products;
	}
	
	public double getSum(){
		double rez=0;
		for(Product pr:products){
			rez += pr.getCost();
		}
		return rez;
	}
	
}
