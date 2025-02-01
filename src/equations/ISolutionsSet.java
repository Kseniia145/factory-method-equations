package equations;

// This interface is returned from Equation.solve() to hide addValue() function
public interface ISolutionsSet {

    boolean isInfinite();

    boolean isEmpty();

    int size();

    double getMinValue();

    double getMaxValue();
}
