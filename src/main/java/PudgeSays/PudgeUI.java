package PudgeSays;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PudgeUI  extends JFrame {
	private Locale locale = null;
	private Pudge pudge = null;
	private Pudge pudge1 = null;
	
	private JLabel labelPudge = null;
	private JLabel labelSay01 = null;
	private JLabel labelSay02 = null;
	private JLabel labelSay03 = null;
	
	private JButton buttonFrance = null;
	private JButton buttonGermany = null;
	private JButton buttonUkraine = null;
	private JButton buttonSave = null;
	private JButton buttonRead = null;
	
	private ImageIcon  iconPudge = null;
	private ImageIcon iconFrance = null;
	private ImageIcon iconGermany = null;
	private ImageIcon iconUkraine = null;
	
	
	private JPanel panel = null;
	
	private ByteArrayOutputStream baos = null;
	private ObjectOutputStream oos = null;
	
	private ByteArrayInputStream bais = null;
	private ObjectInputStream ois = null;
	
	

	public PudgeUI() throws HeadlessException {
		pudge = new Pudge();
		pudge1 = new Pudge();
		

		
		setVisible(true);
		setSize(700,350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Pudge says...");
		
		labelPudge = new JLabel();
		buttonFrance = new JButton();
		buttonFrance.setPreferredSize(new Dimension(100,50));
		buttonGermany = new JButton();
		buttonUkraine = new JButton();
		
		labelSay01 = new JLabel(pudge.getSay01());
		labelSay02 = new JLabel(pudge.getSay02());
		labelSay03 = new JLabel(pudge.getSay03());
		
		
		iconPudge = new ImageIcon(new ImageIcon(getClass().getResource("/images/pudge.png")).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));		
		
		labelPudge.setIcon(iconPudge);
		buttonFrance.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/france.png")).getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT)));
		buttonGermany.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/germany.png")).getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT)));
		buttonUkraine.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/ukraine.png")).getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT)));
		
		panel = new JPanel();
		panel.setLayout(null);
		
		panel.add(labelPudge);
		panel.add(buttonFrance);
		panel.add(buttonGermany);
		panel.add(buttonUkraine);
		panel.add(labelSay01);
		panel.add(labelSay02);
		panel.add(labelSay03);
		panel.add(buttonSave = new JButton("Save"));
		panel.add(buttonRead = new JButton("Read"));
		
		
		labelPudge.setBounds(10, 10, 300, 300);
		buttonFrance.setBounds(320,10,100,50);
		buttonGermany.setBounds(430,10,100,50);
		buttonUkraine.setBounds(540,10,100,50);
		labelSay01.setBounds(320,100,200,50);
		labelSay02.setBounds(320,150,200,50);
		labelSay03.setBounds(320,200,200,50);
		buttonSave.setBounds(320,250,100,50);
		buttonRead.setBounds(500,250,100,50);
		
		add(panel);
		
		buttonFrance.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				locale = new Locale("fr","FR");
				pudge.setLocal(locale);
				 localization();
				
				
			}
		});
		
		buttonGermany.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 locale = new Locale("de","DE");
				 pudge.setLocal(locale);
				 localization();
				
			}
		});
		
		buttonUkraine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 locale = new Locale("ua","UA");
				 pudge.setLocal(locale);
				 localization();
			}
		});
		
		buttonSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 baos = new ByteArrayOutputStream();
				try {
					oos = new ObjectOutputStream(baos);
					oos.writeObject(pudge);
					baos.writeTo(new FileOutputStream("saves.txt"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		buttonRead.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bais = new ByteArrayInputStream(baos.toByteArray());
				try {
					ois = new ObjectInputStream(new FileInputStream("saves.txt"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					pudge1 = (Pudge) ois.readObject();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				locale = pudge1.getLocal();
				localization();
			
			}
		});
		
	}
	
	 private void localization() {
		 ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle",locale);
			labelSay01.setText(bundle.getString(pudge.getSay01()));
			labelSay02.setText(bundle.getString(pudge.getSay02()));
			labelSay03.setText(bundle.getString(pudge.getSay03()));
		 
	 }

	
	
	
	
	
}
