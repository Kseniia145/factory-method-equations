import equations.Equation;
import equations.QuadraticEquation;

import java.util.List;

// Simple Factory Method is the best suited here
// Since we need to create correct equation type depending
// on the number of coefficients
public class EquationFactory {
    public Equation createEquation(List<Double> coefficients) {
        if (coefficients == null) {
            throw new IllegalArgumentException("Null is not allowed for coefficients");
        }
        if (coefficients.size() == 1 || coefficients.size() == 4 || coefficients.size() > 5) {
            throw new IllegalArgumentException("Can't create equation with %d of coefficients!".formatted(coefficients.size()));
        }

        // at this point we have either 2, 3 or 5 coefficients
        if (coefficients.size() == 2) {
            return new Equation(coefficients.get(0), coefficients.get(1));
        } else if (coefficients.size() == 3) {
            return new QuadraticEquation(coefficients.get(0), coefficients.get(1), coefficients.get(2));
        }
        return new QuadraticEquation(coefficients.get(0), coefficients.get(1), coefficients.get(2)); // todo return BiQuadraticEquation
    };
}
