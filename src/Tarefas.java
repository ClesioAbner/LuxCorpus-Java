import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;
public class Tarefas 
{
  private Vector vecUm, vecDois;
  
  public Tarefas()
  {
	  vecUm = new Vector();
	  vecDois = new Vector();
  }
  // metodo ler Ficheiro
  public void lerDoFicheiro()
  {
	  String umaLinha, nomeSocio = "", dataInscricao = "", sexoSocio = "", objectivoSocio = "", nutriParticular = "", nomePersonal = "", codigoReserva = "", horaEntrada = "", data = "", codigoDoSocio = "", nomeDoSocio = "", tipoPacote = "", hidroginastica = "";
	  int numQuarto=0, codigoSocio=0, idadeSocio=0, pesoSocio=0, horario=0;
	  byte quantiMensal=0;
	  StringTokenizer st;
	  char criterioUm = ' ', criterioDois = ' ', criterioTres = ' ';
	  
	  try
	  {
		  FileReader fr = new FileReader("Dados.txt");
		  BufferedReader br = new BufferedReader(fr);
		  
		  umaLinha = br.readLine();
		  
		  while(umaLinha!=null)
		  {
			  st = new StringTokenizer(umaLinha,";");
			  nomeSocio = st.nextToken();
			  dataInscricao = st.nextToken();
			  sexoSocio = st.nextToken();
			  objectivoSocio = st.nextToken();
			  codigoSocio = Integer.parseInt(st.nextToken());
			  idadeSocio = Integer.parseInt(st.nextToken());
			  pesoSocio = Integer.parseInt(st.nextToken());
			  criterioUm = st.nextToken().charAt(0);
			  
			  switch(criterioUm)
			  {
			    case'G':case'g':
			    	nutriParticular = st.nextToken();
			    	numQuarto = Integer.parseInt(st.nextToken());
			    	objectoGold(nomeSocio,dataInscricao,sexoSocio,objectivoSocio,codigoSocio,idadeSocio,pesoSocio,nutriParticular,numQuarto);
			    	criterioTres=st.nextToken().charAt(0);
			    	switch(criterioTres)
			    	{
			    	  case'R':case'r':
			    		  codigoReserva = st.nextToken();
			    		  horaEntrada = st.nextToken();
			    		  data = st.nextToken();
			    		  codigoDoSocio = st.nextToken();
			    		  nomeDoSocio = st.nextToken();
			    		  tipoPacote = st.nextToken();
			    		  reservaGold(codigoReserva, horaEntrada, data, codigoDoSocio, nomeDoSocio, tipoPacote);
			    		  break;
			    	}
			    	break;
			    case'S':case's':
			    	hidroginastica = st.nextToken();
			    	objectoSilver(nomeSocio,dataInscricao,sexoSocio,objectivoSocio,codigoSocio,idadeSocio,pesoSocio,hidroginastica);
			    	switch(criterioTres)
			    	{
			    	  case'R':case'r':
			    		  codigoReserva = st.nextToken();
			    		  horaEntrada = st.nextToken();
			    		  data = st.nextToken();
			    		  codigoDoSocio = st.nextToken();
			    		  nomeDoSocio = st.nextToken();
			    		  tipoPacote = st.nextToken();
			    		  reservaSilver(codigoReserva, horaEntrada, data, codigoDoSocio, nomeDoSocio, tipoPacote);
			    		  break;
			    	}
			    	break;
			    case'N':case'n':
			    	quantiMensal = Byte.parseByte(st.nextToken());
			    	criterioDois = st.nextToken().charAt(0);
			    	switch(criterioDois)
			    	{
			    	  case'T':case't':
			    		  horario = Integer.parseInt(st.nextToken());
			    		  objectoStandard(nomeSocio, dataInscricao, sexoSocio, objectivoSocio, codigoSocio, idadeSocio, pesoSocio,quantiMensal,horario);
			    		  break;
			    	  case'P':case'p':
			    		  nomePersonal = st.nextToken();
			    		  objectoPremium(nomeSocio, dataInscricao, sexoSocio, objectivoSocio, codigoSocio, idadeSocio, pesoSocio,quantiMensal,nomePersonal);
			    		  break;
			    	}
			    	break;
			  }		  
			  umaLinha = br.readLine();
		  }
		  br.close();
		  System.out.println("------------------------------------");
		  System.out.println(" ::  Ficheiro lido com sucesso ::   ");
		  System.out.println("------------------------------------");
	  }
	  catch(FileNotFoundException fe) {System.out.println("Ficheiro nao foi encontrado.");}
	  catch(NumberFormatException ne) {System.out.println(ne.getMessage());}
	  catch(IOException io) {System.out.println(io.getMessage());}
  }
  // objecto Gold
  public void objectoGold(String nomeSocio, String dataInscricao, String sexoSocio, String objectivoSocio, int codigoSocio, int idadeSocio, int pesoSocio, String nutriParticular, int numQuarto)
  {
	 Gold g = new Gold();
	 g.setNomeSocio(nomeSocio);
	 g.setDataInscricao(dataInscricao);
	 g.setSexoSocio(sexoSocio);
	 g.setObjectivoSocio(objectivoSocio);
	 g.setCodigoSocio(codigoSocio);
	 g.setIdadeSocio(idadeSocio);
	 g.setPesoSocio(pesoSocio);
	 g.setNutriParticular(nutriParticular);
	 g.setNumQuarto(numQuarto);
	 vecUm.addElement(g);
	 vecUm.trimToSize();
  }
  // Reserva Gold
  public void reservaGold(String codigoReserva, String horaEntrada, String data, String codigoDoSocio, String nomeDoSocio, String tipoPacote)
  {
	  Reserva res = new Reserva();
	  res.setCodigoReserva(codigoReserva);
	  res.setHoraEntrada(horaEntrada);
	  res.setData(data);
	  res.setCodigoSocio(codigoDoSocio);
	  res.setNomeSocio(nomeDoSocio);
	  res.setTipoPacote(tipoPacote);
	  vecDois.addElement(res);
	  vecDois.trimToSize();
  }
  
