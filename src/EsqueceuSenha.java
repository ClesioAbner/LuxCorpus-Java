

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class EsqueceuSenha extends JFrame
{
	private JLabel register, senha, confSenha, chave, image, conta;
    private JTextField cField;
    private JPasswordField sField, confField;
    private JButton entrar, verificar;
    private JPanel panel1, panel2, panel3;
    private Login logi;
    private ImageIcon icon;
    private Container cont;
    
    public EsqueceuSenha(Login logi)
    {
    	this.logi=logi;
    	cont = getContentPane();
    	cont.setBackground(new Color(193,154,107));
        
    	register = new JLabel("Recuperar");
    	register.setFont(new Font("sansserif", 1, 30));
        register.setForeground(new Color(193,154,107));
    	
    	senha = new JLabel(" NOVA SENHA ");
    	senha.setFont(new Font("sansserif", 2, 11));
        senha.setForeground(new Color(111,78,55));
        
        confSenha = new JLabel(" CONFIRMAR A NOVA SENHA ");
    	confSenha.setFont(new Font("sansserif", 2, 11));
        confSenha.setForeground(new Color(111,78,55));
        
        chave = new JLabel(" CHAVE DE RECUPERACAO ");
        chave.setFont(new Font("sansserif", 2, 11));
        chave.setForeground(new Color(111,78,55));
        
    	icon = new ImageIcon("LuxLogo.png");
    	image = new JLabel(icon);
    	
    	sField = new JPasswordField();
    	sField.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
    	sField.setToolTipText("Introduza a nova senha.");
    	
    	confField = new JPasswordField();
    	confField.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
    	confField.setToolTipText("Reintroduza a nova senha.");
    	
    	cField = new JTextField();
    	cField.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
    	cField.setToolTipText("Introduza a sua chave de recuperação.");
    	
    	verificar = new JButton("Verificar");
    	verificar.setBackground(new Color(193,154,107));
    	verificar.setForeground(Color.white);
    	verificar.setBorderPainted(false);
    	verificar.setFocusable(false);
    	verificar.addActionListener
    	(
    	    new ActionListener()
    	    {
    	    	public void actionPerformed(ActionEvent e)
    	    	{
    	    		Usuario us = new Usuario();
    	    		String senha, confSenha, chave;
    	    		senha = sField.getText();
    	    		confSenha = confField.getText();
    	    		chave = cField.getText();
    	    		Vector vec = logi.getVecLogin();
    	    		
    	    		if(chave.length()==0) {JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");}
    	    		else 
    	    		{
    	    			if(chave.length()<5) {JOptionPane.showMessageDialog(null, "O campo da chave deve ter no minimo 5 digitos!");}
    	    			else
    	    			{
    	    				if(verificarChave(chave,vec))
    	    				{
    	    					if(senha.length()==0) {JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");}
    	        	    		else {if(senha.length()<5) {JOptionPane.showMessageDialog(null, "O campo da senha deve ter no minimo 5 digitos!");}}
    	        	    		
    	        	    		if(confSenha.length()==0) {JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");}
    	        	    		else 
    	        	    		{
    	        	    			if(confSenha.length()<5) {JOptionPane.showMessageDialog(null, "O campo do confirmação deve ter no minimo 5 digitos!");}
    	        	    			else
    	        	    			{
    	        	    				if(senha.equals(confSenha))
    	        	    				{
    	        	    				    us.setSenha(senha);
    	        	    				    vec.add(us);
    	        	        	    		vec.trimToSize();
    	        	        	    		logi.setVecLogin(vec);
    	        	        	    		JOptionPane.showMessageDialog(null, "A senha foi alterada com sucesso!");
    	        	    				}
    	        	    				else
    	        	    				{
    	        	    					JOptionPane.showMessageDialog(null, "As senhas não são compatíveis!");
    	        	    				}
    	        	    			}
    	        	    		}
    	    				}
    	    				else
    	    					JOptionPane.showMessageDialog(null, "A conta não foi encontrada!");
    	    			}
    	    		}
    	    		
    	    	}
    	    }
    	);
    	
    	conta = new JLabel(" JÁ SE LEMBRA DA SENHA? ");
    	conta.setFont(new Font("sansserif", 2, 8));
        conta.setForeground(new Color(111,78,55));
    	
        entrar = new JButton("CLIQUE AQUI");
        entrar.setFont(new Font("sansserif", 2, 8));
    	entrar.setBackground(new Color(234,221,202));
    	entrar.setForeground(new Color(111,78,55));
    	entrar.setFocusable(false);
    	entrar.setBorderPainted(false);
    	entrar.setToolTipText("Clique para aceder à sua conta.");
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
    	
    	panel2 = new JPanel(new MigLayout("wrap","push[center]push","push[]20[]2[]7[]2[]7[]2[]7[]25[]2[]push"));
    	panel2.add(register);
    	panel2.add(chave);
    	panel2.add(cField, "w 80%");
    	panel2.add(senha);
    	panel2.add(sField, "w 80%");
    	panel2.add(confSenha);
    	panel2.add(confField, "w 80%");
    	panel2.add(verificar);
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
    	
    	UIManager.put("OptionPane.background", new Color(234,221,202));
    	
    	setSize(370,463);
    	setResizable(false);
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    }
    
    private boolean verificarChave(String chave, Vector vec)
    {
    	Usuario us;
    	for(int i=0; i<vec.size(); i++)
    	{
    		us = (Usuario)vec.elementAt(i);
    		if(us.getChave().equals(chave))
    		{
    			return true;
    		}
    	}
    	return false;
    }
}
