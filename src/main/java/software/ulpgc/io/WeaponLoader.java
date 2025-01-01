package software.ulpgc.io;

import software.ulpgc.model.Weapon;

import java.io.IOException;
import java.util.List;

public interface WeaponLoader {
    List<Weapon> load()throws IOException;
}
