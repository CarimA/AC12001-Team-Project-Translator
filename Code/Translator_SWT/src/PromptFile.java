/*Copied from http://www.java2s.com/Tutorial/Java/0240__Swing/UsingaJFileChooserinYourJFrame.htm*/

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PromptFile {

  public static String Browse() {

	String path;

	JFrame frame = new JFrame("JFileChooser Popup");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JLabel directoryLabel = new JLabel(" ");
    directoryLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
    frame.add(directoryLabel, BorderLayout.NORTH);

    final JLabel filenameLabel = new JLabel(" ");
    filenameLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
    frame.add(filenameLabel, BorderLayout.SOUTH);

    JFileChooser fileChooser = new JFileChooser(".");
    fileChooser.setControlButtonsAreShown(false);
    frame.add(fileChooser, BorderLayout.CENTER);
    path = fileChooser.getSelectedFile().getAbsolutePath();

    frame.pack();
    frame.setVisible(true);
    
    return path;
  }
}