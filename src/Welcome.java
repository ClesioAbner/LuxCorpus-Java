import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import net.miginfocom.swing.MigLayout;

public class Welcome extends JFrame
{
	private JLabel register, senha, image;
    private ImageIcon icon;
    private Container cont;
    private JProgressBar progressBar;
    private JLabel labelStatus;
    
    public Welcome()
    {
    	cont = getContentPane();
    	cont.setLayout(new MigLayout("wrap","push[center]push","push[]2[]push"));
    	cont.setBackground(new Color(193,154,107));
        
    	register = new JLabel(" SEJA BEM VINDO AO ");
    	register.setFont(new Font("sansserif", 2, 13));
        register.setForeground(new Color(111,78,55));
    	
    	senha = new JLabel(" LUX CORPUS ");
    	senha.setFont(new Font("sansserif", 1, 30));
        senha.setForeground(new Color(111,78,55));
        
    	icon = new ImageIcon("imgLux170.png");
    	image = new JLabel(icon);
    	
    	ImageIcon Image=new ImageIcon("Logo.jpg");
		setIconImage(Image.getImage());
    	
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.white);
        progressBar.setForeground(new Color(111,78,55));
        progressBar.setBorderPainted(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(progressBar, BorderLayout.CENTER);
        
        getContentPane().add(panel);

        iniciarProcesso();
    	
    	cont.add(image);
    	cont.add(register);
    	cont.add(senha);
    	cont.add(panel);
    	
    	UIManager.put("OptionPane.background", new Color(234,221,202));
    	
    	setSize(400,400);
    	setResizable(false);
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    }
    
    private void iniciarProcesso() {
 
        Timer timer = new Timer(20, new ActionListener() {
            int progresso = 0;
            
            public void actionPerformed(ActionEvent e) {

                progressBar.setValue(progresso);

                if (progresso == 100) {
 
                    abrirLogin();
                    ((Timer) e.getSource()).stop();
                    dispose();
                }

                progresso++;
            }
        });


        timer.start();
    }
    
    public static void main (String[]args) {new Welcome();}
    
    public void abrirLogin()
    {
    	Login logi = new Login(this);
    	logi.setVisible(true);
    }
}


