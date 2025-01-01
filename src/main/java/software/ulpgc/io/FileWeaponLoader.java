package software.ulpgc.io;

import software.ulpgc.model.Weapon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWeaponLoader implements WeaponLoader{
    private final File file;
    private final WeaponDeserializer deserializer;

    public FileWeaponLoader(File file, WeaponDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }


    @Override
    public List<Weapon> load() throws IOException {
        ArrayList<Weapon> weapons = new ArrayList<>();
        try(BufferedReader reader= new BufferedReader(new FileReader(file))) {
            SkipFirstLine(reader);
            while (true){
                String line = reader.readLine();
                if (line==null) break;
                weapons.add(deserializer.deserialize(line));
            }
        }return weapons;
    }

    private void SkipFirstLine(BufferedReader reader) throws IOException {
        reader.readLine();
    }
}
