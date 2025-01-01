package software.ulpgc.control;

import software.ulpgc.io.BarchartBuilder;
import software.ulpgc.view.BarchartDisplay;
import software.ulpgc.view.SelectStatisticDialog;

public class SelectStatisticCommand implements Command{
    private final BarchartDisplay display;
    private final BarchartBuilder builder;
    private final SelectStatisticDialog dialog;

    public SelectStatisticCommand(BarchartDisplay display, BarchartBuilder builder, SelectStatisticDialog dialog) {
        this.display = display;
        this.builder = builder;
        this.dialog = dialog;
    }


    @Override
    public void execute() {
        display.show(builder.load(dialog.getSelection()));
    }
}
