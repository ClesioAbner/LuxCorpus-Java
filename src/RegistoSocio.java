import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RegistoSocio extends JFrame {

	private Container cont;
	private JLabel lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,lab9,lab10;
	private JTextField field1,field2,field3,field4,field5,field6,fied7,field8;
	private JButton button1,button2;
	private JRadioButton bt1,bt2,bt3,bt4,bt5;
	private ButtonGroup bG1;
	private JCheckBox box1,box2;
	private JPanel panel1,panel2,panel3;
	private String nomes[]= {"emagrecer","musculacao","resistência"};
	private JComboBox boxes;
	
	public RegistoSocio()
	{
		super("----RegistoSocio----");
		
		cont=getContentPane();
		cont.setLayout(new GridLayout(10,2));
		
		
		ImageIcon Image=new ImageIcon("Logo.jpg");
		setIconImage(Image.getImage());
		
		lab1=new JLabel(" Nome ");
		field1=new JTextField(10);
		cont.add(lab1);
		cont.add(field1);
		
		lab2=new JLabel(" codigo ");
		field2=new JTextField(20);
		cont.add(lab2);
		cont.add(field2);
		
		lab3=new JLabel(" data ");
		field3=new JTextField(20);
		cont.add(lab3);
		cont.add(field3);
		
		lab4=new JLabel(" Sexo ");
		field4=new JTextField(20);
		cont.add(lab4);
		cont.add(field4);
		
		lab5=new JLabel("Tipo Socio");
		
		bt1=new JRadioButton(" Gold",false);
		bt2=new JRadioButton("Silver",false);
		bt3=new JRadioButton("Standard",false);
		bt4=new JRadioButton("Premium",false);
		
		bG1=new ButtonGroup();
		bG1.add(bt1);
		bG1.add(bt2);
		bG1.add(bt3);
		bG1.add(bt4);
		
		panel1=new JPanel();
		panel1.add(bt1);
		panel1.add(bt2);
		panel1.add(bt3);
		panel1.add(bt4);
		
		cont.add(lab5);
		cont.add(panel1);
		
		lab6=new JLabel("Objectivo");
		boxes=new JComboBox(nomes);
		boxes.setSelectedIndex(-1);
		boxes.setMaximumRowCount(6);
		cont.add(lab6);
		cont.add(boxes);
		
		lab7=new JLabel("Idade");
		field5=new JTextField(20);
		cont.add(lab7);
		cont.add(field5);
		
		lab8=new JLabel("Reservas");
		box1=new JCheckBox("sim");
		box2=new JCheckBox("nao");
		
		panel2=new JPanel();
		panel2.add(box1);
		panel2.add(box2);
		cont.add(lab8);
		cont.add(panel2);
		
		lab9=new JLabel("Peso");
		field6=new JTextField(20);
		cont.add(lab9);
		cont.add(field6);
		
		button1=new JButton(" Gravar ");
		cont.add(button1);
		
		button2=new JButton(" Voltar ");
		button2.addActionListener(
				new ActionListener()
				{

				
					public void actionPerformed(ActionEvent ev) 
					{
						new MenuBar();
						setVisible(false);
						
					}
					
				}
			);
		cont.add(button2);
		
		setSize(700,500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String [] args)
	{
		new RegistoSocio();
	}
	
}
