package classDirectory;

import javax.swing.JOptionPane;

public class Driver {
	
	protected String username;
	protected String password;
	protected int depoNumber;
	
	public Driver() {
		
	}

	public Driver(String username, String password, int number) {		
		this.username = username;
		this.password = password;
		this.depoNumber = number;
	}
	
	
	
	public int getDepoNumber() {
		return depoNumber;
	}

	public void setDepoNumber(int depoNumber) {
		this.depoNumber = depoNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	@Override
	public String toString() {
		return "Driver [username=" + username + ", password=" + password + ", depoNumber=" + depoNumber + "]";
	}

	//ACTIONS
	public boolean checkPassword(String uInput, String uPass) {
		boolean accepted = false;

		if(accepted) {
			JOptionPane.showMessageDialog(null, "accepted", "Information", JOptionPane.ERROR_MESSAGE);
		}		
		return accepted;
	} 
	
	
}
