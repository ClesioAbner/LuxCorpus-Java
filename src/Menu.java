import java.io.*;
import java.util.*;

public class Menu {

	public Menu() {}
	
	public void menu()
	{
		
		Visualizacoes vi=new Visualizacoes();
		Validacoes val=new Validacoes();
		Tarefas tf=new Tarefas();
		
		byte op,op1,op2;
		boolean passou=false;
		
		do
		{
			vi.menu();
			op=val.validarOpcao((byte)1,(byte)14);
			
			switch(op)
			{
				case 1:
					tf.lerDoFicheiro();
					passou=true;
					break;
				case 2:
					if(passou==false)
						System.out.println("Execute a primeira opcão!");
					else
					{
						do
						{
							vi.submenu();
							op1=val.validarOpcao((byte)1,(byte)7);
							switch(op1)
							{
								case 1:
									tf.adaptadorVisualizarSocGold();
									break;
								case 2:
									tf.adaptadorVisualizarSocPremium();
									break;
								case 3:
									tf.adaptadorVisualizarSocSilver();
									break;
								case 4:
									tf.adaptadorVisualizarSocStandard();
									break;
								case 5:
									//tf.adaptadorVisualizarSocTotal();
									break;
								case 6:
									tf.adaptadorContarSocios();
								case 7:
							}
						}while(op1!=7);
					}
					break;
				case 3:
					if(passou==false)
						System.out.println("Execute a primeira opcão!");
					else
					{
						do
						{
							vi.submenu1();
							op2=val.validarOpcao((byte)1,(byte)7);
							switch(op2)
							{
								case 1:
									tf.adaptadorVisualizarResGold();
									break;
								case 2:
									tf.adaptadorVisualizarResPremium();
									break;
								case 3:
									tf.adaptadorVisualizarResSilver();
									break;
								case 4:
									tf.adaptadorVisualizarResStandard();
									break;
								case 5:
									tf.adaptadorVisualizarReservas();
									break;
								case 6:
									tf.adaptadorVisualizarTipo();
									break;
								case 7:
							}
						}while(op2!=7);	
					}
					break;
				case 4:
					tf.adaptadorvalorAcum();
					break;
				case 5:
					tf.adaptadorCalcularValorTotalDesconto();				
					break;
				case 6:
					tf.adaptadorVisualizarAbril();
					break;
				case 7:
					tf.adaptadorVisualizarSocioAntigo();
					break;
				case 8:
					tf.adaptadorescreverNoFicheiroDeObjeto();
					break;
				case 9:
					tf.adaptadorLerNoFicheiroDeObjeto();
					break;
				case 10:
					tf.adaptadorAlterarHora();
					break;
				case 11:
					tf.adaptadorRemover();
					break;
				case 12:
					tf.adaptadorNovoSocio();
					break;
				case 13:
					tf.adaptadorDadosProgramador();
					break;
				case 14:
					  System.out.println("---------------------------------");
					  System.out.println("|Obrigado por usar este Programa|");
					  System.out.println("---------------------------------");
					break;
			}
	
		}while(op!=14);
	}
}
