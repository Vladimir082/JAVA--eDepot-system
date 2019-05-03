package classDirectory;

public class Tanker extends Vehicle {
	private int LiquidCapacity;
	private String LiquidType;
	
	public Tanker() {	
	}
		
	public Tanker(int liquidCapacity, String liquidType) {
		super();
		LiquidCapacity = liquidCapacity;
		LiquidType = liquidType;
	}
	
	
	public int getLiquidCapacity() {
		return LiquidCapacity;
	}
	public void setLiquidCapacity(int liquidCapacity) {
		LiquidCapacity = liquidCapacity;
	}
	public String getLiquidType() {
		return LiquidType;
	}
	public void setLiquidType(String liquidType) {
		LiquidType = liquidType;
	}

	
	
	
}