  // Objecto Silver
  public void objectoSilver(String nomeSocio, String dataInscricao, String sexoSocio, String objectivoSocio, int codigoSocio, int idadeSocio, int pesoSocio, String hidroginastica)
  {
	  Silver sil = new Silver();
	  sil.setNomeSocio(nomeSocio);
	  sil.setDataInscricao(dataInscricao);
	  sil.setSexoSocio(sexoSocio);
	  sil.setObjectivoSocio(objectivoSocio);
	  sil.setCodigoSocio(codigoSocio);
	  sil.setIdadeSocio(idadeSocio);
	  sil.setPesoSocio(pesoSocio);
	  sil.setHidroginastica(hidroginastica);
	  vecUm.addElement(sil);
	  vecUm.trimToSize();
  }
  
  // Reserva do Silver
  public void reservaSilver(String codigoReserva, String horaEntrada, String data, String codigoDoSocio, String nomeDoSocio, String tipoPacote)
  {
	  Reserva res = new Reserva();
	  res.setCodigoReserva(codigoReserva);
	  res.setHoraEntrada(horaEntrada);
	  res.setData(data);
	  res.setCodigoSocio(codigoDoSocio);
	  res.setNomeSocio(nomeDoSocio);
	  res.setTipoPacote(tipoPacote);
	  vecDois.addElement(res);
	  vecDois.trimToSize();
  }
  
  // objecto Standard
  public void objectoStandard(String nomeSocio, String dataInscricao, String sexoSocio, String objectivoSocio, int codigoSocio, int idadeSocio, int pesoSocio, byte quantiMensal, int horario)
  {
	  Standard st = new Standard();
	  st.setNomeSocio(nomeSocio);
	  st.setDataInscricao(dataInscricao);
	  st.setSexoSocio(sexoSocio);
	  st.setObjectivoSocio(objectivoSocio);
	  st.setCodigoSocio(codigoSocio);
	  st.setIdadeSocio(idadeSocio);
	  st.setPesoSocio(pesoSocio);
	  st.setQuantiMensal(quantiMensal);
	  st.setHorario(horario);
	  vecUm.addElement(st);
	  vecUm.trimToSize();
  }
  //Objecto Premium
  public void objectoPremium(String nomeSocio, String dataInscricao, String sexoSocio, String objectivoSocio, int codigoSocio, int idadeSocio, int pesoSocio, byte quantiMensal, String nomePersonal)
  {
	  Premium pr = new Premium();
	  pr.setNomeSocio(nomeSocio);
	  pr.setDataInscricao(dataInscricao);
	  pr.setSexoSocio(sexoSocio);
	  pr.setObjectivoSocio(objectivoSocio);
	  pr.setCodigoSocio(codigoSocio);
	  pr.setIdadeSocio(idadeSocio);
	  pr.setPesoSocio(pesoSocio);
	  pr.setQuantiMensal(quantiMensal);
	  pr.setNomePersonal(nomePersonal);
	  vecUm.addElement(pr);
	  vecUm.trimToSize();
  }
  
