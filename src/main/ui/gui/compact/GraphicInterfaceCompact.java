package ui.gui.compact;

import ui.gui.MainFrame;

import javax.swing.JFrame;

//CITATION: Class referenced / modified from youtube "Advanced Java: Swing (GUI) Programming" tutorial series by
//"Cave of Programming" Part 1.
// Part 1: https://www.youtube.com/watch?v=jUEOWVjnIR8
// Line 16 from Part 2.
// Part 2: https://www.youtube.com/watch?v=svM0SBFqp4s
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// in this project are all my original work.

public class GraphicInterfaceCompact {

    public GraphicInterfaceCompact() {
        JFrame frame = new MainFrameCompact("Dashboard - Nano Edition");

        frame.setSize(850, 700);
        frame.setMinimumSize(frame.getSize());
        frame.setMaximumSize(frame.getSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CITATION: Lines 26-27 copied from JRL's answer edited by Tot Zam on
        // https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-
        // monitor-resolution
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}