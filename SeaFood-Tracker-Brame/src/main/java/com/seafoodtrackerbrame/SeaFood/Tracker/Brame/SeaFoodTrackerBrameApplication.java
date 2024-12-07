package com.seafoodtrackerbrame.SeaFood.Tracker.Brame;

import GUI.Login;
import javax.swing.SwingUtilities;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class 	SeaFoodTrackerBrameApplication {

	public static void main(String[] args) {
                System.setProperty("java.awt.headless", "false");
		SpringApplication.run(SeaFoodTrackerBrameApplication.class, args); 
                

                SwingUtilities.invokeLater(()->{
                Login LoginFrame = new Login();
                LoginFrame.setVisible(true);
                LoginFrame.pack();
                LoginFrame.setLocationRelativeTo(null);
	});
        }

}
