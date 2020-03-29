package main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import controller.MainController;
import controller.MainControllerOperations;
import model.Jefe;
import view.MainView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}
		EventQueue.invokeLater(() -> {
			
			MainControllerOperations controller= new MainController(new Jefe(),new MainView());
			controller.start();
			;
		});
		
	 
		

	}

}
