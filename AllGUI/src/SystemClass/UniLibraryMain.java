package SystemClass;

import GUI.LoginFrame;

public class UniLibraryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniLibrarySys.readEmployeeFromFile();
		LoginFrame lf = new LoginFrame();
		lf.setVisible(true);

	}

}
