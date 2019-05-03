package classDirectory;

public final class Workschedule extends Thread{
	private String client;
	private int startDate;
	private int endDate;
	private Vehicle currentVehicle;
	private Driver currentDriver;
	private String status = "pending";
	
	public Workschedule() {
		
	}
	
	public Workschedule(String client, int startDate, int endDate, Vehicle v, Driver d) {
		super();
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currentVehicle = v;
		this.currentDriver = d;
		
		this.start();
		
	}
	// change the status: active pending and archived (Thread)
	public void run() {
		
		for(int i = 0;i<=endDate+200;i++) {
			try {
				
				if(i == startDate) {
					status = "active";
					System.out.println("Changed to Active"+toString());
				}
				
				if(i == endDate) {
					status = "Finished";
					System.out.println("Work Finished"+toString());
				}
				
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	
	

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public Vehicle getCurrentVehicle() {
		return currentVehicle;
	}

	public void setCurrentVehicle(Vehicle currentVehicle) {
		this.currentVehicle = currentVehicle;
	}

	public Driver getCurrentDriver() {
		return currentDriver;
	}

	public void setCurrentDriver(Driver currentDriver) {
		this.currentDriver = currentDriver;
	}



	
	@Override
	public String toString() {
		return "Workschedule [client=" + client + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", currentVehicle=" + currentVehicle + ", currentDriver=" + currentDriver + ", status=" + status
				+ "]";
	}
	
}
