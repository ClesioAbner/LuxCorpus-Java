import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import net.miginfocom.swing.MigLayout;

public class Login extends JFrame
{
    private JLabel login,nome, senha, image, registo;
    private JTextField nField;
    private JPasswordField sField;
    private JButton entrar, forget, registar;
    private JPanel panel1, panel2, panel3;
    private Vector vecLogin;
    private ImageIcon icon;
    private Container cont;
    private Welcome welcome;
    
    public Login(Welcome welcome)
    {
    	this.welcome=welcome;
    	vecLogin = new Vector();
    	eclesio();
    	edilson();
    	nelson();
    	
    	cont = getContentPane();
    	cont.setBackground(new Color(193,154,107));
    	
    	login = new JLabel("Entrar");
    	login.setFont(new Font("sansserif", 1, 30));
        login.setForeground(new Color(193,154,107));
    	
        nome = new JLabel(" NOME ");
        nome.setFont(new Font("sansserif", 2, 11));
        nome.setForeground(new Color(111,78,55));
        
    	senha = new JLabel(" SENHA ");
    	senha.setFont(new Font("sansserif", 2, 11));
        senha.setForeground(new Color(111,78,55));
        
    	icon = new ImageIcon("LuxLogo.png");
    	image = new JLabel(icon);
    	
    	ImageIcon Image=new ImageIcon("Logo.jpg");
		setIconImage(Image.getImage());
    	
    	nField = new JTextField();
    	nField.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
    	nField.setToolTipText("Introduza o nome do usuÃ¡rio.");
    	
    	sField = new JPasswordField();
    	sField.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
    	sField.setToolTipText("Introduza a senha do usuÃ¡rio.");
    	
    	entrar = new JButton("Entrar");
    	entrar.setBackground(new Color(193,154,107));
    	entrar.setForeground(Color.white);
    	entrar.setBorderPainted(false);
    	entrar.setFocusable(false);
    	entrar.addActionListener
    	(
    	    new ActionListener()
    	    {
    	    	public void actionPerformed(ActionEvent e)
    	    	{
    	    		String nome = nField.getText();
    	    		String senha = sField.getText();
    	    		
    	    		if(nome.isEmpty()||senha.isEmpty())
	    			{
	    				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
	    				return;
	    			}
	    			else
	    			{
    	    			if(validarLogin(nome, senha))
    	    			{
    	    				new MenuBar();
    	    				dispose();
    	    			}
    	    			else
    	    			{
    	    		        JOptionPane.showMessageDialog(null, "O nome ou a senha esta incorrecto(a)!");
    	    			}
	    	    			
	    	    		
    	    		}
    	    	}
    	    }
    	);
    	
    	forget = new JButton("CLIQUE AQUI CASO TENHA ESQUECIDO DA SENHA");
    	forget.setFont(new Font("sansserif", 2, 7));
    	forget.setBackground(new Color(234,221,202));
    	forget.setForeground(new Color(111,78,55));
    	forget.setFocusable(false);
    	forget.setBorderPainted(false);
    	forget.setToolTipText("Clique caso tenha esquecido a senha");
    	forget.addActionListener
    	(
    	    new ActionListener()
    	    {
    	    	public void actionPerformed(ActionEvent ev)
    	    	{
    	    		abrirEsqueceu();
    	    		dispose();
    	    	}
    	    }
    	);
    	
    	registo = new JLabel(" AINDA NÃƒO ESTÃ� REGISTADO(A)? ");
    	registo.setFont(new Font("sansserif", 2, 8));
        registo.setForeground(new Color(111,78,55));
    	
        registar = new JButton("CLIQUE AQUI");
        registar.setFont(new Font("sansserif", 2, 8));
    	registar.setBackground(new Color(234,221,202));
    	registar.setForeground(new Color(111,78,55));
    	registar.setFocusable(false);
    	registar.setBorderPainted(false);
    	registar.setToolTipText("Clique para registar");
    	registar.addActionListener
    	(
    	    new ActionListener()
    	    {
    	    	public void actionPerformed(ActionEvent e)
    	    	{
    	    		abrirRegistar();
    	    		dispose();
    	    	}
    	    }
    	);
    	
    	panel1 = new JPanel();
    	panel1.setBackground(new Color(193,154,107));
    	panel1.setSize(100,400);
    	panel1.add(image,BorderLayout.WEST);
    	
    	panel2 = new JPanel(new MigLayout("wrap","push[center]push","push[]20[]2[]20[]2[]5[]5[]35[]2[]push"));
    	panel2.add(login);
    	panel2.add(nome);
    	panel2.add(nField, "w 80%");
    	panel2.add(senha);
    	panel2.add(sField, "w 80%");
    	panel2.add(forget);
    	panel2.add(entrar);
    	panel2.add(registo);
    	panel2.add(registar);
    	panel2.setBackground(new Color(234,221,202));
    	panel2.setSize(300,400);
    	
    	panel3 = new JPanel(new MigLayout("wrap","push[center]push","push[]push"));
    	panel3.add(panel2);
    	panel3.setBackground(new Color(234,221,202));
    	panel3.setSize(300,463);
    	
    	
    	cont.add(panel1,BorderLayout.WEST);
    	cont.add(panel3);
    	
    	UIManager.put("OptionPane.background", new Color(234,221,202));
    	UIManager.put("OptionPane.messageForeground", Color.BLACK);
    	UIManager.put("Button.background", new Color(193,154,107));
    	UIManager.put("Button.foreground", Color.white);
    	
    	setSize(370,463);
    	setResizable(false);
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    }
    
    public Vector getVecLogin() {return vecLogin;}
    public void setVecLogin(Vector vecLogin) {this.vecLogin = vecLogin;}
    
    public void abrirRegistar()
    {
    	Registar regi = new Registar(this);
    	regi.setVisible(true);
    }
    
    public void abrirEsqueceu()
    {
    	EsqueceuSenha es = new EsqueceuSenha(this);
    	es.setVisible(true);
    }

	public void nelson()
    {
    	Usuario us = new Usuario();
    	us.setNome("Nelson");
    	us.setEmail("nelsonmombi@gmail.com");
    	us.setSenha("mombi");
    	us.setChave("ivanmombi");
    	vecLogin.add(us);
    	vecLogin.trimToSize();
    }
    
    public void edilson()
    {
    	Usuario us = new Usuario();
    	us.setNome("Edilson");
    	us.setEmail("edilsonmalache@gmail.com");
    	us.setSenha("malache");
    	us.setChave("manuelmalache");
    	vecLogin.add(us);
    	vecLogin.trimToSize();
    }
    
    public void eclesio()
    {
    	Usuario us = new Usuario();
    	us.setNome("Eclesio");
    	us.setEmail("eclesiopembelane@gmail.com");
    	us.setSenha("pembelane");
    	us.setChave("clesiopembelane");
    	vecLogin.add(us);
    	vecLogin.trimToSize();
    }
    
    private boolean validarLogin(String nome, String senha)
    {
    	Usuario us;
    	for (int i=0; i<vecLogin.size(); i++)
    	{
    		us = (Usuario)vecLogin.elementAt(i);
    		if(us.getNome().equals(nField.getText())&&us.getSenha().equals(sField.getText()))
    		{
    			return true;
    		}
    	}
    	return false;
    }
}
