import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

import net.miginfocom.swing.MigLayout;

public class MenuBar extends JFrame  {

	private JLabel statusBar, image, image2;
	private ImageIcon icon, icon2;
	private JMenuBar bar;
	private JMenu ficheiro,informacoes,LerFicheiro,escrever,calcularQ,
	sociosMenu,reservasMenu,calcularTotal,midia,outro,listarSo,ajuda, mostrar,normal,quantidadeS,qtdN;
	private JMenuItem lerObjectos,lertxt,salvar,salvarcomo,sair,sobre,programadores,escretxt,escreObj,
	adicionarSo,removerSo,adicionarRe,listarRe,musicas,videos,
	totalSo,totalRe,desconto,relogio,calendario,gold,silver,calculadora,comousar,dicas,tic,premium,standard,tabelaso;
	private JMenuItem qtdG,qtdS,qtdP,qtdSS;
	private JPopupMenu popup;
	private JMenuItem item1,item2,item3,item4,item5,item6;
	private Tarefas tf;
	private Metodos md;
	private Visualizacoes vi;
	private JPanel left, right;
	private JSplitPane split;
	private TabelaTodos tt;
	private TabelaGold tg;
	private TabelaSilver ts;
	private TabelaPremium tp;
	private TabelaStandard ta;
	
	private Vector vec;
	
