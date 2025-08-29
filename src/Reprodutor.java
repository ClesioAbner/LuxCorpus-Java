import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import net.miginfocom.swing.MigLayout;

public class Reprodutor extends JPanel implements ActionListener {
    private JButton botaoReproduzir;
    private JButton botaoPausar;
    private JButton botaoParar;
    private JLabel labelStatus;
    private Clip clip;

    public Reprodutor() {
        // Configuração da janela
        //setTitle("Reprodutor de Música");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação dos botões e rótulo
        botaoReproduzir = new JButton("Reproduzir");
        botaoReproduzir.setBackground(new Color(234,221,202));
        botaoReproduzir.setForeground(new Color(111,78,55));
        
        botaoPausar = new JButton("Pausar");
        botaoPausar.setBackground(new Color(234,221,202));
        botaoPausar.setForeground(new Color(111,78,55));
        
        botaoParar = new JButton("Parar");
        botaoParar.setBackground(new Color(234,221,202));
        botaoParar.setForeground(new Color(111,78,55));
        
        labelStatus = new JLabel("Status: Nenhuma música sendo reproduzida.");
        labelStatus.setForeground(Color.white);

        // Configuração dos listeners de ação para os botões
        botaoReproduzir.addActionListener(this);
        botaoPausar.addActionListener(this);
        botaoParar.addActionListener(this);

        // Configuração do layout da janela
        setLayout(new MigLayout("wrap 3","push[center]7[center]1[center]push","push[]2[]push"));

        // Adição dos componentes à janela
        add(botaoReproduzir);
        add(botaoPausar);
        add(botaoParar);
        add(labelStatus,"span,wrap");

        //pack();
        setBackground(new Color(193,154,107));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoReproduzir) {
            if (clip != null && clip.isRunning()) {
                // Verifica se a música já está sendo reproduzida
                labelStatus.setText("Status: A música já está sendo reproduzida.");
                return;
            }

            // Seletor de arquivo para escolher a música a ser reproduzida
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    // Carrega o arquivo de áudio e reproduz
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();
                    labelStatus.setText("Status: Reproduzindo a música " + file.getName());
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == botaoPausar) {
            if (clip != null && clip.isRunning()) {
                // Pausa a reprodução da música
                clip.stop();
                labelStatus.setText("Status: Música pausada.");
            } else {
                labelStatus.setText("Status: Nenhuma música sendo reproduzida.");
            }
        } else if (e.getSource() == botaoParar) {
            if (clip != null) {
                // Interrompe a reprodução da música e fecha o Clip
                clip.stop();
                clip.close();
                labelStatus.setText("Status: Reprodução da música interrompida.");
            } else {
                labelStatus.setText("Status: Nenhuma música sendo reproduzida.");
            }
        }
    }

    /*public static void main(String[] args) {
        // Inicia a aplicação Swing no thread de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Reprodutor();
            }
        });
    }
    */
}