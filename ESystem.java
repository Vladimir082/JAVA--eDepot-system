package classDirectory;
/*@author <i>VladimirKosik</i>
 *@version <i>1.0</i>
*/
import javax.swing.JOptionPane;


public class ESystem {
	
	
	static int[] listDepots = {1,2,3};
	
	public static void main(String[] args) {
		String repeat = "";
		do {
		int chosenDepot = 0;
		boolean ok = true;
		//Ask for a depot number and check it
		do{
			try {
				String dNumber = JOptionPane.showInputDialog("Enter depot number"); 
				chosenDepot = Integer.parseInt(dNumber);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Choose 1,2 ",null,JOptionPane.INFORMATION_MESSAGE);
			}
			
			for(int i = 1 ; i < listDepots.length+1 ;i++) {
				if(chosenDepot == i) {
					ok = false;
					JOptionPane.showMessageDialog(null, "You have chosen depot number: "+i,null,JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}while(ok);
		Depot d = new Depot(chosenDepot);		
		d.logOn();
		
		
		repeat = JOptionPane.showInputDialog("Do you want to exit? Y or N");
		}while(repeat.toUpperCase().equals("N"));
	}
	

}
