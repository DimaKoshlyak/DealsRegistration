package ua.dimakoshlyak.deals;

public class CameraProduct extends Product {

	private double megapx;
	private boolean digital;
	
	public double getMegapx() {
		return megapx;
	}
	public boolean isDigital() {
		return digital;
	}
	
	protected int discountCalc(){
		int dis = super.discountCalc();
		if (!digital){
			dis +=20;
		}
		return dis;
	}
	public void setMegapx(double megapx) {
		this.megapx = megapx;
	}
	public void setDigital(boolean digital) {
		this.digital = digital;
	}
}
