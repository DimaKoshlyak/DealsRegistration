package ua.dimakoshlyak.deals;

import java.util.Scanner;

/**
 * 
 * @author DimaKoshlyak
 *
 */
public class Program {
	private Deal[] deals;
	private final int MAX_PRODUCT = 2;
	private final static int MAX_DEALS = 1;
	public static void main(String[] args) {
		new Program().allActions();
	}
		
	private void allActions(){	
		input();
		System.out.println("---------------------");
		output();
	}
		
	private void output(){
		for (Deal deal : deals){
			System.out.println(deal.getDate());
			System.out.println("Buyer - " + deal.getBuyer().getName() + ",Seller - " + deal.getSeller().getName());
			for (Product pr: deal.getProducts()){
				System.out.println(pr.getTitle() + " " + pr.getQty() +  " " + pr.getPrice() +  " Total:" + pr.getCost());
			}
			System.out.println("Sum =" + deal.getSum());
		}
	}
	
		private void input(){
		deals = new Deal[MAX_DEALS];
		for(int i = 0; i<deals.length; i++){
			System.out.println("Deal " + (i+1) + " from " + deals.length + ":");
			deals[i]=inputDeals();
		}
	};

	
	private Deal inputDeals(){
	System.out.println("Enter Deal information!");
	System.out.println("Enter buyer --->");
	Party buyer = inputParty();
	
	System.out.println("Etner seller --->");
	Party seller = inputParty();
	
	Product products[] = new Product[MAX_PRODUCT];
	
	for (int i = 0; i < products.length; i++ ){	
		products[i]=inputProduct();
	}
	
	Deal deal = new Deal(buyer, seller, products);
	return deal;
	
	}
	
	private Product inputProduct(){
		String selection = keyboard("Please select: 1 - camera, 2 - boots");
	
		String productTitle = keyboard("Enter product title");
		String productPrice = keyboard("Enter product price");
		String productQty= keyboard("Enter product quantyty");
		Product pr = null;
	
		if(selection.equals("1")){
			CameraProduct cam = new CameraProduct();
			String cameraType = keyboard("Is camera digital? Digital - type 'true', non digital - type 'false':");
			String cameraMPX = keyboard("Enter camera megapixels");
			cam.setDigital(Boolean.valueOf(cameraType));
			cam.setMegapx(Double.valueOf(cameraMPX));
			pr = cam;
		}else if(selection.equals("2")){
			BootsProduct boots = new BootsProduct();
			String bootsColor = keyboard("Enter boots color:");
			String bootsSize = keyboard("Enter boots size:");
			boots.setColor(bootsColor);
			boots.setSize(Integer.valueOf(bootsSize));
			pr = boots;
		}else{
			System.out.println("Unknown product!");
			System.exit(-1);
		}
		pr.setTitle(productTitle);
		pr.setPrice(Double.valueOf(productPrice));
		pr.setQty(Integer.valueOf(productQty));
		return pr;
	}
	
	private Party inputParty(){
		String partyName= keyboard ("Enter party name");
		Party part = new Party();
		part.setName(partyName);
		return part;
	}
	
	private String keyboard(String message){
		Scanner scanner = new Scanner(System.in);
		System.out.println(message + ":");
		String rez = scanner.next();
		return rez;
	}
}
