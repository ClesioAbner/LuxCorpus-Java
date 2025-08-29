import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class TabelaStandard extends JFrame
{
	private JTable tab;
	   private JScrollPane scroll;
	   private String titulosStandard[] = {"Codigo","Nome","Idade","Peso","Genero","Objectivo","Data de Inscrição","Quantidade Mensal","Horario"};
	   private String[][] tabDadosStandard;
	   private Socio soc;
	   private Gold gol;
	   private Silver sil;
	   private Premium pre;
	   private Standard sta;
	   private Tarefas tf;
	   private Container cont;
	   private Vector v;
	   
	   public TabelaStandard(Tarefas tf)
	   {
		   super("Preenchimento da tabela");
		   this.tf=tf;
		   v = tf.getVecUm();
		   tabDadosStandard = criarTabelaStandard(v.size());
		   tab = new JTable(tabDadosStandard,titulosStandard);
		   cont = getContentPane();
		   scroll = new JScrollPane(tab);
		   cont.add(scroll,BorderLayout.CENTER);
		   setSize(300,200);
		   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   setLocationRelativeTo(null);
		   setVisible(true);
	   }
	   
	   public String [][] criarTabelaStandard(int linhas)
	   {
		   String[][]x = new String[linhas][titulosStandard.length];
		   for(int i=0; i<linhas; i++)
		   {
			   soc = (Socio)v.elementAt(i);
			   if(soc instanceof Standard)
			   {
				   sta = (Standard) soc;
				   x[i][0]=sta.getCodigoSocio()+"";
				   x[i][1]=sta.getNomeSocio();
				   x[i][2]=sta.getIdadeSocio()+"";
				   x[i][3]=sta.getPesoSocio()+"";
				   x[i][4]=sta.getSexoSocio();
				   x[i][5]=sta.getObjectivoSocio();
				   x[i][6]=sta.getDataInscricao();
				   x[i][7]=sta.getQuantiMensal()+"";
				   x[i][8]=sta.getHorario()+"";
			   }
		   }
		   return x;
	   }
}
