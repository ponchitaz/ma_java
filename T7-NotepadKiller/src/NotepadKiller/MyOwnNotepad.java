package NotepadKiller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

/**
 * The program creates a GUI form
 * which can open and save .txt files,
 * also displaying their titles and path.
 */
public class MyOwnNotepad {

    public static void main(String[] args) {

        //create the elements and add them to the form
        JFrame theKiller = new JFrame("Let's kill");
        JMenuBar theMenuBar = new JMenuBar();
        theKiller.setJMenuBar(theMenuBar);
        JMenu whatCanItOffer = new JMenu("What?");
        theMenuBar.add(whatCanItOffer);
        JMenuItem open = new JMenuItem("Open");
        whatCanItOffer.add(open);
        JMenuItem save = new JMenuItem("Save");
        whatCanItOffer.add(save);
        JMenuItem exit = new JMenuItem("Exit");
        whatCanItOffer.add(exit);
        JLabel theFileName = new JLabel();
        theFileName.setBounds(25, 15, 100, 25);
        theKiller.add(theFileName);
        JLabel filePath = new JLabel("Path: ");
        filePath.setBounds(25, 300, 100, 25);
        theKiller.add(filePath);
        JTextField theFilePath = new JTextField();
        theFilePath.setBounds(25, 325, 300, 25);
        theKiller.add(theFilePath);
        JLabel contents = new JLabel("What's inside: ");
        contents.setBounds(25, 40, 100, 25);
        theKiller.add(contents);
        final JTextArea thisIsTheFile = new JTextArea();
        theKiller.add(thisIsTheFile);
        final JScrollPane scrollTheArea = new JScrollPane(thisIsTheFile, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollTheArea.setBounds(25, 65, 550, 225);
        theKiller.add(scrollTheArea, BorderLayout.CENTER);

        //set the form appearance
        theKiller.setLayout(null);
        theKiller.setVisible(true);
        theKiller.setSize(600, 500);

        //open function
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser openThatFile = new JFileChooser();
                int wut = openThatFile.showDialog(null, "Open! OPEN!!!");
                if (wut == openThatFile.APPROVE_OPTION) {
                    File theFile = openThatFile.getSelectedFile();
                    theFileName.setText("Title: " + theFile.getName());
                    theFilePath.setText(theFile.getPath());
                    try {
                        BufferedReader bufferThat = new BufferedReader(new FileReader(theFile));
                        String line;
                        while ((line = bufferThat.readLine()) != null) {
                            thisIsTheFile.append(line);
                            thisIsTheFile.append("\n");
                        }
                        bufferThat.close();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }
        });

        //saving
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String theFileName = theFilePath.getText().trim();
                String theFilePlot = thisIsTheFile.getText().trim();
                if (theFileName.length() > 0) {
                    try {
                        FileWriter saveIt = new FileWriter(theFileName);
                        saveIt.write(theFilePlot);
                        saveIt.flush();
                        saveIt.close();
                        JOptionPane.showMessageDialog(save, "File saved.", "Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch (IOException ex) {
                        JOptionPane.showMessageDialog(save, e.toString(), "Result", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // exit by clicking exit in the menu
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
