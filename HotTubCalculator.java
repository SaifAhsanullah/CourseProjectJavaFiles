package courseProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HotTubCalculator extends JPanel
{
	private JPanel windowFrame; //all the variables for the items for the gui
	private JButton calcBtn;
	private JButton exitBtn;
	private JTextField diameterFld;
	private JTextField depthFld;
	private JTextField tubVolumeFld;
	private JLabel diameterLbl;
	private JLabel depthLbl;
	private JLabel tubVolumeLbl;
	
	public HotTubCalculator()
	{
		//gui components creation
		windowFrame = new JPanel();
		calcBtn = new JButton("Calculate Volume");
		exitBtn = new JButton("Exit");
		diameterFld = new JTextField(7);
		depthFld = new JTextField(7);
		tubVolumeFld = new JTextField(7);
		diameterLbl = new JLabel("Enter diameter of tub: ");
		depthLbl = new JLabel("Enter average depth of tub: ");
		tubVolumeLbl = new JLabel("Volume of tub: ");
		
		windowFrame.setLayout(new BorderLayout());
		setBackground(Color.GRAY);
		
		add(diameterLbl);
		add(diameterFld);
		add(depthLbl);
		add(depthFld);
		add(calcBtn);
		add(exitBtn);
		add(tubVolumeLbl);
		add(tubVolumeFld);
		
		calcBtn.setMnemonic('C');
		exitBtn.setMnemonic('E');
		
		CalcHandler calcHandle = new CalcHandler();
		calcBtn.addActionListener(calcHandle);
		
		ExitHandler exitHandle = new ExitHandler();
		exitBtn.addActionListener(exitHandle);

		FocusHandler focusHandle = new FocusHandler();
		diameterFld.addFocusListener(focusHandle);
		depthFld.addFocusListener(focusHandle);
		tubVolumeFld.addFocusListener(focusHandle);
		
		windowFrame.setVisible(true);
	}
	
	class CalcHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double diameter = 0;
			double depth = 0;
			double volume;
			String input;

			input = diameterFld.getText();
			do{ //verifies input is a number
				try 
				{
					diameter = Double.parseDouble(input);
				}
				catch (NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter numbers only", "ERROR", JOptionPane.WARNING_MESSAGE);
					diameterFld.setText("");
					continue;
				}
			}while (input == "");

			input = depthFld.getText();
			do{ //verifies input is a number
				try 
				{
					depth = Double.parseDouble(input);
				}
				catch (NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter numbers only", "ERROR", JOptionPane.WARNING_MESSAGE);
					depthFld.setText("");
					continue;
				}
			}while (input == "");
			

			volume = Math.PI*((Math.pow((diameter/2), 2))*depth);
			DecimalFormat num = new DecimalFormat("#,###.00");
			tubVolumeFld.setText(num.format(volume));
		}
	}
	
	class FocusHandler implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{
			if (e.getSource() == diameterFld || e.getSource() == depthFld)
			{
				tubVolumeFld.setText("");
			}
			else if (e.getSource() == tubVolumeFld)
			{
				calcBtn.requestFocus();
			}
		}
		public void focusLost(FocusEvent e)
		{
			if (e.getSource() == diameterFld)
			{
				calcBtn.requestFocus();
			}			
		}
	}
	
	class ExitHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			System.exit(0);
		}
	}

}

