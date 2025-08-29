
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.swing.*;
public class EscolherFicheiro extends JFrame{

	private JButton buttao;
	private Container cont;
	
	public EscolherFicheiro()
	{}
	
	public void escreverFicheiro()
	{
		setTitle(" Escolher Ficheiro");
		setLayout(new FlowLayout());
		cont=getContentPane();
		
		buttao = new JButton("Selecionar Ficheiro");
		buttao.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent ev) 
					{
						if(ev.getSource()==buttao)
						{
							JFileChooser fileChooser = new JFileChooser();
							//seleciona o ficheiro do Directorio
							fileChooser.setCurrentDirectory(new File("."));
							// seleciona o Ficheiro a ser Aberto
							int response = fileChooser.showOpenDialog(null);
							
							// A opcao que leva a ser Lida
							if(response == JFileChooser.APPROVE_OPTION) 
							{
								File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
								System.out.println(file);
							}

						}
					}
					
				}
			);
		cont.add(buttao);
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	public static void main(String [] args)
	{
		new EscolherFicheiro();
	}

}
