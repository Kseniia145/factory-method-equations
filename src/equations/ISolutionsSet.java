package equations;

import java.util.List;

// This interface is returned from Equation.solve() to hide addValue() function
public interface ISolutionsSet {

    boolean isInfinite();

    boolean isEmpty();

    int size();

    List<Double> getValues();

    double getMinValue();

    double getMaxValue();
}
