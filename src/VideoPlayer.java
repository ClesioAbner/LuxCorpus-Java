import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class VideoPlayer {

    public static void main(String[] args) {
        openVideo();
    }

    public static void openVideo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Video", "mp4", "avi", "mkv");
        fileChooser.setFileFilter(filter);

        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            playVideo(file);
        }
    }

    public static void playVideo(File file) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao abrir o video.");
            }
        } else {
            System.out.println("A abertura de arquivos não é suportada neste ambiente.");
        }
    }
}