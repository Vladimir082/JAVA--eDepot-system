package classDirectory;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Depot {
	private static int numberDepot = 0;
	static ArrayList<Driver> dlist = new ArrayList<>();
	static ArrayList<Vehicle> vlist = new ArrayList<>();
	static ArrayList<Manager> mlist = new ArrayList<>();
	static ArrayList<Workschedule> wlist = new ArrayList<>();
	private Manager m1;
	private Driver d1;
	private static Vehicle vSelected;
	
	
	public Depot(int numberDepot) {
		super();
		Depot.numberDepot = numberDepot;
		
		
		//List of driver (name of driver,password,number of depot)
		dlist.add(new Driver("a","a",1));
		dlist.add(new Driver("b","b",1));
		dlist.add(new Driver("f","f",1));
		dlist.add(new Driver("c","c",2));
		dlist.add(new Driver("d","d",2));
		dlist.add(new Driver("e","e",2));
		
		
		//List of manager (name of manager,password,number of depot)
		mlist.add(new Manager("m1","123",1));
		mlist.add(new Manager("m2","123",2));
		
		//List of vehicle (make,model,weight,registration number,depot number)
		vlist.add(new Vehicle("Renault","Escoda",20,"111",1));
		vlist.add(new Vehicle("Renault","Megane",20,"222",1));
		vlist.add(new Vehicle("Volvo","Saxo",20,"333",2));
		vlist.add(new Vehicle("DAF","Escoda",20,"444",1));
		vlist.add(new Vehicle("Mercedes","Megane",20,"555",1));
		vlist.add(new Vehicle("Scania","Saxo",20,"666",2));
		vlist.add(new Vehicle("Foden","Sa",20,"777",2));
		
		//List of existing work schedule (client name,start date,end date,vehicle(Renault,Escoda,weight,registration number,depot) driver(name.password,depot) 
		wlist.add(new Workschedule("Amazon",10,2000,new Vehicle("Renault","Escoda",20,"111",1),new Driver("a","a",1)));
		wlist.add(new Workschedule("Ebay",20,4000,new Vehicle("Volvo","Saxo",20,"333",2),new Driver("d","d",2)));
		/*
		wlist.add(new Workschedule("Tom",200,300,new Vehicle("Skoda","papari",20,"999",1),new Driver("H","H",2)));
		wlist.add(new Workschedule("Tom",500,1000,new Vehicle("Skoda","octavia",20,"112",1),new Driver("S","S",2)));
		wlist.add(new Workschedule("Amazon",1000,1200,new Vehicle("Lambo","mucrielago",20,"223",1),new Driver("T","T",2)));
		*/
		
	}

	public int getNumberDepot() {
		return numberDepot;
	}

	public void setNumberDepot(int numberDepot) {
		Depot.numberDepot = numberDepot;
	}

	public static Vehicle getVehicle(int numberPlate) {
		return new Vehicle();
	}

	public static Driver getDriver(int id) {
		return new Driver();
	}
	
	public static void setupWorkSchedule() {
		
		//User input boolean correct = true;
		String client = JOptionPane.showInputDialog("Enter client name"); 
		int start = Integer.parseInt(JOptionPane.showInputDialog("Enter start date (number)")); 
		int end = Integer.parseInt(JOptionPane.showInputDialog("Enter end date (number)")); 
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	
		boolean exists = false;
		boolean available = true;
		Driver dSelected = null;
		
		 // check user's input
		do {
			String u = JOptionPane.showInputDialog("Enter driver"); 		
			//check if available manager
			for(Manager m: mlist) {				
				if((u.equals(m.getUsername()))&&(m.getDepoNumber() == numberDepot)) {				
					dSelected.setUsername(m.getUsername());
					dSelected.setPassword(m.getPassword());
					dSelected.setDepoNumber(m.getDepoNumber());	
					exists = true;
				}
			}	//check if available driver	
			for(Driver d: dlist) {				
				if((u.equals(d.getUsername()))&&(d.getDepoNumber() == numberDepot)) {
					dSelected = d;
					exists = true;
				}
			}
			//check the status of driver
			for(Workschedule w:wlist) {
				if((w.getCurrentDriver().getUsername().equals(u))&&(w.getStatus().equals("active"))) {
					available = false;
				}
			}
			if(!available) {
				JOptionPane.showMessageDialog(null, "Not available","info", JOptionPane.ERROR_MESSAGE);
			}
			if(!exists) {
				JOptionPane.showMessageDialog(null, "Need to enter an existing driver","info", JOptionPane.ERROR_MESSAGE);
			}
						
		}while((!available)||(!exists));
		
		available =true;
		exists = false;
		Vehicle vSelected = null;
		//user's input
		do {
			String v = JOptionPane.showInputDialog("Enter Vehicle registration number"); 		
			//check if available vehicle from specific depot
			for(Vehicle m: vlist) {				
				if((v.equals(m.getRegisterNumber()))&&(m.getDepotNumber() == numberDepot)) {						
					vSelected = m;
					exists = true;
				}
			}			
			//check the status of vehicle
			for(Workschedule w:wlist) {
				if((w.getCurrentVehicle().getRegisterNumber().equals(v))&&(w.getStatus().equals("active"))) {
					available = false;
				}
			}
			if(!available) {
				JOptionPane.showMessageDialog(null, "Vehicle is not available","info", JOptionPane.ERROR_MESSAGE);
			}
			if(!exists) {
				JOptionPane.showMessageDialog(null, "Need to enter an existing vehicle registration number","info", JOptionPane.ERROR_MESSAGE);
			}
			
		}while((!available)||(!exists));
		
		// A new work schedule created
		wlist.add(new Workschedule(client,start,end,vSelected,dSelected));
		JOptionPane.showMessageDialog(null, "New job has been created", "Information", JOptionPane.DEFAULT_OPTION);
	}
	// move vehicle from one depot to another
	public static void moveVehicle() {
		
		
		boolean exists = false;
		boolean available = true;
		Driver dSelected = null;
		
		do {
			String u = JOptionPane.showInputDialog("Enter driver"); 		
			//check if available manager from specific depot
			for(Manager m: mlist) {				
				if((u.equals(m.getUsername()))&&(m.getDepoNumber() == numberDepot)) {
					System.out.println("You have chosen a manager for the job");
					dSelected.setUsername(m.getUsername());
					dSelected.setPassword(m.getPassword());
					dSelected.setDepoNumber(m.getDepoNumber());	
					exists = true;
				}
			}	// get user's input if is driver available	
			for(Driver d: dlist) {				
				if((u.equals(d.getUsername()))&&(d.getDepoNumber() == numberDepot)) {
					System.out.println("You have chosen a driver for the job");
					dSelected = d;
					exists = true;
				}
			}
			//check the status of current driver
			for(Workschedule w:wlist) {
				if((w.getCurrentDriver().getUsername().equals(u))&&(w.getStatus().equals("active"))) {
					available = false;
				}
			}
			if(!available) {
				JOptionPane.showMessageDialog(null, "Not available","info", JOptionPane.ERROR_MESSAGE);
			}
			if(!exists) {
				JOptionPane.showMessageDialog(null, "Need to enter an existing driver","info", JOptionPane.ERROR_MESSAGE);
			}
			
			System.out.println(available+" driver "+exists);
			
		}while((!available)||(!exists));
		
		available =true;
		exists = false;
		setvSelected(null);
		String v = "";
		do {
			 v = JOptionPane.showInputDialog("Enter vehicle registration number"); 		
			//check if available vehicle from specific depot
			for(Vehicle m: vlist) {				
				if((v.equals(m.getRegisterNumber()))&&(m.getDepotNumber() == numberDepot)) {
					System.out.println("You have chosen a vehicle for the job");						
					setvSelected(m);
					exists = true;
				}
			}			
			// check status of vehicle
			for(Workschedule w:wlist) {
				if((w.getCurrentVehicle().getRegisterNumber().equals(v))&&(w.getStatus().equals("active"))) {
					available = false;
				}
			}
			if(!available) {
				JOptionPane.showMessageDialog(null, "Vehicle not available","info", JOptionPane.ERROR_MESSAGE);
			}else
			if(!exists) {
				JOptionPane.showMessageDialog(null, "Need to enter an existing Vehicle registration number","info", JOptionPane.ERROR_MESSAGE);
			}
			
			System.out.println(available+" car "+exists);
			
		}while((!available)||(!exists));
		//check if exists depot
		int selectedDepo = Integer.parseInt(JOptionPane.showInputDialog("Enter a depot number (number)"));
			
		for(Vehicle vehicle: vlist) {
			if(vehicle.getRegisterNumber().equals(v)) {
				vehicle.setDepotNumber(selectedDepo);
			}
		}
		JOptionPane.showMessageDialog(null, "Vehicle has been moved", "Information", JOptionPane.ERROR_MESSAGE);
		
	}
	
	@SuppressWarnings("unused")
	public void logOn() {
		int selection = 0;
		boolean access = false;
		m1 = new Manager();
		d1 = new Driver();
		
		do {
			String user = JOptionPane.showInputDialog("Enter user"); 
			String pass = JOptionPane.showInputDialog("Enter password"); 
			// check user's credentials-manager
			for(Manager m: mlist) {				
				if((user.equals(m.getUsername()))&&(pass.equals(m.getPassword()))&&(numberDepot == m.getDepoNumber())) {
					System.out.println();
					access = true;
					selection = 1;
					m1.setUsername(user);
					m1.setPassword(pass);
					m1.setDepoNumber(numberDepot);
				}
			}
			// check user's credentials-driver
			for(Driver d: dlist) {				
				if((user.equals(d.getUsername()))&&(pass.equals(d.getPassword()))) {
					access = true;
					selection = 2;
					d1.setUsername(user);
					d1.setPassword(pass);
					d1.setDepoNumber(numberDepot);
				}
			}

			if(!access){
				JOptionPane.showMessageDialog(null, "Credentials do not exist", "Information", JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Access granted: "+user, "Information", JOptionPane.ERROR_MESSAGE);
			}
		}while(!access);
		
		// manager's menu
		vladimir: do {
		if(selection == 1) {
			String options = JOptionPane.showInputDialog("Options:\n[1] Create Workschedule"
					+ "\n[2] Move a vehicle to other Depot"
					+ "\n[3] Check work schedule "
					+ "\n[4] Add a new Driver"
					+ "\n[5] Add a new Vehicle"
					+ "\n[6] Log off"); 
			switch(options) {
			case "1":
				setupWorkSchedule();
				break;
			case "2":
				moveVehicle();
				break;
			case "3":
				String msg = ""; // check current work schedule
				for(Workschedule w:wlist) {
					msg += "Status: "+w.getStatus()+" driver: "+w.getCurrentDriver().getUsername()+" "
							+ "vehicle reg num: "+w.getCurrentVehicle().getRegisterNumber()
							+ "star date: "+w.getStartDate()+ " end date: "+w.getEndDate()
							+ " client : "+w.getClient()+"\n\n";
				}
				JOptionPane.showMessageDialog(null, msg, "Information", JOptionPane.DEFAULT_OPTION);
				break;
				
			case "4":
					addDriver();
				break;				
			case "5":
					addVehicle();
				break;
				
			case "6":
				JOptionPane.showMessageDialog(null, "You have log-out", "Information", JOptionPane.DEFAULT_OPTION);
				logOn();
			default:
				JOptionPane.showMessageDialog(null, "Need to enter 1,2,3 or 4", "Information", JOptionPane.ERROR_MESSAGE);
			}
			
		}else if (selection == 2) {
			String options = JOptionPane.showInputDialog("Options:\n[1] Check jobs"
					+ "\n[2] Log out"); 
			switch(options) {
			case "1":
				checkJobs(d1);
				break;
			case "2":
				JOptionPane.showMessageDialog(null, "You have log-out", "Information", JOptionPane.DEFAULT_OPTION);
				logOn();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Need to enter 1 or 2", "Information", JOptionPane.ERROR_MESSAGE);
			}	
		}
		}while(true);	
	}
	// check driver's job
	public static void checkJobs(Driver d) {
		String msg = "";
		for(Workschedule w:wlist) {
			if(d.getUsername().equals(w.getCurrentDriver().getUsername())) {
				msg += "Status: "+w.getStatus()+" driver: "+w.getCurrentDriver().getUsername()+" "
						+ "vehicle reg num: "+w.getCurrentVehicle().getRegisterNumber()
						+ "star date: "+w.getStartDate()+ " end date: "+w.getEndDate()
						+ " client : "+w.getClient()+"\n\n";
			}
			if(msg.length() < 2) {
				msg = "No jobs available";
			}
			
		}
		JOptionPane.showMessageDialog(null, msg, "Information", JOptionPane.DEFAULT_OPTION);
	}
    // add a new driver to the specific depot
	public static void addDriver() {
		Driver newD = new Driver();
		newD.setUsername(JOptionPane.showInputDialog("Enter a driver username"));
		newD.setPassword(JOptionPane.showInputDialog("Enter a driver password"));
		newD.setDepoNumber(Integer.parseInt(JOptionPane.showInputDialog("Enter a depot number (number)")));
		dlist.add(newD);
		JOptionPane.showMessageDialog(null, "New driver was entered", "Information", JOptionPane.DEFAULT_OPTION);
	}
	// add a new vehicle to the specific depot
	public static void addVehicle() {
		Vehicle newV = new Vehicle();
		newV.setMake(JOptionPane.showInputDialog("Enter the vehicle make"));
		newV.setModel(JOptionPane.showInputDialog("Enter the vehicle model"));
		newV.setWeight(Integer.parseInt(JOptionPane.showInputDialog("Enter the vehicle weight (number)")));
		newV.setRegisterNumber(JOptionPane.showInputDialog("Enter the vehicle registration number (999)"));
		newV.setDepotNumber(Integer.parseInt(JOptionPane.showInputDialog("Enter the vehicle depot number (number)")));	
		vlist.add(newV);
		JOptionPane.showMessageDialog(null, "New Vehicle has been entered", "Information", JOptionPane.DEFAULT_OPTION);
		
		
	}

	public static Vehicle getvSelected() {
		return vSelected;
	}

	public static void setvSelected(Vehicle vSelected) {
		Depot.vSelected = vSelected;
	}


}
