package software.ulpgc.app;


import software.ulpgc.control.SelectStatisticCommand;
import software.ulpgc.io.StatisticBarchartBuilder;

import java.io.File;
import java.io.IOException;

import static software.ulpgc.io.ResourceDownloader.download;

public class Main {
    public static void main(String[] args) throws IOException {

        GetERWfile();

        MainFrame mainFrame = new MainFrame();
        StatisticBarchartBuilder builder = new StatisticBarchartBuilder();
        mainFrame.put("selectStatistic",
                new SelectStatisticCommand(
                        mainFrame.getDisplay(),
                        builder,
                        mainFrame.getDialog()));
        mainFrame.getDisplay().show(builder.load(0));

        mainFrame.setVisible(true);
    }

    private static void GetERWfile() {
        File path = new File("");
        String Path = path.getAbsolutePath();
        String urlInput= "https://raw.githubusercontent.com/Juanelboi/Resources/refs/heads/main/ERW.csv";
        String urlOutputPath = Path+"\\ERW.csv";
        download(urlInput, urlOutputPath);
    }
}