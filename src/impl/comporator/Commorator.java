package impl.comporator;

import enams.Foods;

import java.util.Comparator;

public class Commorator implements Comparator<Foods> {
    @Override
    public int compare(Foods o1, Foods o2) {
        return o1.getPrice()-o2.getPrice();
    }
}
