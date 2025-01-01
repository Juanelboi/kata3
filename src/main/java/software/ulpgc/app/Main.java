package software.ulpgc.app;


import software.ulpgc.control.SelectStatisticCommand;
import software.ulpgc.io.StatisticBarchartBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        StatisticBarchartBuilder builder = new StatisticBarchartBuilder();
        mainFrame.put("selectStatistic",
                new SelectStatisticCommand(mainFrame.getDisplay(), builder, mainFrame.getDialog()));

        mainFrame.getDisplay().show(builder.load(0));

        mainFrame.setVisible(true);
    }
}