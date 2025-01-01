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
    private final Map<String, Command> commands;
    private BarchartDisplay display;
    private SelectStatisticDialog dialog;

    public MainFrame() throws HeadlessException {
        commands = new HashMap<>();
        this.setTitle("Kata3");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        add(BorderLayout.NORTH,toolbar());
        add(createBarchartDisplay());
    }

    private Component createBarchartDisplay() {
        JFreeBarchartDisplay jFreeBarchartDisplay = new JFreeBarchartDisplay();
        display= jFreeBarchartDisplay;
        return jFreeBarchartDisplay;
    }

    public void put(String name, Command command){
        commands.put(name, command);
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(Selector());
        return panel;
    }

    private Component Selector() {
        JComboBox<Object> comboBox = new JComboBox<>();
        comboBox.addItem("Strength Scaling");
        comboBox.addItem("Dexterity Scaling");
        comboBox.addItem("Intelligence Scaling");
        comboBox.addItem("Faith Scaling");
        comboBox.addItem("Arcane Scaling");
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()!=ItemEvent.SELECTED)return;
                commands.get("selectStatistic").execute();
            }
        });
        dialog= new SelectStatisticDialog() {
            @Override
            public int getSelection() {
                return comboBox.getSelectedIndex();
            }
        };
        return comboBox;
    }


    public SelectStatisticDialog getDialog() {
        return dialog;
    }

    public BarchartDisplay getDisplay() {
        return display;
    }
}
