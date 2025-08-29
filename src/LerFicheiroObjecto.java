import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;
public class LerFicheiroObjecto {

	public void LerFicheiroObjecto() {}
	
	public void lerFicheiroObjectos(Vector vecUm)
	{
		try
		{
			FileInputStream fout = new FileInputStream("Dados.dat");
			ObjectInputStream out = new ObjectInputStream(fout);
			
			vecUm.addElement(out.readObject());
			out.close();
			
			JOptionPane.showMessageDialog(null, "::: Ficheiro Lido com Sucesso :::");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(FileNotFoundException z)
		{
			System.out.println(z.getMessage());
		}
		catch(IOException d)
		{
			System.out.println(d.getMessage());
		} 
		
	}
	
}
