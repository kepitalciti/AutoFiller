package autofiller.autofiller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.util.Collection;
import static javax.swing.JOptionPane.showMessageDialog;

public class AutoFiller {

	private JFrame frame;
	private static JTextField filepathf;
	private static JTextField ppr;
	private static JTextField price;
	private static JTextField clientadress;
	private static JTextField banknum;
	private static JTextField engsize;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public static String paymethod="Nav noradits";
	private static JTextField clientbankname;
	
	public static String getPrice() {
		return price.getText();
	}
	public static String getPPR() {
		return ppr.getText();
	}
	public static String getFilePath() {
		return filepathf.getText();
	}
	public static String getCAddress() {
		return clientadress.getText();
	}
	public static String getBankNum() {
		return banknum.getText();
	}
	public static String getEngine() {
		return engsize.getText();
	}
	public static String getPayMethod() {
		return paymethod;
	}
	public static String getBankName() {
		return clientbankname.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoFiller window = new AutoFiller();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AutoFiller() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// drag n drop to get filepath
		DropTarget dropTarget = new DropTarget() {
		    public synchronized void drop(DropTargetDropEvent evt) {
		        try {
		            evt.acceptDrop(DnDConstants.ACTION_COPY);
		              Object o = evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
		            	  String absPath = ((File)((Collection<Object>)o).stream().findFirst().get()).getAbsolutePath();
		            	  filepathf.setText(absPath);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		};
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
		
		
		
		JLabel lblNewLabel = new JLabel("Путь к PDF файлу*");
		lblNewLabel.setBounds(10, 11, 142, 14);
		frame.getContentPane().add(lblNewLabel);
		
		filepathf = new JTextField();
		filepathf.setText("");
		filepathf.setBounds(10, 36, 270, 20);
		frame.getContentPane().add(filepathf);
		filepathf.setColumns(10);
		filepathf.setDropTarget(dropTarget);
		
		final JRadioButton cash = new JRadioButton("Наличные");
		cash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cash.isSelected()) paymethod="Skaidra nauda";
			}
		});
		buttonGroup.add(cash);
		cash.setBounds(270, 114, 109, 23);
		frame.getContentPane().add(cash);
		
		final JRadioButton card = new JRadioButton("Перевод");
		card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (card.isSelected()) paymethod="Pārskaitījums";
			}
		});
		buttonGroup.add(card);
		card.setBounds(270, 151, 109, 23);
		frame.getContentPane().add(card);
		
		
		JButton choosefilepath = new JButton("Выбрать");
		choosefilepath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					String filepath = chooser.getSelectedFile().getAbsolutePath();
					filepathf.setText(filepath);
				}
			}
		});
		choosefilepath.setBounds(290, 35, 89, 23);
		frame.getContentPane().add(choosefilepath);
		
		JLabel lblNewLabel_1 = new JLabel("Номер PPR*");
		lblNewLabel_1.setBounds(10, 67, 70, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		ppr = new JTextField();
		ppr.setText("");
		ppr.setBounds(139, 67, 86, 20);
		frame.getContentPane().add(ppr);
		ppr.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Цена*");
		lblNewLabel_2.setBounds(10, 101, 70, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		price = new JTextField();
		price.setText("");
		price.setBounds(139, 101, 86, 20);
		frame.getContentPane().add(price);
		price.setColumns(10);
		JButton run = new JButton("Запустить");
		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((ppr.getText().equals("")) || (price.getText().equals("")) || (filepathf.getText().equals(""))) {
					showMessageDialog(null, "Введите данные!");
				}
				else Excel.main(null);
			}
		});
		run.setBounds(169, 217, 111, 33);
		frame.getContentPane().add(run);
		
		JLabel clientadressl = new JLabel("Адрес клиента");
		clientadressl.setBounds(10, 132, 89, 14);
		frame.getContentPane().add(clientadressl);
		
		clientadress = new JTextField();
		clientadress.setBounds(139, 129, 86, 20);
		frame.getContentPane().add(clientadress);
		clientadress.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Номер счета клиента");
		lblNewLabel_3.setBounds(10, 160, 130, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		banknum = new JTextField();
		banknum.setBounds(139, 157, 86, 20);
		frame.getContentPane().add(banknum);
		banknum.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Объем мотора*");
		lblNewLabel_4.setBounds(249, 71, 89, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		engsize = new JTextField();
		engsize.setBounds(338, 69, 86, 20);
		frame.getContentPane().add(engsize);
		engsize.setColumns(10);
		  
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Имя банка клиента");
		lblNewLabel_5.setBounds(10, 187, 111, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		clientbankname = new JTextField();
		clientbankname.setBounds(139, 185, 86, 20);
		frame.getContentPane().add(clientbankname);
		clientbankname.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Version 1.2");
		lblNewLabel_6.setBounds(315, 236, 109, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 261);
		panel_1.setDropTarget(dropTarget);
		frame.getContentPane().add(panel_1);
		
	}
}