  // adaptador Para Contar Socoios
  public void adaptadorContarSocios()
  {
	  Calculos cal = new Calculos();
	  Visualizacoes vis = new Visualizacoes();
	  int contarGold = Gold.socioGold;
	  int contarPremium = Premium.socioPremium;
	  int contarSilver = Silver.socioSilver;
	  int contarStandard = Standard.socioStandard;
	  int contarTotal = Gold.socioGold+Premium.socioPremium+Silver.socioSilver+Standard.socioStandard;
	  vis.visualizarContarSocios(contarGold,contarPremium,contarSilver,contarStandard,contarTotal);
  }
  
  // adaptador para Socios

  public void adaptadorVisualizarSocGold()
  {
	  Visualizacoes vis = new Visualizacoes();
	  vis.visualizarGold();
  }
  public void adaptadorVisualizarSocStandard()
  {
	  Visualizacoes vis = new Visualizacoes();
	 vis.visualizarStander();
	  
  }
  public void adaptadorVisualizarSocPremium()
  {
	  Visualizacoes vis = new Visualizacoes();
	  vis.visualizarPremium();
  }
  public void adaptadorVisualizarSocSilver()
  {
	  Visualizacoes vis = new Visualizacoes();
	  vis.visualizarSilver();
  }  
  
  //adaptadores para Reservas
  public void adaptadorVisualizarReservas()
  {
	  Visualizacoes vis = new Visualizacoes();
	  vis.visualizaDadosrReservas(vecDois);
  }
  
  public void adaptadorVisualizarResGold()
  {
	  Visualizacoes vis = new Visualizacoes();
	  vis.VisualizarReservasGold(vecUm);
  }
  public void adaptadorVisualizarResStandard()
  {
	  Visualizacoes vis = new Visualizacoes();
	  vis.visualizarReservaStandard(vecUm);
  }
  public void adaptadorVisualizarResPremium()
  {
	  Visualizacoes vis = new Visualizacoes();
	  vis.visualizarReservaPremium(vecUm);
  }
 
  public void adaptadorVisualizarResSilver()
  {
	  Visualizacoes vis = new Visualizacoes();
	  vis.visualizarReservasSilver(vecUm);
  }
  public void adaptadorVisualizarTipo()
  {
	  Visualizacoes vis = new Visualizacoes();
	  vis.visualizarTudoSeparadoSociosReserva(vecUm,vecDois);
  }
  
  public void adaptadorCalcularValorTotalDesconto()
  {
	  Visualizacoes vis = new Visualizacoes();
	  Calculos cal = new Calculos();
	  float desconto=cal.calcularValorTotalDesconto();
	  vis.visulizarDesconto(desconto);
  }
  
  public void adaptadorVisualizarAbril()
  {
	  Visualizacoes vis = new Visualizacoes();
	  vis.visualizarAbril(vecDois);
  }
  
