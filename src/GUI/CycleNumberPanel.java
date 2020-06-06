package GUI;

import Property.Lawn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUIExceptions.ImproperCycleNumberException;

public class CycleNumberPanel extends JPanel implements ActionListener
	{
	private final JTextField field;
	private final JButton setnumber;
	private final PrevStatusPanel psp;
	
	public CycleNumberPanel(PrevStatusPanel psp)
		{
		super();
		this.psp = psp;
		setLayout(new GridBagLayout());
		GridBagConstraints c;
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_END;
		JLabel label = new JLabel("set NO cycles:");
		add(label, c);
		
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		field = new JTextField(3);
		add(field, c);
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		setnumber = new JButton("set");
		setnumber.addActionListener(this);
		setnumber.setPreferredSize(new Dimension(75, 27));
		add(setnumber, c);
		}
		
	public void actionPerformed(ActionEvent action)
		{
		psp.showWait();
		Object source = action.getSource();
		if(source == setnumber)
			{
			String number = field.getText();
			try
				{
				int n = Integer.parseInt(number);
				if(n <= 0)
					throw new ImproperCycleNumberException(n);
				Lawn.setTime(n);
				psp.showOK();
				}
			catch(Exception e)
				{
				psp.showError();
				EventQueue.invokeLater(new Runnable()
					{
					public void run()
						{
						new ErrorFrame(e.getMessage());
						}
					});
				}
			}
		}
	}