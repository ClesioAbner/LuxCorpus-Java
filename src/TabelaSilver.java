import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class TabelaSilver extends JFrame
{
	private JTable tab;
	   private JScrollPane scroll;
	   private String titulosSilver[] = {"Codigo","Nome","Idade","Peso","Genero","Objectivo","Data de Inscrição", "Hidroginastica"};
	   private String[][] tabDadosSilver;
	   private Socio soc;
	   private Silver sil;
	   private Tarefas tf;
	   private Container cont;
	   private Vector v;
	   
	   public TabelaSilver(Tarefas tf)
	   {
		   super("Preenchimento da tabela");
		   this.tf=tf;
		   v = tf.getVecUm();
		   tabDadosSilver = criarTabelaSilver(v.size());
		   tab = new JTable(tabDadosSilver,titulosSilver);
		   cont = getContentPane();
		   scroll = new JScrollPane(tab);
		   cont.add(scroll,BorderLayout.CENTER);
		   setSize(300,200);
		   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   setLocationRelativeTo(null);
		   setVisible(true);
	   }
	   
	   public String [][] criarTabelaSilver(int linhas)
	   {
		   String[][]x = new String[linhas][titulosSilver.length];
		   for(int i=0; i<linhas; i++)
		   {
			   soc = (Socio)v.elementAt(i);
			   if(soc instanceof Silver)
			   {
				   sil = (Silver) soc;
				   x[i][0]=sil.getCodigoSocio()+"";
				   x[i][1]=sil.getNomeSocio();
				   x[i][2]=sil.getIdadeSocio()+"";
				   x[i][3]=sil.getPesoSocio()+"";
				   x[i][4]=sil.getSexoSocio();
				   x[i][5]=sil.getObjectivoSocio();
				   x[i][6]=sil.getDataInscricao();
				   x[i][7]=sil.getHidroginastica();
			   }
		   }
		   return x;
	   }
}
