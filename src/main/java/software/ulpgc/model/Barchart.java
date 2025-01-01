package software.ulpgc.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Barchart {
    private final Map<String, Integer> count;
    private final String title;
    private final String xAxis;
    private final String yAxis;

    public Barchart( String title, String xAxis, String yAxis) {
        this.count = new LinkedHashMap<>();
        this.title = title;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Set<String> keySet() {
        return count.keySet();
    }

    public Integer get(Object key) {
        return count.get(key);
    }

    public Integer put(String key, Integer value) {
        return count.put(key, value);
    }

    public String getTitle() {
        return title;
    }

    public String getxAxis() {
        return xAxis;
    }

    public String getyAxis() {
        return yAxis;
    }
}
