package cn.extremeprogramming.dojo;

import static java.lang.String.format;

public class Length {
    private final String unit;
    private final int rawAmount;
    private final int amountInInches;

    public Length(int rawAmount, String unit) {
        this.rawAmount = rawAmount;
        this.unit = unit;

        if (unit.equals("Foot")) {
            amountInInches = rawAmount * 12;
        } else if (unit.equals("Yard")) {
            amountInInches = rawAmount * 36;
        } else {
            amountInInches = rawAmount;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Length another = (Length) obj;
        return another.amountInInches == amountInInches;
    }

    @Override
    public String toString() {
        return format("%d [%s]", rawAmount, unit);
    }
}
