import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class TabelaPremium extends JFrame
{
	private JTable tab;
	   private JScrollPane scroll;
	   private String titulosPremium[] = {"Codigo","Nome","Idade","Peso","Genero","Objectivo","Data de Inscrição","Quantidade Mensal","Personal Trainer"};
	   private String[][] tabDadosPremium;
	   private Socio soc;
	   private Premium pre;
	   private Tarefas tf;
	   private Container cont;
	   private Vector v;
	   
	   public TabelaPremium(Tarefas tf)
	   {
		   super("Preenchimento da tabela");
		   this.tf=tf;
		   v = tf.getVecUm();
		   tabDadosPremium = criarTabelaPremium(v.size());
		   tab = new JTable(tabDadosPremium,titulosPremium);
		   cont = getContentPane();
		   scroll = new JScrollPane(tab);
		   cont.add(scroll,BorderLayout.CENTER);
		   setSize(300,200);
		   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   setLocationRelativeTo(null);
		   setVisible(true);
	   }
	   
	   public String [][] criarTabelaPremium(int linhas)
	   {
		   String[][]x = new String[linhas][titulosPremium.length];
		   for(int i=0; i<linhas; i++)
		   {
			   soc = (Socio)v.elementAt(i);
			   if(soc instanceof Premium)
			   {
				   pre = (Premium) soc;
				   x[i][0]=pre.getCodigoSocio()+"";
				   x[i][1]=pre.getNomeSocio();
				   x[i][2]=pre.getIdadeSocio()+"";
				   x[i][3]=pre.getPesoSocio()+"";
				   x[i][4]=pre.getSexoSocio();
				   x[i][5]=pre.getObjectivoSocio();
				   x[i][6]=pre.getDataInscricao();
				   x[i][7]=pre.getQuantiMensal()+"";
				   x[i][8]=pre.getNomePersonal();
			   }
		   }
		   return x;
	   }
}
