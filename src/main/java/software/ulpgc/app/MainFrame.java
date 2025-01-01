package software.ulpgc.app;

import software.ulpgc.control.Command;
import software.ulpgc.view.BarchartDisplay;
import software.ulpgc.view.SelectStatisticDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        this.setTitle("Kata3");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

    }

}
