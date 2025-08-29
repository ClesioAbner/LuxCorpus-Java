import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class TabelaTodos extends JFrame
{
   private JTable tab, tab2, tab3, tab4;
   private JScrollPane scroll, scroll2, scroll3, scroll4;
   private String titulosTodos[] = {"Gold","Silver","Premium","Standard"};
   private String titulosGold[] = {"Codigo","Nome","Idade","Peso","Genero","Objectivo","Data de Inscrição","Nutricionista","Numero do Quarto"};
   private String titulosSilver[] = {"Codigo","Nome","Idade","Peso","Genero","Objectivo","Data de Inscrição", "Hidroginastica"};
   private String titulosPremium[] = {"Codigo","Nome","Idade","Peso","Genero","Objectivo","Data de Inscrição","Quantidade Mensal","Personal Trainer"};
   private String titulosStandard[] = {"Codigo","Nome","Idade","Peso","Genero","Objectivo","Data de Inscrição","Quantidade Mensal","Horario"};
   private String[][] tabDadosGold;
   private String[][] tabDadosSilver;
   private String[][] tabDadosPremium;
   private String[][] tabDadosStandard;
   private JTabbedPane tabbedPane;
   private JPanel card1, card2, card3, card4;
   private Socio soc;
   private Gold gol;
   private Silver sil;
   private Premium pre;
   private Standard sta;
   private Tarefas tf;
   private Container cont;
   private Vector v;
   
   public TabelaTodos(Tarefas tf)
   {
	   super("Preenchimento da tabela");
	   this.tf=tf;
	   v = tf.getVecUm();
	   tabDadosGold = criarTabelaGold(v.size());
	   tabDadosSilver = criarTabelaSilver(v.size());
	   tabDadosPremium = criarTabelaPremium(v.size());
	   tabDadosStandard = criarTabelaStandard(v.size());
	   tab = new JTable(tabDadosGold,titulosGold);
	   tab2 = new JTable(tabDadosSilver,titulosSilver);
	   tab3 = new JTable(tabDadosPremium,titulosPremium);
	   tab4 = new JTable(tabDadosStandard,titulosStandard);
	   cont = getContentPane();
	   scroll = new JScrollPane(tab);
	   scroll2 = new JScrollPane(tab2);
	   scroll3 = new JScrollPane(tab3);
	   scroll4 = new JScrollPane(tab4);
	   card1 = new JPanel();
	   card2 = new JPanel();
	   card3 = new JPanel();
	   card4 = new JPanel();
	   card1.add(scroll);
	   card2.add(scroll2);
	   card3.add(scroll3);
	   card4.add(scroll4);
	   tabbedPane = new JTabbedPane();
	   tabbedPane.add(titulosTodos[0],card1);
	   tabbedPane.add(titulosTodos[1],card2);
	   tabbedPane.add(titulosTodos[2],card3);
	   tabbedPane.add(titulosTodos[3],card4);
	   cont.add(tabbedPane,BorderLayout.CENTER);
	   
	   tabbedPane.setBackground(new Color(234,221,202));
	   cont.setBackground(new Color(111,78,55));
	   card1.setBackground(new Color(111,78,55));
	   card2.setBackground(new Color(111,78,55));
	   card3.setBackground(new Color(111,78,55));
	   card4.setBackground(new Color(111,78,55));
	   tab.setBackground(new Color(234,221,202));
	   tab2.setBackground(new Color(234,221,202));
	   tab3.setBackground(new Color(234,221,202));
	   tab4.setBackground(new Color(234,221,202));
	   
	   setSize(300,120);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
