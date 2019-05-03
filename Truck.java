package classDirectory;

public class Truck extends Vehicle {
	private int CargoCapacity;
	
	public Truck() {
		
	}

	public Truck(int cargoCapacity) {
		super();
		CargoCapacity = cargoCapacity;
	}

	public int getCargoCapacity() {
		return CargoCapacity;
	}

	public void setCargoCapacity(int cargoCapacity) {
		CargoCapacity = cargoCapacity;
	}
	
	

}
