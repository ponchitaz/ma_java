import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.ScrollPaneConstants.*;

/**
 * The program creates a simple GUI form with a label,
 * a text area with a scroll bar,
 * radio buttons (only one of them can be active at one time),
 * and a button - if you push it there comes a counter
 * wich tells how many times the button was pushed.
 */
public class FirstGUI {
    private JButton pushIt;
    private JTextArea bigText;
    private JPanel whatIsIt;
    private JRadioButton radioTwo;
    private JRadioButton radioOne;
    private JLabel theLabel;
    private JScrollPane scrollThat;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static final String thisIsIt = "The text you can rewrite. \n"
            + "It is placed here just to see the scroll bars work. \n"
            + "I don't know what else to write here. \n"
            + "The text you can rewrite. \n"
            + "It is placed here just to see the scroll bars work. \n"
            + "I don't know what else to write here. \n"
            + "The text you can rewrite. \n"
            + "It is placed here just to see the scroll bars work. \n"
            + "I don't know what else to write here. \n"
            + "The text you can rewrite. \n"
            + "It is placed here just to see the scroll bars work. \n"
            + "I don't know what else to write here. \n"
            + "The text you can rewrite. \n"
            + "It is placed here just to see the scroll bars work. \n"
            + "I don't know what else to write here. \n"
            + "Hope this is enough.";

    public static void main(String[] args) {

        //creates the elements
        JFrame theWindow = new JFrame("This is the window");
        JButton pushIt = new JButton("Push it!");
        JTextArea bigInput = new JTextArea(thisIsIt);
        bigInput.setLineWrap(true);  //sets the text to the next line if the previous ended
        //bigInput.setText(thisIsIt);
        bigInput.setCaretPosition(0);
        final JScrollPane scrollThat = new JScrollPane(bigInput, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollThat.setViewportView(bigInput);
        JRadioButton radioOne = new JRadioButton("Right one!");
        radioOne.setSelected(true);
        radioOne.setMnemonic(1);
        JRadioButton radioTwo = new JRadioButton("Wrong one!");
        radioTwo.setMnemonic(2);
        JLabel theLabel = new JLabel("Label!");
        JLabel thePushingCounter = new JLabel();

        //adds the elements or smth like this
        theWindow.add(pushIt);
        //theWindow.add(bigInput);
        theWindow.add(scrollThat, BorderLayout.CENTER);
        theWindow.add(radioOne);
        theWindow.add(radioTwo);
        theWindow.add(theLabel);
        theWindow.add(thePushingCounter);

        //this is layout
        theWindow.setLayout(null);
        theWindow.setVisible(true);
        theWindow.setSize(600, 400);

        //setting element's appearance
        pushIt.setBounds(100, 50, 100, 30);
        //bigInput.setBounds(100, 100, 200, 125);
        scrollThat.setBounds(100, 100, 200, 125);
        theLabel.setBounds(125, 200, 100, 100);
        radioOne.setBounds(350, 125, 150, 15);
        radioTwo.setBounds(350, 150, 150, 15);
        thePushingCounter.setBounds(250, 50, 200, 30);

        //marks only ane radiobutton at the time
        ButtonGroup theRadios = new ButtonGroup();
        theRadios.add(radioOne);
        theRadios.add(radioTwo);

        //counting the number of button clicks
        pushIt.addActionListener(new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                thePushingCounter.setText("Pushed " + i + " times");
            }
        });
    }
}
