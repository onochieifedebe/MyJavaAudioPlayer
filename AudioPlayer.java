import java.io.*;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

class AudioPractice {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        String files = JOptionPane.showInputDialog("Enter File Path Here");
        File file = new File(files);
        if (file.exists()) {
            JOptionPane.showMessageDialog(null, "New File read!");
        } else {
            JOptionPane.showMessageDialog(null, "File Doesn't Exist");
        }
        AudioInputStream stream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        clip.open(stream);

        String playerControl = " ";

        while (!playerControl.equals("Q")) {
            playerControl = JOptionPane.showInputDialog("P =  play, S= Stop, R = Reset, Q = Quit");
            playerControl = playerControl.toUpperCase();

            switch (playerControl) {
                case ("P"):
                    clip.start();
                    break;
                case ("S"):
                    clip.stop();
                    break;
                case ("Q"):
                    clip.close();
                    break;
                case ("R"):
                    clip.setMicrosecondPosition(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid response");
            }

        }

    }
}