  public void adaptadorRemover()
  {
	  Validacoes val=new Validacoes();
	  Pesquisa pes=new Pesquisa();
	  int codigoSocio= Integer.parseInt(JOptionPane.showInputDialog(null, "Introduza o Codigo que pretende Remover","Remover",JOptionPane.PLAIN_MESSAGE));
	  int i=pes.pesquisarCodigo(vecUm, codigoSocio);
	  
	  if(i==-1)
	  {
		  JOptionPane.showMessageDialog(null, "Nao existe o Codigo que deseja Remover ","Aviso!!!",JOptionPane.WARNING_MESSAGE);
	  }
	  else if(i!=1)
	  {   
		    vecUm.remove(i);
			vecUm.trimToSize();
			JOptionPane.showMessageDialog(null, " ::: Codigo Removido com sucesso! :::");
	  }
  }
  public void adaptadorSobre()
  {
	  Visualizacoes vi = new Visualizacoes();
	  vi.visualizarSobre();
  }
  public void adaptadorDadosProgramador()
  {
		Visualizacoes vi = new Visualizacoes();
		vi.dadosProgramadores();
 }
  public void adaptadorAlterarHora()
  {
	  Reserva rs;
	  Validacoes val=new Validacoes();
	  Pesquisa pes=new Pesquisa();
	  int codigoSocio= val.validarInt(0,9999,"Introduza o Codigo do Socio");
	  int i=pes.pesquisarCodigo(vecUm, codigoSocio); 
	  
	  if(i>=0)
		 {
			 
				rs=(Reserva) vecUm.elementAt(i);
				String hr=rs.getHoraEntrada().substring(0,1);
				rs.setHoraEntrada(hr);
		 }
	
  }
  public void adaptadorvalorAcum()
  {
	  Visualizacoes vis = new Visualizacoes();
	  Calculos c=new Calculos();
	  float valorTot=c.calcularValotTotal(vecUm);
	  vis.visualizarTotalLuc(valorTot);
  }
  public void adaptadorescreverNoFicheiroDeObjeto()
  {
	  EscreverFicheiroObjectos ef=new EscreverFicheiroObjectos();
	  ef.escreverFicheiroObjectos(vecUm);
  }
  public void adaptadorLerNoFicheiroDeObjeto()
  {
	  LerFicheiroObjecto lr=new LerFicheiroObjecto();
	  lr.lerFicheiroObjectos(vecUm);
  }
  public void adaptadorDicas()
  {
	  Visualizacoes vi=new Visualizacoes();
	  vi.visualizarDicas();
  }
  public void adaptadorDicasGerais()
  {
	  Visualizacoes vi=new Visualizacoes();
	  vi.visualizarDicasGeral();
  }
  public void adaptadorVisualizarSocioAntigo()
  {
	  Calculos cal = new Calculos();
	  Visualizacoes vis = new Visualizacoes();
	  int indice = cal.acharIndiceSocioAntigo(vecUm);
	  vis.visualizarSocioAntigo(vecUm,indice);
  }
  public void adaptadorNovoSocio()
  {
	  String nome, data, sexo, objectivo, nomeArquivo = "Dados.txt";
	  int codigo, idade, peso;
	  Validacoes val = new Validacoes();
	  
		  
	  nome = val.validarString(JOptionPane.showInputDialog(null,"Introduza o nome do novo socio:"));
	  data = val.validarString(JOptionPane.showInputDialog(null,"Introduza a data de inscricao do novo socio:"));
	  sexo = val.validarString(JOptionPane.showInputDialog(null,"Introduza o sexo do novo socio:"));
	  objectivo = val.validarString(JOptionPane.showInputDialog(null,"Introduza o objectivo:"));
	  codigo = val.validarInt(0,9999,JOptionPane.showInputDialog(null,"Introduza o codigo do novo socio:"));
	  idade = val.validarInt(1,120,JOptionPane.showInputDialog(null,"Introduza a idade do novo socio:"));
	  peso = val.validarInt(0,500,JOptionPane.showInputDialog(null,"Introduza o peso do novo socio"));
	  
	  try
	  {
	    FileWriter fw = new FileWriter(nomeArquivo,true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    
	    bw.write(nome);
	    bw.newLine();
	    bw.write(data);
	    bw.newLine();
	    bw.write(sexo);
	    bw.newLine();
	    bw.write(objectivo);
	    bw.newLine();
	    bw.write(codigo);
	    bw.newLine();
	    bw.write(peso);
	    bw.newLine();
	    bw.write(idade);
	    bw.newLine();
	    
	    bw.close();
	  }
	  catch(FileNotFoundException fe) {System.out.println("Ficheiro nao foi encontrado.");}
	  catch(NumberFormatException ne) {System.out.println(ne.getMessage());}
	  catch(IOException io) {System.out.println(io.getMessage());}
  }
public Vector getVecUm() {
	return vecUm;
}
public void setVecUm(Vector vecUm) {
	this.vecUm = vecUm;
}
  
  
}
