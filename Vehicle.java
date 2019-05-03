package classDirectory;

public class Vehicle {

	protected String make;
	protected String model;
	protected int weight;
	protected String registerNumber;
	protected int depotNumber;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String make, String model, int weight, String registerNumber,int depotNumber) {
		super();
		this.make = make;
		this.model = model;
		this.weight = weight;
		this.registerNumber = registerNumber;
		this.depotNumber = depotNumber;
	}
	

	public int getDepotNumber() {
		return depotNumber;
	}

	public void setDepotNumber(int depotNumber) {
		this.depotNumber = depotNumber;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public static boolean isAvailable() {
		boolean available = true;
		return available;
	}

	public static void setSchedule() {
		
	}
}
