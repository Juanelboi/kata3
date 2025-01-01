package software.ulpgc.app;


import software.ulpgc.control.SelectStatistiscCommand;
import software.ulpgc.io.StatisticBarchartBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        StatisticBarchartBuilder builder = new StatisticBarchartBuilder();
        mainFrame.put("selectStatistic",
                new SelectStatistiscCommand(
                        mainFrame.getDialog(),
                        builder,
                        mainFrame.getDisplay()));
        mainFrame.setVisible(true);
    }
}