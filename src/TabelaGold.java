import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class TabelaGold extends JFrame 
{
	private JTable tab;
	   private JScrollPane scroll;
	   private String titulosGold[] = {"Codigo","Nome","Idade","Peso","Genero","Objectivo","Data de Inscrição","Nutricionista","Numero do Quarto"};
	   private String[][] tabDadosGold;
	   private Socio soc;
	   private Gold gol;
	   private Tarefas tf;
	   private Container cont;
	   private Vector v;
	   
	   public TabelaGold(Tarefas tf)
	   {
		   super("Preenchimento da tabela");
		   this.tf=tf;
		   v = tf.getVecUm();
		   tabDadosGold = criarTabelaGold(v.size());
		   tab = new JTable(tabDadosGold,titulosGold);
		   cont = getContentPane();
		   scroll = new JScrollPane(tab);
		   cont.add(scroll,BorderLayout.CENTER);
		   setSize(300,200);
		   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   setLocationRelativeTo(null);
		   setVisible(true);
	   }
	   
	   public String [][] criarTabelaGold(int linhas)
	   {
		   String[][]x = new String[linhas][titulosGold.length];
		   for(int i=0; i<linhas; i++)
		   {
			   soc = (Socio)v.elementAt(i);
			   if(soc instanceof Gold)
			   {
				   gol = (Gold) soc;
				   x[i][0]=gol.getCodigoSocio()+"";
				   x[i][1]=gol.getNomeSocio();
				   x[i][2]=gol.getIdadeSocio()+"";
				   x[i][3]=gol.getPesoSocio()+"";
				   x[i][4]=gol.getSexoSocio();
				   x[i][5]=gol.getObjectivoSocio();
				   x[i][6]=gol.getDataInscricao();
				   x[i][7]=gol.getNutriParticular();
				   x[i][8]=gol.getNumQuarto()+"";
			   }
		   }
		   return x;
	   }
}
