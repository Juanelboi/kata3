package software.ulpgc.model;

public enum Scaling {
    noScaling,
    E,
    D,
    C,
    B,
    A,
    S;

    public static Scaling parseSacling(String s) {
        for (Scaling value : Scaling.values()) {
            if (s.equals(value.name())) return value;
        }return noScaling;
    }
}