	public MenuBar()
	{
		super(" Lux-Corpus");
		
		statusBar=new JLabel();
		getContentPane().add(statusBar,BorderLayout.CENTER);
	
		ImageIcon Image=new ImageIcon("Logo.jpg");
		setIconImage(Image.getImage());
		
		//cria bara menu...
		bar = new JMenuBar();
		bar.setBackground(new Color(234,221,202));
		bar.setForeground(new Color(111,78,55));
		setJMenuBar(bar);
		// inicializacao das classes
		tf=new Tarefas();
		md=new Metodos();
		
		icon = new ImageIcon("musicLogo.png");
		image = new JLabel(icon);
		
		icon2 = new ImageIcon("imgLux90.png");
		image2 = new JLabel(icon2);
		
		//defenindo Dados do Menu Ficheiro
		ficheiro=new JMenu("Ficheiro");
		ficheiro.setMnemonic('F');
		
		LerFicheiro=new JMenu("Ler Ficheiro...");
		LerFicheiro.setMnemonic('L');
		
		lertxt=new JMenuItem(" De Texto");
		lertxt.setMnemonic('4');
		// Tratamento do Evento LerFicheiro
		lertxt.addActionListener(
				new ActionListener()
				{

					public void actionPerformed(ActionEvent ev) 
					{
							JFileChooser fileChooser = new JFileChooser();
							//seleciona o ficheiro do Directorio
							fileChooser.setCurrentDirectory(new File("."));
							// seleciona o Ficheiro a ser Aberto
							int response = fileChooser.showOpenDialog(null);
							// A opcao que leva a ser Lida
							if(response == JFileChooser.APPROVE_OPTION) 
							{
								new File(fileChooser.getSelectedFile().getAbsolutePath());
								tf.lerDoFicheiro();
							}
							JOptionPane.showMessageDialog(null,"::  Ficheiro lido com sucesso ::");
					}
				}
		);
		
		lerObjectos=new JMenuItem(" De Objectos");
		lerObjectos.setMnemonic('O');
		// Tratamento do Evento LerObjectos
		lerObjectos.addActionListener(
				new ActionListener()
				{

					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorLerNoFicheiroDeObjeto();
					}
					
				}
			);
		
		
		salvar=new JMenuItem("Salvar Dados");
		salvar.setMnemonic('@');
		// Tratamento do Evento SalvarDados
		salvar.addActionListener(
				new ActionListener()
				{

					public void actionPerformed(ActionEvent ev) 
					{
					
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setDialogTitle("Salvar Ficheiro");   
						 
						fileChooser.showSaveDialog(null);
						
						JOptionPane.showMessageDialog(null,":: Ficheiro Salvo com Sucesso ::");
					}
					
				}
			);
		salvarcomo=new JMenuItem("Salvar Dados como");
		salvarcomo.setMnemonic('S');
		// Tratamento do Evento Botao SalvarComo
		salvarcomo.addActionListener(
				new ActionListener()
				{

					public void actionPerformed(ActionEvent ev) 
					{
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setDialogTitle("Salvar Ficheiro");   
						 
						int selecionado = fileChooser.showSaveDialog(null);
						
						if (selecionado == JFileChooser.APPROVE_OPTION) {
						    File fileToSave = fileChooser.getSelectedFile();
						    System.out.println("Save as file: " + fileToSave.getPath());
						    JOptionPane.showMessageDialog(null,":: Ficheiro Salvo com  Sucesso ::");
						}
						
					}
					
				}
			);
		escrever=new JMenu("Escrever Ficheiro...");
		escrever.setMnemonic('F');//Alt+f
		
	
		escretxt=new JMenuItem(" De Texto");
		escretxt.setMnemonic('T');
		//Tratamento do Evento Escrever Ficheiro
		escretxt.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorNovoSocio();
					}
				}
			);
		
		escreObj=new JMenuItem("De Objectos");
		escreObj.setMnemonic('H');//Alt+h
		// Tratamento do Evento EscreverObjectos
		escreObj.addActionListener(
				new ActionListener()
				{

					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorescreverNoFicheiroDeObjeto();
					}
					
				}
			);
		
		// e um Menu
		informacoes=new JMenu("Sobre");
		informacoes.setMnemonic('i');
		informacoes.addSeparator();
		sobre=new JMenuItem("Sobre o Programa");
		sobre.setMnemonic('s');
		sobre.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorSobre();
					}
					
				}
			);
		programadores=new JMenuItem("Sobre os Programadores");
		programadores.setMnemonic('s');
		programadores.addActionListener(
				new ActionListener()
				{

					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorDadosProgramador();						
					}
					
				}
			);
		
		sair=new JMenuItem("Sair do Programa");
		// Tratamento do Evento botao sair
		sair.addActionListener(
				new ActionListener()
				{

					public void actionPerformed(ActionEvent ev) 
					{
						int reposta=JOptionPane.showConfirmDialog(null,"Deseja Sair?");
						
						if(reposta==JOptionPane.YES_NO_OPTION)
						{
							JOptionPane.showMessageDialog(null,"Volte sempre..");
							System.exit(0);
						}
					}
					
				}
			);
		sair.setMnemonic('o');
		
		// adicionando Dados do Menu
		ficheiro.add(LerFicheiro);
		LerFicheiro.add(lertxt);
		LerFicheiro.add(lerObjectos);
		ficheiro.add(escrever);
		escrever.add(escretxt);
		escrever.add(escreObj);
		ficheiro.add(salvar);
		ficheiro.add(salvarcomo);
	    ficheiro.addSeparator();
		ficheiro.add(sair);
		bar.add(ficheiro);
		
		// dos Socios
		// Tudo que tem Haver com Socios
	
		sociosMenu = new JMenu("Socios");
	    adicionarSo = new JMenuItem("Adicionar Socio");
	    adicionarSo.addActionListener(
	    		new ActionListener()
	    		{

					public void actionPerformed(ActionEvent ev) 
					{
						new RegistoSocio();	
					}
	    		}
	    	);
	    removerSo = new JMenuItem("Remover Socio");
	    // Tratamento do Evento Remover Socio
	    removerSo.addActionListener(
	    		new ActionListener()
	    		{

					public void actionPerformed(ActionEvent ev) 
					{	
						tf.adaptadorRemover();
					}
	    			
	    		}
	    	);
	    tabelaso=new JMenuItem("Todos Dados");
	    tabelaso.addActionListener(
	    		new ActionListener()
	    		{

					
					public void actionPerformed(ActionEvent ev) 
					{
						//tf.adaptadorVisualizarResGold();
						tt = new TabelaTodos(tf);
						tt.setVisible(true);
					}
	    			
	    		}
	    	);
	    // Quantidades Socios
	    quantidadeS = new JMenu("Quantidade de Socios...");
	    qtdN=new JMenu(" Normal ");
	    qtdP=new JMenuItem("Premuium");
	    qtdP.addActionListener(
	    		new ActionListener()
	    		{

					
					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorVisualizarSocPremium();
						
					}
	    			
	    		}
	    	);
	    // Visualizar quantidade Standard
	    qtdSS=new JMenuItem("Standard");
	    qtdSS.addActionListener(
	    		new ActionListener()
	    		{					
					public void actionPerformed(ActionEvent e) 
					{
						tf.adaptadorVisualizarSocStandard();
						
					}
	    			
	    		}
	    	);
	    
	    //outro Menu dentro dos Socios
	    listarSo = new JMenu("Listar Socios");
	    gold=new JMenuItem("Socio Gold");
	    // Tratamento do Evento para O socio Gold
	    gold.addActionListener(
	    		new ActionListener()
	    		{

					
					public void actionPerformed(ActionEvent ev) 
					{
						//tf.adaptadorVisualizarResGold();
						tg = new TabelaGold(tf);
						tg.setVisible(true);
					}
	    			
	    		}
	    	);
	    silver=new JMenuItem("Socio Silver");
	    silver.addActionListener(
	    		new ActionListener()
	    		{

					public void actionPerformed(ActionEvent ev)
					{
						//tf.adaptadorVisualizarResSilver();
						ts = new TabelaSilver(tf);
						ts.setVisible(true);
					}
	    			
	    		}
	    	);
	    
	    // dento dos Socios
	    normal=new JMenu("Socio Normal");
	    premium=new JMenuItem("Premium");
	    premium.addActionListener(
	    		new ActionListener()
	    		{

					public void actionPerformed(ActionEvent ev) 
					{
						//tf.adaptadorVisualizarResPremium();
						tp = new TabelaPremium(tf);
						tp.setVisible(true);
					}
	    			
	    		}
	    	);
	    standard=new JMenuItem("Standard");
	    standard.addActionListener(
	    		new ActionListener()
	    		{
					public void actionPerformed(ActionEvent ev) 
					{
						//tf.adaptadorVisualizarResStandard();
						ta = new TabelaStandard(tf);
						ta.setVisible(true);
					}
	    			
	    		}
	    	);

	    // Fim Da parte dos SOcios
	    //das Reservas
	    // Tudo que tem Haver com as Reservas
	    reservasMenu = new JMenu("Reservas");
	    listarRe = new JMenuItem("Listar Reservas");
	    listarRe.addActionListener(
	    		new ActionListener()
	    		{

					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorVisualizarReservas();
					}
	    			
	    		}
	    	);
	    
	    // Tratamento do Evento da Reserva do Abril
	    adicionarRe = new JMenuItem(" Reserva Abril");
	    adicionarRe.addActionListener(
	    		new ActionListener()
	    		{
				
					public void actionPerformed(ActionEvent ev) 
					{
						
						tf.adaptadorVisualizarAbril();
					}
	    			
	    		}
	    	);
	    calcularQ = new JMenu("Quantidade de Reservas");
	    // Tratamento do Evento da quantiadade Gold
	    qtdG=new JMenuItem(" Gold ");
	    qtdG.addActionListener(
	    		new ActionListener()
	    		{

				
					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorVisualizarSocGold();
						
					}
	    			
	    		}
	    	);
	    // Tratamento do Evento da Quantidade Silver
	    qtdS=new JMenuItem("Silver");
	    qtdS.addActionListener(
	    		new ActionListener()
	    		{

			
					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorVisualizarSocSilver();
						
					}
	    			
	    		}
	    	);

	    // para os valores
	    calcularTotal = new JMenu("Valor Total");
	    totalSo = new JMenuItem("Socios");
	    totalSo.addActionListener(
	    		new ActionListener()
	    		{					
					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorvalorAcum();
					}
	    			
	    		}
	    	);
	    desconto=new JMenuItem("Desconto");
	    desconto.addActionListener(
	    		new ActionListener()
	    		{

					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorCalcularValorTotalDesconto();
						
					}
	    			
	    		}
	    	);
	    
	    //Um Menu Extra
	    midia = new JMenu("Extra");
	    musicas = new JMenuItem("Musicas");
	    videos = new JMenuItem("V�deos");
	    videos.addActionListener(
	    		new ActionListener()
	    		{
					public void actionPerformed(ActionEvent ev) 
					{
						new VideoPlayer();
					}
	    			
	    		}
	    	);
	    
	    // outras partes adicionados
	    outro=new JMenu("Outro");
	    relogio=new JMenuItem("Relogio");
	    // Tratamento do Evento Para Relogio
	    relogio.addActionListener(
	    		new ActionListener()
	    		{

					public void actionPerformed(ActionEvent ev) {
						new Relogio();
					}
	    			
	    		}
	    	);
	    calendario=new JMenuItem("Calendario");
	    // Calendario, Tratamento do Evento
	    calendario.addActionListener(
	    		new ActionListener()
	    		{
					public void actionPerformed(ActionEvent ev) 
					{
						new Calendario();
					}
	    			
	    		}
	    	);
	    calculadora=new JMenuItem("Calculadora");
	    // Tratamento do Evento para calculadora
	    calculadora.addActionListener(
	    		new ActionListener()
	    		{
					public void actionPerformed(ActionEvent e) 
					{
						new Calculadora();
					}
	    			
	    		}
	    	);
	    // Tratamento do Evento Do Tic tac toe
	    tic=new JMenuItem("Tic tac Toe");
	    tic.addActionListener(
	    		new ActionListener()
	    		{
					public void actionPerformed(ActionEvent ev) 
					{
						new TicTacToe();
						
					}
	    			
	    		}
	    	);
	    
	    //Ajuda ou Help
	    ajuda=new JMenu("Ajuda");
	    comousar=new JMenuItem("Como Usar");
	    // Dicas de Como Usar
	    comousar.addActionListener(
	    		new ActionListener()
	    		{
					
					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorDicas();
					}
	    			
	    		}
	    	);
	    dicas=new JMenuItem("Dicas");
	    // Dicas Geral
	    dicas.addActionListener(
	    		new ActionListener()
	    		{

					
					public void actionPerformed(ActionEvent ev) 
					{
						tf.adaptadorDicasGerais();
						
					}
	    			
	    		}
	    	);
	    
	    //tratamento do click do Mouse
		popup=new JPopupMenu();
		item1=new JMenuItem(" Undo typing");
		item2=new JMenuItem(" copiar");
		// Tratamento do Butao Copiar
		item2.addActionListener(
				new ActionListener()
				{					
					public void actionPerformed(ActionEvent e)
					{
						md.metodoCopiar();
					}	
				}
			);
		item3=new JMenuItem(" Colar");
		// Tratamento do Evento Colar
		item3.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						md.metodoColar();
				    }
				}
			);
		item4=new JMenuItem(" Refresh");
		// O mostrar tera algumas Opcoes
		mostrar=new JMenu(" Mostrar");
		item5=new JMenuItem("Mostar no Sistema");
		// Tratamento do Evento do Butao Mostar
		// Caso seja Nessacio Extrair alguma coisa do Sistema
		item5.addActionListener(
				new ActionListener()
				{

					public void actionPerformed(ActionEvent ev) 
					{
						
						JFileChooser fileChooser = new JFileChooser();
						//seleciona o ficheiro do Directorio
						fileChooser.setCurrentDirectory(new File("."));
						// seleciona o Ficheiro a ser Aberto
						int response = fileChooser.showOpenDialog(null);
						
						// A opcao que leva a ser Lida
						if(response == JFileChooser.APPROVE_OPTION) 
						{
							new File(fileChooser.getSelectedFile().getAbsolutePath());
							
							JOptionPane.showMessageDialog(null,"::  Ficheiro Escolhido com sucesso ::");
						}
					}
					
				}
			);
		item6=new JMenuItem("Mostar no Programa");
		
	    //adicionando dados do Socio
	    sociosMenu.add(listarSo);
	    listarSo.add(gold);
	    listarSo.add(silver);
	    listarSo.add(normal);
	    
	    //adicionando os do Normal
	    
	    normal.add(premium);
	    normal.add(standard);
	    
        sociosMenu.add(adicionarSo);
        sociosMenu.add(removerSo);
        sociosMenu.add(tabelaso);
        sociosMenu.addSeparator();
        sociosMenu.add(quantidadeS);
        quantidadeS.add(qtdN);
        qtdN.add(qtdP);
        qtdN.add(qtdSS);
        bar.add(sociosMenu);

        // adicionado dados da Reserva
        reservasMenu.add(listarRe);
        
        reservasMenu.add(adicionarRe);
        reservasMenu.addSeparator();
        reservasMenu.add(calcularQ);
        calcularQ.add(qtdG);
        calcularQ.add(qtdS);
        
        bar.add(reservasMenu);
        
        //adicionado valor totals
        calcularTotal.add(totalSo);
        calcularTotal.add(desconto);
        bar.add(calcularTotal);
		
        // Menu Extra para Midia
        midia.add(musicas);
        midia.add(videos);
	    bar.add(midia);
        
        // adicionando valores
        informacoes.add(sobre);
        informacoes.add(programadores);
        bar.add(informacoes);
        
        //adicionado outros
        outro.add(relogio);
        outro.add(calendario);
        outro.add(calculadora);
        outro.addSeparator();
        outro.add(tic);
        bar.add(outro);
       
        // adicionando Ajuda
        ajuda.add(comousar);
        ajuda.add(dicas);
        bar.add(ajuda);// colocando no MenuBar
        
        //adicionado Eventos do Popup(Click do Mouse Direito)
        popup.add(item1);
        popup.add(item2);
        popup.add(item3);
        popup.add(item4);
        popup.add(mostrar);
        mostrar.add(item5);
        mostrar.add(item6);
        addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {              
                popup.show(statusBar, e.getX(), e.getY());  
            }                 
         });
        
        left = criarLeftPanel();
		right = criarRightPanel();
		
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
		split.setResizeWeight(0.5);
		//split.setDividerLocation(200);
		
		split.setUI(new BasicSplitPaneUI()
		{
	        public BasicSplitPaneDivider createDefaultDivider()
	        {
	        	return new BasicSplitPaneDivider(this)
    			{
    		        public void paint(Graphics g)
    		        {
    		        	g.setColor(new Color(193,154,107));
    		        	g.fillRect(0, 0, getSize().width, getSize().height);
    		        	super.paint(g);
    		        }
    			};
	        }
		}
		);
		
		getContentPane().add(split);
		
		//getContentPane().setLayout(new MigLayout("wrap 2","push[center]2[center]push","push[]push"));
		//getContentPane().add(left);
		//getContentPane().add(right);
		
		setSize(600,500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    
	
	//public static void main(String [] args)
	//{
	//	setDefaultLookAndFeelDecorated(false);
	//	new MenuBar();
	//}
	
	private JPanel criarLeftPanel()
	{
		JPanel panel = new JPanel(new MigLayout("wrap","push[center]push","push[]5[]push"));
		
		AnalogClock clo = new AnalogClock();
		panel.add(clo);
		
		JTable calendarTab = criarCalendarTab();
		panel.add(new JScrollPane(calendarTab),"w 90%");
		
		panel.setSize(100,80);
		panel.setBackground(new Color(193,154,107));
		
		return panel;
	}
	
	private JTable criarCalendarTab()
	{
		// Obter a data atual
	    Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(Calendar.MONTH);
	   
	    // Definir a data para o primeiro dia do mês
	    calendar.set(year, month, 1);
	    int startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	   
	    // Obter o número de dias no mês atual
	    int numDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	   
	    // Criar os nomes das colunas do calendário
	    String[] columnNames = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"};
	   
	    // Calcular o número de linhas necessário para exibir todos os dias do mês
	    int numRows = (int) Math.ceil((startDayOfWeek + numDaysInMonth - 1) / 7.0);
	   
	    // Criar a matriz de dados para o calendário
	    Object[][] data = new Object[numRows][7];
	   
	    // Preencher a matriz de dados com os dias do mês
	    int day = 1;
	    for (int row = 0; row < numRows; row++) {
	        for (int col = 0; col < 7; col++) {
	            if (row == 0 && col < startDayOfWeek - 1) {
	                // Espaços em branco para dias antes do primeiro dia do mês
	                data[row][col] = "";
	            } else if (day > numDaysInMonth) {
	                // Espaços em branco para dias após o último dia do mês
	                data[row][col] = "";
	            } else {
	                // Preencher com o número do dia
	                data[row][col] = day;
	                day++;
	            }
	        }
	    }
	    
	    JTable calendarTable = new JTable(data, columnNames);
	    calendarTable.setPreferredScrollableViewportSize(new Dimension(200,100));
	    calendarTable.setFillsViewportHeight(true);
	    calendarTable.setBackground(new Color(234,221,202));
	   
	    // Criar a tabela do calendário
	    return calendarTable;
	}
	
	private JPanel criarRightPanel()
	{
		JPanel panel = new JPanel(new MigLayout("wrap","push[center]push","push[]5[]5[]push"));
		Reprodutor rep = new Reprodutor();
		panel.add(image);
		panel.add(rep);
		panel.add(image2);
		panel.setBackground(new Color(193,154,107));
		return panel;
	}
}
