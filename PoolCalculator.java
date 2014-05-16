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

public class PoolCalculator extends JPanel
{
	private JPanel windowFrame; //all the variables for the items for the gui
	private JButton calcBtn;
	private JButton exitBtn;
	private JTextField lengthFld;
	private JTextField widthFld;
	private JTextField depthFld;
	private JTextField poolVolumeFld;
	private JLabel lengthLbl;
	private JLabel widthLbl;
	private JLabel depthLbl;
	private JLabel poolVolumeLbl;
	
	public PoolCalculator()
	{
		//gui components creation
		windowFrame = new JPanel();
		calcBtn = new JButton("Calculate Volume");
		exitBtn = new JButton("Exit");
		lengthFld = new JTextField(7);
		widthFld = new JTextField(7);
		depthFld = new JTextField(7);
		poolVolumeFld = new JTextField(7);
		lengthLbl = new JLabel("Enter length of pool: ");
		widthLbl = new JLabel("Enter width of pool: ");
		depthLbl = new JLabel("Enter average depth of pool: ");
		poolVolumeLbl = new JLabel("Volume of pool: ");
		
		windowFrame.setLayout(new BorderLayout());
		setBackground(Color.GRAY);
		
		add(lengthLbl);
		add(lengthFld);
		add(widthLbl);
		add(widthFld);
		add(depthLbl);
		add(depthFld);
		add(calcBtn);
		add(exitBtn);
		add(poolVolumeLbl);
		add(poolVolumeFld);
		
		calcBtn.setMnemonic('C');
		exitBtn.setMnemonic('E');
		
		CalcHandler calcHandle = new CalcHandler();
		calcBtn.addActionListener(calcHandle);
		
		ExitHandler exitHandle = new ExitHandler();
		exitBtn.addActionListener(exitHandle);

		FocusHandler focusHandle = new FocusHandler();
		widthFld.addFocusListener(focusHandle);
		lengthFld.addFocusListener(focusHandle);
		depthFld.addFocusListener(focusHandle);
		poolVolumeFld.addFocusListener(focusHandle);
		
		windowFrame.setVisible(true);
	}
	
	class CalcHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double width = 0;
			double length = 0;
			double depth = 0;
			double volume;
			String input;

			input = widthFld.getText();
			do{ //verifies input is a number
				try 
				{
					width = Double.parseDouble(input);
				}
				catch (NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter numbers only", "ERROR", JOptionPane.WARNING_MESSAGE);
					widthFld.setText("");
					continue;
				}
			}while (input == "");

			input = lengthFld.getText();
			do{ //verifies input is a number
				try 
				{
					length = Double.parseDouble(input);
				}
				catch (NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter numbers only", "ERROR", JOptionPane.WARNING_MESSAGE);
					lengthFld.setText("");
					continue;
				}
			}while (input == "");	
			
			input = depthFld.getText();
			do{
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
			

			volume = length * width * depth;
			DecimalFormat num = new DecimalFormat("#,###.00");
			poolVolumeFld.setText(num.format(volume));
		}
	}
	
	class FocusHandler implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{
			if (e.getSource()==lengthFld || e.getSource() == widthFld || e.getSource() == depthFld)
			{
				poolVolumeFld.setText("");
			}
			else if (e.getSource() == poolVolumeFld)
			{
				calcBtn.requestFocus();
			}
		}
		public void focusLost(FocusEvent e)
		{
			if (e.getSource() == lengthFld)
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
