import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Metodos extends JFrame {

	private JLabel field1,field2;
	public Metodos() {}
	
	public void metodoCopiar()
	{
		// Obter a inst�ncia da area de transfer�ncia do sistema
		Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
		// Criar uma inst�ncia de ClipboardOwner usando o texto do seuTextField
        ClipboardOwner selecao = new StringSelection(field1.getText());
       //Definir o conte�do da �rea de transfer�ncia com a sele��o criada
        board.setContents((Transferable) selecao, selecao);
	}
	
	public void metodoColar()
	{
		// Obt�m a �rea de transfer�ncia padrao
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        
        // Verifica se a �rea de transfer�ncia contem texto
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            try 
            {
                // Obt�m o conte�do da �rea de transfer�ncia como texto
                String textoColado = (String) clipboard.getData(DataFlavor.stringFlavor);
                // Define o texto colado no campo de texto
                field2.setText(textoColado);
            } catch (Exception ev) {
                // Exibe uma mensagem de erro em caso de falha
                JOptionPane.showMessageDialog(null, "Erro ao colar o texto");
            }
        }
	}
	public void MetodoLerFicheiro()
	{
		
    }
}

