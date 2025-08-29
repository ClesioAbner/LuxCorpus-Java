import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.*;
import javax.swing.*;
public class Visualizacoes 
{
  private static DecimalFormat mt;
  public Visualizacoes()
  {
	  mt=new DecimalFormat("###,###.00MT");
  }
  
  
//Visualização do valor total da LuxCorpus
  public static void visualizarTotalLuc(float valorTot) {
      StringBuilder message = new StringBuilder();
      message.append("--------------------------------------------------------------------------------\n");
      message.append("                         TOTAL Da LuxCorpus                  \n");
      message.append("--------------------------------------------------------------------------------\n");
      message.append("                  O Valor total da LuxCorpus e o Seguinte::          \n");
      message.append("-------------------------------------------------------------------------------\n");
      message.append(                       String.format("|%23s|\n", mt.format(valorTot)));
      message.append("--------------------------------------------------------------------------------\n");

      JOptionPane.showMessageDialog(null, message.toString(), "TOTAL Da LuxCorpus", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização do valor total de descontos
  public static void visulizarDesconto(float desconto) {
      StringBuilder message = new StringBuilder();
      message.append("---------------------------------------------------------------------------------\n");
      message.append("              			  TOTAL DE DESCONTOS                  \n");
      message.append("---------------------------------------------------------------------------------\n");
      message.append(" 					O Valor total dos Descontos e o Seguinte:        :\n");
      message.append("--------------------------------------------------------------------------------\n");
      message.append(					String.format("%23s\n",mt.format(desconto)));
      message.append("---------------------------------------------------------------------------------\n");

      JOptionPane.showMessageDialog(null, message.toString(), "TOTAL DE DESCONTOS", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização da quantidade de socios Gold
  public static void visualizarGold() {
      StringBuilder message = new StringBuilder();
      message.append("---------------------------------------------------------------------------\n");
      message.append(" 						Quantidade do Gold  |\n");
      message.append("---------------------------------------------------------------------------\n");
      message.append(				String.format("%20s\n", Gold.socioGold));
      message.append("---------------------------------------------------------------------------\n");

      JOptionPane.showMessageDialog(null, message.toString(), "Quantidade do Gold", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização da quantidade de socios Premium
  public static void visualizarPremium() {
      StringBuilder message = new StringBuilder();
      message.append("------------------------------------------------------------------------------\n");
      message.append("					 			Quantidade Premium  \n");
      message.append("------------------------------------------------------------------------------\n");
      message.append(					String.format("%20s\n", Premium.socioPremium));
      message.append("------------------------------------------------------------------------------\n");

      JOptionPane.showMessageDialog(null, message.toString(), "Quantidade Premium", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização da quantidade de socios Silver
  public static void visualizarSilver() {
      StringBuilder message = new StringBuilder();
      message.append("-----------------------------------------------------------------------------------\n");
      message.append("  					Quantidade Silver   \n");
      message.append("----------------------------------------------------------------------------------\n");
      message.append(						String.format("%20s\n", Silver.socioSilver));
      message.append("----------------------------------------------------------------------------------\n");

      JOptionPane.showMessageDialog(null, message.toString(), "Quantidade Silver", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização da quantidade de socios Standard
  public static void visualizarStander() {
      StringBuilder message = new StringBuilder();
      message.append("----------------------------------------------------------------------------------\n");
      message.append("  					Quantidade Silver   \n");
      message.append("----------------------------------------------------------------------------------\n");
      message.append(					String.format("%20s\n", Standard.socioStandard));
      message.append("----------------------------------------------------------------------------------\n");

      JOptionPane.showMessageDialog(null, message.toString(), "Quantidade Standard", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização da quantidade total de socios
  public static void visualizarTotal(int total) {
      StringBuilder message = new StringBuilder();
      message.append("---------------------------------------------------------------------------------\n");
      message.append("								 Quantidade Total    \n");
      message.append("---------------------------------------------------------------------------------\n");
      message.append							(String.format("%20s\n",total));
      message.append("---------------------------------------------------------------------------------\n");

      JOptionPane.showMessageDialog(null, message.toString(), "Quantidade Total de Socios", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização da quantidade de cada tipo de socio
  public static void visualizarContarSocios(int gold, int premium, int silver, int standard, int total) {
      StringBuilder message = new StringBuilder();
      message.append("===================================================================\n");
      message.append("|          QUANTIDADE DE CADA TIPO DE SOCIO                       |\n");
      message.append("-------------------------------------------------------------------\n");
      message.append("Para categoria Gold, foram contabilizados " + gold + " socios.         \n");
      message.append("-------------------------------------------------------------------\n");
      message.append("Para categoria Premium, foram contabilizados " + premium + " socios.   \n");
      message.append("-------------------------------------------------------------------\n");
      message.append("Para categoria Silver, foram contabilizados " + silver + " socios.     \n");
      message.append("-------------------------------------------------------------------\n");
      message.append("Para categoria Standard, foram contabilizados " + standard + " socios. \n");
      message.append("===================================================================\n");
      message.append("\n");
      message.append("-----------------------------------------------------\n");
      message.append("|               TOTAL DOS SOCIOS                    |\n");
      message.append("-----------------------------------------------------\n");
      message.append("|No total, foram contabilizados os seguintes socios:|\n");
      message.append("-----------------------------------------------------\n");
      message.append(String.format("|%23d|\n", total));
      message.append("-----------------------------------------------------\n");

      JOptionPane.showMessageDialog(null, message.toString(), "Quantidade de Cada Tipo de Socio", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização dos dados de reservas de socios Gold
  public static void VisualizarReservasGold(Vector vecUm) {
      Socio sc;
      Gold gd;

      StringBuilder message = new StringBuilder();
      message.append("-----------------------------------------------------\n");
      message.append("			Dados de socios Gold: \n");
      message.append("-----------------------------------------------------\n");

      for (int i = 0; i < vecUm.size(); i++) {
          sc = (Socio) vecUm.elementAt(i);
          if (sc instanceof Gold) {
              gd = (Gold) sc;
              message.append(gd.toString()).append("\n");
          }
      }

      JOptionPane.showMessageDialog(null, message.toString(), "Dados de Socios Gold", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização dos dados de reservas de socios Premium
  public static void visualizarReservaPremium(Vector vecUm) {
      Socio sc;
      Premium pr;

      StringBuilder message = new StringBuilder();
      message.append("-----------------------------------------------------------\n");
      message.append("              Dados de socios Premium:\n");
      message.append("-----------------------------------------------------------\n");

      for (int i = 0; i < vecUm.size(); i++) {
          sc = (Socio) vecUm.elementAt(i);
          if (sc instanceof Premium) {
              pr = (Premium) sc;
              message.append(pr.toString()).append("\n");
          }
      }

      JOptionPane.showMessageDialog(null, message.toString(), "Dados de Socios Premium", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização dos dados de reservas de socios Standard
  public static void visualizarReservaStandard(Vector vecUm) {
      Socio sc;
      Standard st;

      StringBuilder message = new StringBuilder();
      message.append("-------------------------------------\n");
      message.append("	Dados de socios Standard: \n");
      message.append("-------------------------------------\n");

      for (int i = 0; i < vecUm.size(); i++) {
          sc = (Socio) vecUm.elementAt(i);
          if (sc instanceof Standard) {
              st = (Standard) sc;
              message.append(st.toString()).append("\n");
          }
      }

      JOptionPane.showMessageDialog(null, message.toString(), "Dados de Socios Standard", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização dos dados de reservas de socios Silver
  public static void visualizarReservasSilver(Vector vecUm) {
      Socio sc;
      Silver sl;

      StringBuilder message = new StringBuilder();
      message.append("-------------------------------------------\n");
      message.append(" 				Dados de socios Silver\n");
      message.append("------------------------------------------\n");

      for (int i = 0; i < vecUm.size(); i++) {
          sc = (Socio) vecUm.elementAt(i);
          if (sc instanceof Silver) {
              sl = (Silver) sc;
              message.append(sl.toString()).append("\n");
          }
      }

      JOptionPane.showMessageDialog(null, message.toString(), "Dados de Socios Silver", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização dos dados de todas as reservas
  public static void visualizaDadosrReservas(Vector vecDois) {
      Reserva rs;

      StringBuilder message = new StringBuilder();
      message.append("-----------------------------------------------------------------------\n");
      message.append(" 							Dados das reservas:           \n");
      message.append("-----------------------------------------------------------------------\n");

      for (int i = 0; i < vecDois.size(); i++) {
          rs = (Reserva) vecDois.elementAt(i);
          message.append(rs.toString()).append("\n");
      }

      JOptionPane.showMessageDialog(null, message.toString(), "Dados de Todas as Reservas", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização das reservas no mês de Abril
  public static void visualizarAbril(Vector vecDois) {
      Reserva rs;

      StringBuilder message = new StringBuilder();
      message.append("--------------------------------------------------------\n");
      message.append("				Reservas no mes de Abril:\n");
      message.append("--------------------------------------------------------\n");

      for (int i = 0; i < vecDois.size(); i++) {
          rs = (Reserva) vecDois.elementAt(i);
          String data = rs.getData();
          if (data.length() >= 10 && data.substring(3, 5).equals("04")) {
              message.append(rs.toString()).append("\n");
          }
      }

      JOptionPane.showMessageDialog(null, message.toString(), "Reservas no mês de Abril", JOptionPane.PLAIN_MESSAGE);
  }

  // Visualização dos dados separados de socios e reservas
  public static void visualizarTudoSeparadoSociosReserva(Vector vecUm, Vector vecDois) {
      visualizarContarSocios(Gold.socioGold, Premium.socioPremium, Silver.socioSilver, Standard.socioStandard, vecUm.size());
      visualizaDadosrReservas(vecDois);
  }
  // Visualizacao do Menu e SubMenu
  public void menu()
  {
	    System.out.println("================================================================================");
		System.out.println("|                                MENU                                          |");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("|1-Ler Dados do Ficheiro                                                       |");
		System.out.println("|2-Calcule a quantidade de socios de cada tipo e a quantidade total de Socios  |");
		System.out.println("|3-Visualizar todos os dados de socios,e Reservas separadamente por tipos      |");
		System.out.println("|4-Calcule o valor total pago ao LuxCorpus                                     |");
		System.out.println("|5-Calcular valor total de desconto                                            |");
		System.out.println("|6-Visualizar quantidade de reservas para o mes de abril                       |");
		System.out.println("|7-Visualizar socio mais antigo ao LuxCorpus                                   |");
		System.out.println("|8-Escrever dados no Ficheiro de objetos                                       |");
		System.out.println("|9-Ler dados do Ficheiro de objetos                                            |");
		System.out.println("|10-Alterar hora da reserva                                                    |");
		System.out.println("|11-Remover um socio pelo codigo                                               |");
		System.out.println("|12-Introduzir dados dos novos socios                                          |");
		System.out.println("|13-Dados do Programador                                                       |");
		System.out.println("|14-Sair                                                                       |");
		System.out.println("================================================================================");
		System.out.println("Introduza a opcao que Pretende(1-14)");
  }
  public void submenu() 
	{
		System.out.println("===================================================================");
		System.out.println("|                        SubMENU SOCIO                            |");
		System.out.println("===================================================================");
		System.out.println("|1-Visualizar Quantidade Gold                                     |");
		System.out.println("|2-Visualizar Quantidade Premium                                  |");
		System.out.println("|3-Visualizar Quantidade Silver                                   |");
		System.out.println("|4-Visualizar Quantidade Standard                                 |");
		System.out.println("|5-Visualizar Quantidade Total de Socios                          |");
		System.out.println("|6-Visualizar Todas Quantidades duma so vez                       |");
		System.out.println("|7-Voltar                                                         |");
		System.out.println("===================================================================");
		System.out.println("Introduza a opcao que Pretende(1-7)");
	}
  public void submenu1() 
	{
		System.out.println("===================================================================");
		System.out.println("|            SubMENU Todos Dados Socios e Reservas                |");
		System.out.println("===================================================================");
		System.out.println("|1-Visualizar Dados Gold                                          |");
		System.out.println("|2-Visualizar Dados Premium                                       |");
		System.out.println("|3-Visualizar Dados Silver                                        |");
		System.out.println("|4-Visualizar Dados Standard                                      |");
		System.out.println("|5-Visualizar Dados de Reserva                                    |");
		System.out.println("|6-Visualizar todos os Dados de uma vez!                          |");
		System.out.println("|7-voltar                                                         |");
		System.out.println("===================================================================");
		System.out.println("Introduza a opcao que Pretende(1-7)");
	}
  public void dadosProgramadores() 
  {
	  StringBuilder mensagem = new StringBuilder();
      
      // Dados do Programador 1
      mensagem.append("Programador 1:\n");
      mensagem.append("Código: 20190509\n");
      mensagem.append("Nome: Eclesio Abner Pembelane\n");
      mensagem.append("Email: eclesioabner@gmail.com\n");
      mensagem.append("Morada: Av. Acordos de Lusaka\n");
      mensagem.append("Curso: Engenharia Informatica\n\n");

      // Dados do Programador 2
      mensagem.append("Programador 2:\n");
      mensagem.append("Codigo Estudante: 20220939\n");
      mensagem.append("Nome: Edilson Malache\n");
      mensagem.append("Email: edymalache1991@gmail.com\n");
      mensagem.append("Morada: Bairro de Guava\n");
      mensagem.append("Curso: Engenharia Informatica\n\n");

      // Dados do Programador 3
      mensagem.append("Programador 3:\n");
      mensagem.append("Codigo Estudante: 20220514\n");
      mensagem.append("Nome: Nelson Ivan Mbombi\n");
      mensagem.append("Email: Nelsonivamn@gmail.com\n");
      mensagem.append("Morada: Bairro da Liberdade\n");
      mensagem.append("Curso: Engenharia Informatica\n");

      JOptionPane.showMessageDialog(null, mensagem.toString(), "Dados dos Programadores", JOptionPane.INFORMATION_MESSAGE);
  }
  public void visualizarSobre()
  {
	  StringBuilder mensagem = new StringBuilder();
      
      mensagem.append("---------Sobre LuxCorpus-----------\n");
      mensagem.append("Este é um programa de Gerenciamento da LuxCorpus.\n");
      mensagem.append("O Luxcorpus é o maior e mais moderno Health Club & Spa da cidade de Maputo.\n");
      mensagem.append("Um espaço elegante e confortável onde pode usufruir de um leque variado de treinos e\n");
      mensagem.append("aulas no Health Club ou de momentos de total relaxamento no SPA.");
      
      JOptionPane.showMessageDialog(null, mensagem.toString(), "Sobre LuxCorpus", JOptionPane.INFORMATION_MESSAGE);
  }
  public void visualizarDicas()
  {
	  StringBuilder mensagem = new StringBuilder();
	  mensagem.append("----------------Dicas----------------\n");
	  mensagem.append("Certifique-se de inserir corretamente o nome de "
	  		+ 			"usuário e senha para acessar o programa.\n");
	  mensagem.append("Use os botões conforme as instruções fornecidas.\n");
	  mensagem.append("Clique nos menus e submenus para explorar as opções disponíveis.\n");
	  mensagem.append("Utilize listas suspensas (combobox) ou botões de opção "
	  		+ "(radio buttons) para selecionar opções disponíveis.\n");
	  
	  JOptionPane.showMessageDialog(null, mensagem.toString(), "Dicas", JOptionPane.INFORMATION_MESSAGE);
	  
  }
  public void visualizarDicasGeral()
  {
	  StringBuilder mensagem = new StringBuilder();
	  mensagem.append("----------------Dicas Geral ----------------\n");
	  mensagem.append(" Explore os menus: Os menus são uma parte \n"
	  		+ " importante do programa. "
	  			+ "Explore os diferentes menus "
	  			+ "e submenus para descobrir as opções disponíveis \n "
	  			+ "Isso permitirá que você acesse diferentes funcionalidades \n "
	  			+ "e execute diversas ações.\n");
	  mensagem.append("Verifique os dados inseridos: Antes de confirmar ou salvar as informações,\n "
	  		+ "verifique se todos os dados estão corretos.\n"
	  		+ "Isso inclui verificar nomes, datas,\n"
	  		+ "seleções e quaisquer outros detalhes relevantes.\n"
	  		+ "Corrigir erros antes de prosseguir ajudará \n"
	  		+ "a manter a precisão dos dados.\n");
	  mensagem.append("Preencha todos os campos obrigatórios:"
	  		+ " Ao adicionar informações sobre um sócio ou reserva \n, "
	  		+ " se preencheu todos os campos obrigatórios.\n"
	  		+ "Isso garantirá que os dados sejam inseridos corretamente e\n "
	  		+ "evita possíveis erros ou problemas no programa.\n");
	  
	  
	  JOptionPane.showMessageDialog(null, mensagem.toString(), "Dicas Geral", JOptionPane.INFORMATION_MESSAGE);
  }
  	public void visualizarSocioAntigo(Vector vecUm,int indice)
  	{
  		Socio sc;
  		sc = (Socio)vecUm.elementAt(indice);
  		System.out.println(sc.toString());
  	}
}
