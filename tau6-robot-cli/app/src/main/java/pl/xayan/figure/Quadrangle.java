package pl.xayan.figure;

import java.util.Arrays;

public class Quadrangle implements FigureInterface {
    private Integer[] lengths;

    Quadrangle(Integer[] lengths) {
        this.lengths = lengths;

        Arrays.sort(this.lengths);
    }

    @Override
    public boolean isValid() {
        if(lengths.length != 4) return false;

        return lengths[0] + lengths[1] + lengths[2] > lengths[3];
    }

    @Override
    public String getType() {
        if(lengths[0].equals(lengths[1]) && lengths[1].equals(lengths[2]) && lengths[2].equals(lengths[3])) {
            return "kwadrat";
        } else if(lengths[0].equals(lengths[1]) && lengths[2].equals(lengths[3])) {
            return "prostokąt";
        } else {
            return "czworobok";
        }
    }
}
