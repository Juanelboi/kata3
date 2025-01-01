package software.ulpgc.io;

import software.ulpgc.model.Barchart;
import software.ulpgc.model.Scaling;
import software.ulpgc.model.Weapon;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class StatisticBarchartBuilder implements BarchartBuilder{
    private final File file= new File("ERW.csv");
    private final List<Weapon> weapons;

    {
        try {
            weapons = new FileWeaponLoader(file, new CsvWeaponDeserializer()).load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Barchart load(int id) {
        return switch (id){
            case 0-> getStatisticBarchart("Strength Scaling", Weapon::Strength);
            case 1-> getStatisticBarchart("Dexterity Scaling", Weapon::Dexterity);
            case 2-> getStatisticBarchart("Intelligence Scaling", Weapon::Intelligence);
            case 3-> getStatisticBarchart("Faith Scaling", Weapon::Faith);
            case 4-> getStatisticBarchart("Arcane Scaling", Weapon::Arcane);
            default -> null;
        };
    }

    private Barchart getStatisticBarchart(String title, Function<Weapon, Scaling> method) {
        Barchart barchart = new Barchart(title, "Scalings", "WeaponCount");
        getStatisticscount(method, barchart);
        return barchart;

    }

    private void getStatisticscount(Function<Weapon, Scaling> method, Barchart barchart) {
        for (Scaling value : Scaling.values()) {
            barchart.put(value.name(), (int) weapons.stream().filter(w-> method.apply(w)==value).count());
        }
    }
}
