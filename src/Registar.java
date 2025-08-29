

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class Registar extends JFrame
{
	private JLabel register, nome, email, senha, confSenha, chave, tipChave, dicaEmail, dicaChave, image, conta;
    private JTextField nField, eField, cField;
    private JPasswordField  sField, confField;
    private JButton entrar, registar;
    private JPanel panel1, panel2, panel3;
    private Login logi;
    private ImageIcon icon;
    private Container cont;
    
    public Registar(Login logi)
    {
    	
    	ImageIcon Image=new ImageIcon("Logo.jpg");
		setIconImage(Image.getImage());
    	this.logi=logi;
    	cont = getContentPane();
    	cont.setBackground(new Color(193,154,107));
    	
    	register = new JLabel("Registar");
    	register.setFont(new Font("sansserif", 1, 30));
        register.setForeground(new Color(193,154,107));
    	
        nome = new JLabel(" NOME ");
        nome.setFont(new Font("sansserif", 2, 11));
        nome.setForeground(new Color(111,78,55));
        
        email = new JLabel(" EMAIL ");
        email.setFont(new Font("sansserif", 2, 11));
        email.setForeground(new Color(111,78,55));
        
    	senha = new JLabel(" SENHA ");
    	senha.setFont(new Font("sansserif", 2, 11));
        senha.setForeground(new Color(111,78,55));
        
        confSenha = new JLabel(" CONFIRMAR A SENHA ");
    	confSenha.setFont(new Font("sansserif", 2, 11));
        confSenha.setForeground(new Color(111,78,55));
        
        chave = new JLabel(" CHAVE DE RECUPERACAO ");
        chave.setFont(new Font("sansserif", 2, 11));
        chave.setForeground(new Color(111,78,55));
        
        tipChave = new JLabel(" UMA PALAVRA OU NUMERO QUE AJUDE A RECUPERAR A CONTA ");
        tipChave.setFont(new Font("sansserif", 2, 11));
        tipChave.setForeground(new Color(111,78,55));
        
    	icon = new ImageIcon("LuxLogo.png");
    	image = new JLabel(icon);
    	
    	nField = new JTextField();
    	nField.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
    	nField.setToolTipText("Introduza o nome do usuario.");
    	
    	eField = new JTextField();
    	eField.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
    	eField.setToolTipText("Introduza o nome do usuario.");
    	
    	sField = new JPasswordField();
    	sField.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
    	sField.setToolTipText("Introduza a senha do usuario.");
    	
    	confField = new JPasswordField();
    	confField.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
    	confField.setToolTipText("Introduza o nome do usuario.");
    	
    	cField = new JTextField();
    	cField.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
    	cField.setToolTipText("Introduza o nome do usuario.");
    	
    	registar = new JButton("Registar");
    	registar.setBackground(new Color(193,154,107));
    	registar.setForeground(Color.white);
    	registar.setBorderPainted(false);
    	registar.setFocusable(false);
    	registar.addActionListener
    	(
    	    new ActionListener()
    	    {
    	    	public void actionPerformed(ActionEvent e)
    	    	{
    	    		Usuario us = new Usuario();
    	    		String nome, email, senha, confSenha, chave;
    	    		nome = nField.getText();
    	    		email = eField.getText();
    	    		senha = sField.getText();
    	    		confSenha = confField.getText();
    	    		chave = cField.getText();
    	    		String [] allowedDomains = {"gmail.com","outlook.com","hotmail.com"};
    	    		Vector vec = logi.getVecLogin();
    	    		
    	    		if(email!=null)
    	    		{
	    	    		if(emailExists(email,vec))
	    	    		{
	    	    			JOptionPane.showMessageDialog(null, "O email já existe!");
	    	    		}
	    	    		else
	    	    		{
		    	    		if(nome.length()==0) {JOptionPane.showMessageDialog(null, "O campo do nome deve estar preenchido!");}
		    	    		else 
		    	    		{
		    	    			us.setNome(nome);
		    	    		}
		    	    		
		    	    		if(email.length()==0) {JOptionPane.showMessageDialog(null, "O campo do email deve estar preenchido!");}
		    	    		else 
		    	    		{
			    				String domain = getEmailDomain(email);
			    				if(isValidDomain(domain,allowedDomains))
			    				{
			    					us.setEmail(email);
			    				}
			    				else
			    				{
			    					JOptionPane.showMessageDialog(null, "Email não é permitido!");
			    				}
		    	    		}
		    	    		
		    	    		if(senha.length()==0) {JOptionPane.showMessageDialog(null, "O campo da senha deve estar preenchido!");}
		    	    		else {if(senha.length()<5) {JOptionPane.showMessageDialog(null, "O campo da senha deve ter no minimo 5 digitos!");}}
		    	    		
		    	    		if(confSenha.length()==0) {JOptionPane.showMessageDialog(null, "O campo da confirmação deve estar preenchido!");}
		    	    		else 
		    	    		{
		    	    			if(confSenha.length()<5) {JOptionPane.showMessageDialog(null, "O campo do confirmação deve ter no minimo 5 digitos!");}
		    	    			else
		    	    			{
		    	    				us.setSenha(senha);
		    	    			}
		    	    		}
		    	    		
		    	    		if(chave.length()==0) {JOptionPane.showMessageDialog(null, "O campo da chave deve estar preenchido!");}
		    	    		else 
		    	    		{
		    	    			if(chave.length()<5) {JOptionPane.showMessageDialog(null, "O campo da chave deve ter no minimo 5 digitos!");}
		    	    			else
		    	    			{
		    	    				us.setChave(chave);
		    	    			}
		    	    		}
		    	    		vec.add(us);
		    	    		vec.trimToSize();
		    	    		logi.setVecLogin(vec);
		    	    		JOptionPane.showMessageDialog(null, "Dados adicionados com sucesso.");
	    	    		}
    	    		}
    	    	}
    	    }
    	);
    	
    	conta = new JLabel(" Ja TEM UMA CONTA? ");
    	conta.setFont(new Font("sansserif", 2, 8));
        conta.setForeground(new Color(111,78,55));
        
        dicaEmail = new JLabel(" TIPOS DE CONTAS: GMAIL, HOTMAIL E OUTLOOK. ");
    	dicaEmail.setFont(new Font("sansserif", 2, 8));
        dicaEmail.setForeground(new Color(111,78,55));
        
        dicaChave = new JLabel(" PALAVRA PARA RECUPERAR A CONTA ");
    	dicaChave.setFont(new Font("sansserif", 2, 8));
        dicaChave.setForeground(new Color(111,78,55));
    	
        entrar = new JButton("CLIQUE AQUI");
        entrar.setFont(new Font("sansserif", 2, 8));
    	entrar.setBackground(new Color(234,221,202));
    	entrar.setForeground(new Color(111,78,55));
    	entrar.setFocusable(false);
    	entrar.setBorderPainted(false);
    	entrar.setToolTipText("Clique para aceder a� sua conta.");
    	entrar.addActionListener
    	(
    	    new ActionListener()
    	    {
    	    	public void actionPerformed(ActionEvent e)
    	    	{
    	    		logi.setVisible(true);
    	    		setVisible(false);
    	    	}
    	    }
    	);
    	
    	panel1 = new JPanel();
    	panel1.setBackground(new Color(193,154,107));
    	panel1.setSize(100,400);
    	panel1.add(image,BorderLayout.WEST);
    	
    	panel2 = new JPanel(new MigLayout("wrap","push[center]push","push[]20[]2[]7[]2[]2[]7[]2[]7[]2[]7[]2[]2[]7[]25[]2[]push"));
    	panel2.add(register);
    	panel2.add(nome);
    	panel2.add(nField, "w 80%");
    	panel2.add(email);
    	panel2.add(eField, "w 80%");
    	panel2.add(dicaEmail);
    	panel2.add(senha);
    	panel2.add(sField, "w 80%");
    	panel2.add(confSenha);
    	panel2.add(confField, "w 80%");
    	panel2.add(chave);
    	panel2.add(cField, "w 80%");
    	panel2.add(dicaChave);
    	panel2.add(registar);
    	panel2.add(conta);
    	panel2.add(entrar);
    	panel2.setBackground(new Color(234,221,202));
    	panel2.setSize(300,400);
    	
    	panel3 = new JPanel(new MigLayout("wrap","push[center]push","push[]push"));
    	panel3.add(panel2);
    	panel3.setBackground(new Color(234,221,202));
    	panel3.setSize(300,463);
    	
    	
    	cont.add(panel1,BorderLayout.WEST);
    	cont.add(panel3);
    	
    	setSize(370,463);
    	setResizable(false);
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    }
    
    private static String getEmailDomain(String email)
    {
    	int atIndex = email.lastIndexOf('@');
    	
    	if(atIndex != -1)
    	{
    		return email.substring(atIndex + 1);
    	}
    	return null;
    }
    
    private static boolean isValidDomain(String domain, String[]allowedDomains)
    {
    	if(domain != null)
    	{
    		for(String allowedDomain:allowedDomains)
    			if(domain.equalsIgnoreCase(allowedDomain))
    			{
    				return true;
    			}
    	}
    	return false;
    }
    
    private static boolean emailExists(String email, Vector vec)
    {
    	Usuario us;
    	for(int i=0; i<vec.size(); i++)
    	{
    		us = (Usuario)vec.elementAt(i);
    		if(email.equals(us.getEmail()))
    		{
    		    return true;
    		}
    	}
    	return false;
    }
}
