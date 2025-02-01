package equations;

import java.util.List;
import java.util.TreeSet;

public class SolutionsSet implements ISolutionsSet {
    private final TreeSet<Double> values = new TreeSet<>();
    private SolutionsSetType type;

    public SolutionsSet(SolutionsSetType type) {
        this.type = type;
    }

    public void addValue(double value) {
        this.type = SolutionsSetType.FINITE;
        this.values.add(value);
    }

    @Override
    public boolean isInfinite() {
        return type == SolutionsSetType.INFINITE;
    }

    @Override
    public boolean isEmpty() {
        return type == SolutionsSetType.EMPTY;
    }

    @Override
    public int size() {
        return switch (this.type) {
            case EMPTY -> 0;
            case FINITE -> this.values.size();
            case INFINITE -> throw new IllegalStateException("Call isInfinite() before calling size()!");
        };
    }

    @Override
    public double getMinValue() {
        if (this.type != SolutionsSetType.FINITE) {
            throw new IllegalStateException("Can't get minimum value of %s solutions set!".formatted(this.type));
        }
        return this.values.first();
    }

    @Override
    public double getMaxValue() {
        if (this.type != SolutionsSetType.FINITE) {
            throw new IllegalStateException("Can't get maximum value of %s solutions set!".formatted(this.type));
        }
        return this.values.last();
    }

    @Override
    public List<Double> getValues() {
        return values.stream().toList();
    }
}
