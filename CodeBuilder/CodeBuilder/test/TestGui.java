package CodeBuilder.test;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import CodeBuilder.Objects.*;
import CodeBuilder.Objects.Object;
import CodeBuilder.WriteFiles.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

public class TestGui 
{

	private JFrame frmCodebuilder;
	private JTextField textField;
	private JTextField textField_1;
	private ArrayList<Object>Objects;
	private String FileName;
	private String Path;
	
	private Boolean isRadio;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private WriteCFile wfc;
	private WriteAppCFile wfappc;
	
	
	private class OBJECT_TYPE
	{
		private static final int TYPE_LED = 1;
		private static final int TYPE_TIMER = 2;
		private static final int TYPE_SENDER = 3;
		private static final int TYPE_RECEIVER = 4;	
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					TestGui window = new TestGui();
					window.frmCodebuilder.setResizable(false);
					window.frmCodebuilder.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestGui()
	{
		Objects = new ArrayList<Object>();
		Objects.add(new Main());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmCodebuilder = new JFrame();
		frmCodebuilder.setTitle("CodeBuilder");
		frmCodebuilder.setBounds(100, 100, 1000, 600);
		frmCodebuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCodebuilder.getContentPane().setLayout(null);
		frmCodebuilder.getContentPane().setVisible(false);
		
		final JComboBox comboBox = new JComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Object", "LED", "Timer", "Sender", "Receiver"}));
		comboBox.setBounds(105, 7, 127, 24);
		frmCodebuilder.getContentPane().add(comboBox);
		
		JLabel lblObject = new JLabel("Object");
		lblObject.setBounds(12, 12, 70, 15);
		frmCodebuilder.getContentPane().add(lblObject);
		
		JButton btnGenerateCode = new JButton("Generate");
		btnGenerateCode.setBounds(66, 223, 117, 25);
		frmCodebuilder.getContentPane().add(btnGenerateCode);
				
		final JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 36, 220, 175);
		panel.setVisible(false);
		frmCodebuilder.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(50, 138, 117, 25);
		panel.add(btnAdd);
		
		final JLabel lblName = new JLabel("Name");
		lblName.setBounds(6, 12, 70, 15);
		panel.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(94, 10, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		final JLabel lblProperty = new JLabel("Property");
		lblProperty.setBounds(6, 48, 70, 15);
		panel.add(lblProperty);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 46, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		final JRadioButtonMenuItem rdbtnmntmAppcFile = new JRadioButtonMenuItem("AppC file");
		buttonGroup.add(rdbtnmntmAppcFile);
		rdbtnmntmAppcFile.setBounds(262, 12, 141, 19);
		frmCodebuilder.getContentPane().add(rdbtnmntmAppcFile);
		
		JRadioButtonMenuItem rdbtnmntmCFile = new JRadioButtonMenuItem("C File");
		buttonGroup.add(rdbtnmntmCFile);
		rdbtnmntmCFile.setBounds(395, 12, 141, 19);
		frmCodebuilder.getContentPane().add(rdbtnmntmCFile);
		
		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		//textArea.setBounds(257, 36, 665, 378);
		//frmCodebuilder.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(257, 36, 665, 378);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmCodebuilder.getContentPane().add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		frmCodebuilder.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnFile.add(mntmAbout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panel.setVisible(true);
				
				btnAdd.setVisible(true);
				lblName.setVisible(true);
				lblProperty.setVisible(true);
				textField.setVisible(true);
				textField.setText("");
				textField_1.setVisible(true);
				textField_1.setText("");
				
				switch(comboBox.getSelectedIndex())
				{
				case 0 :							panel.setVisible(false);
				case OBJECT_TYPE.TYPE_LED : 		lblName.setVisible(false);
													lblProperty.setVisible(false);
													textField.setVisible(false);
													textField_1.setVisible(false);
													break;
				case OBJECT_TYPE.TYPE_TIMER:		lblProperty.setVisible(false);
													textField_1.setVisible(false);
													break;
				case OBJECT_TYPE.TYPE_SENDER : 		lblName.setVisible(false);
													textField.setVisible(false);
													lblProperty.setText("AMID");
													break;
				case OBJECT_TYPE.TYPE_RECEIVER :	lblName.setVisible(false);
													textField.setVisible(false);
													lblProperty.setText("AMID");
													break;
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				boolean isSucess=true;
				
				panel.setVisible(false);
				
				switch(comboBox.getSelectedIndex())
				{
				case 0:							panel.setVisible(false);
												break;
				case OBJECT_TYPE.TYPE_LED: 		Objects.add(new Leds());
												break;
												
				case OBJECT_TYPE.TYPE_TIMER:	if(textField.getText().equals(""))
												{
														Objects.add(new Timer());
												}
												else
												{
														Objects.add(new Timer(textField.getText()));
												}
												break;
				case OBJECT_TYPE.TYPE_SENDER:	if(isInt(textField_1.getText()))
												{
													if(isRadio==false)
													{
														isRadio = true;
														Objects.add(new AMControl());
													}
													Objects.add(new Sender(Integer.parseInt(textField_1.getText())));
														
												}
												else
												{
													JOptionPane.showMessageDialog(null, "AMID should be integer");
													isSucess = false;
												}
												break;
				case OBJECT_TYPE.TYPE_RECEIVER:	if(isInt(textField_1.getText()))
												{
													if(isRadio==false)
													{
														isRadio = true;
														Objects.add(new AMControl());
													}
													Objects.add(new Receiver(Integer.parseInt(textField_1.getText())));
												}
												else
												{
													JOptionPane.showMessageDialog(null, "AMID should be integer");
													isSucess = false;
												}
												break;
				}
				if(isSucess)
				{
					wfc = new WriteCFile(FileName);
					
					wfappc = new WriteAppCFile(FileName);
			
					wfappc.WriteFile(Objects);
					wfc.WriteFile(Objects);
					
					textArea.setText(wfappc.GetTextAreaText().toString());
					
					rdbtnmntmAppcFile.setSelected(true);

				}
				comboBox.setSelectedIndex(0);
			}
		});

		btnGenerateCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				WriteCFile wfc = new WriteCFile(FileName,Path);
				
				int error = wfc.CreateFile();
				
				if(error == WriteFile.SUCCESS_FILE_CREATE)
				{
					JOptionPane.showMessageDialog(null,"C Successfully file created");
				}
				else if (error == WriteFile.ERROR_FILE_EXIST)
				{
					JOptionPane.showMessageDialog(null,"C File Already exists");
					return;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"C File Creation error");
					return;
				}

				WriteAppCFile wfappc = new WriteAppCFile(FileName,Path);
				
				int error1 = wfappc.CreateFile();
				
				if(error1 == WriteFile.SUCCESS_FILE_CREATE)
				{
					JOptionPane.showMessageDialog(null,"AppC file Successfully file created");
				}
				else if (error1 == WriteFile.ERROR_FILE_EXIST)
				{
					JOptionPane.showMessageDialog(null,"AppC File Already exists");
					return;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"AppC File Creation error");
					return;
				}
				
				wfappc.WriteFile(Objects);
				wfc.WriteFile(Objects);
				
				frmCodebuilder.getContentPane().setVisible(false);
			}
		});
		
		mntmNew.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				JFileChooser filechooser = new JFileChooser();
				
				int OpenChoice = filechooser.showSaveDialog(null);
				
				if(OpenChoice == JFileChooser.APPROVE_OPTION)
				{
					File f = filechooser.getSelectedFile();
					Path = f.getParent();
					FileName = f.getName();
					
					isRadio = false;
					Objects.clear();
					
					frmCodebuilder.getContentPane().setVisible(true);
					
				}
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(1);
			}
		});
		
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "This Project is Created by Trusit Shah\nContact: contactme@trusitshah.comuf.com", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		rdbtnmntmAppcFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textArea.setText(wfappc.GetTextAreaText().toString());				
			}
		});

		rdbtnmntmCFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textArea.setText(wfc.GetTextAreaText().toString());		
			}
		});	
	}
	
	private boolean isInt(String str)
	{
		try
		{
			Integer.parseInt(str);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
