import java.io.*;
import java.util.Vector;

import javax.swing.JOptionPane;

public class EscreverFicheiroObjectos {

	public EscreverFicheiroObjectos() {}
	
	public void escreverFicheiroObjectos(Vector vecUm) 
	{
		try
		{
			FileOutputStream fout = new FileOutputStream("Escrever.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			
			out.writeObject(vecUm);
			out.close();
			
			JOptionPane.showMessageDialog(null, "Ficheiro Escrito com", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(IOException io) { System.out.println(io.getMessage()); };		
	}
}
