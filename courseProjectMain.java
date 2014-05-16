/*
 * Program Name: CourseProject.java
 * Programmer:   Saif Ahsanullah
 * Description:  create a hot tub and pool calculator in a user-friendly gui
 *  */

package courseProject;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import courseProject.PoolCalculator;
import courseProject.HotTubCalculator;

public class courseProjectMain extends JFrame
{
	public courseProjectMain()
	{		
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Pool Calculator", new PoolCalculator());
		jtp.addTab("Hot Tub Calculator", new HotTubCalculator());
		jtp.setBackground(Color.DARK_GRAY);
		jtp.setForeground(Color.LIGHT_GRAY);
		add(jtp);
	}

	public static void main(String[] args) 
	{		
		courseProjectMain obj = new courseProjectMain();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(300,200);
		obj.setVisible(true);
	}

}
