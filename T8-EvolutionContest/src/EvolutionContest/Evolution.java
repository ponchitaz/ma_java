package EvolutionContest;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The program is the example of parallel programming.
 * It creates a window where two progress bars show
 * two threads in progress.
 */
public class Evolution {
    public static void main(String[] args) {
        //setting GUI elements
        JFrame evolutionStatus = new JFrame("That's how we grow!");
        evolutionStatus.setVisible(true);
        evolutionStatus.setLayout(null);
        evolutionStatus.setSize(450, 250);
        JLabel mameLabel = new JLabel("Mametchi grows:");
        mameLabel.setBounds(25, 25, 200, 15);
        JLabel kuchiLabel = new JLabel("Kuchipatchi grows:");
        kuchiLabel.setBounds(25, 90, 200, 15);
        JProgressBar mameProgress = new JProgressBar();
        mameProgress.setBounds(25, 50, 350, 20);
        JProgressBar kuchiProgress = new JProgressBar();
        kuchiProgress.setBounds(25, 115, 350, 20);
        evolutionStatus.add(mameLabel);
        evolutionStatus.add(kuchiLabel);
        evolutionStatus.add(mameProgress);
        evolutionStatus.add(kuchiProgress);

        //setting threads
        Mametchi mametchi = new Mametchi();
        Thread mameThread = new Thread(mametchi);
        mameThread.setPriority(Thread.MIN_PRIORITY);
        Kuchipatchi kuchipatchi = new Kuchipatchi();
        Thread kuchiThread = new Thread(kuchipatchi);
        kuchiThread.setPriority(Thread.MAX_PRIORITY);
        kuchiThread.start();
        mameThread.start();

        //setting timers for running threads - instead of sleep
        int mameEvolutionTimer = 15;
        new javax.swing.Timer(mameEvolutionTimer, new ActionListener() {
            private int mameIndex = 0;
            private int mameIndexToTheMaximum = 100;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mameIndex<mameIndexToTheMaximum) {
                    mameProgress.setValue(mameIndex);
                    mameProgress.setString(mameIndex + " lvl");
                    mameIndex++;
                }
                else {
                    mameProgress.setValue(mameIndexToTheMaximum);
                    ((javax.swing.Timer)e.getSource()).stop();
                }
            }
        }).start();

        int kuchiEvolutionTimer = 10;
        new javax.swing.Timer(kuchiEvolutionTimer, new ActionListener() {
            private int kuchiIndex = 0;
            private int kuchiIndexToTheMaximum = 100;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (kuchiIndex<kuchiIndexToTheMaximum) {
                    kuchiProgress.setValue(kuchiIndex);
                    kuchiProgress.setString(kuchiIndex + " lvl");
                    kuchiIndex++;
                }
                else {
                    kuchiProgress.setValue(kuchiIndexToTheMaximum);
                    ((javax.swing.Timer)e.getSource()).stop();
                }
            }
        }).start();

        //setting progress bars to display text about the progress
        mameProgress.setStringPainted(true);
        kuchiProgress.setStringPainted(true);
        mameProgress.setValue(mameProgress.getMinimum());
        kuchiProgress.setValue(kuchiProgress.getMinimum());
    }
}

//setting the runnable classes
class Kuchipatchi implements Runnable{
    @Override
    public void run() {}
}
class Mametchi implements Runnable{
    @Override
    public void run() {}
}
