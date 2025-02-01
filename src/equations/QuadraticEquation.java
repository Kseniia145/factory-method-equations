package equations;

// ax^2+bx+c=0
public class QuadraticEquation extends Equation {
    private double a = 0;

    public QuadraticEquation(double a, double b, double c) {
        super(b, c);
        this.a = a;
    }

    @Override
    public ISolutionsSet solve() {
        if (a == 0) {
            // bx+c=0
            return super.solve();
        } else {
            double discriminant = Math.pow(b, 2) - 4 * a * c;
            if (discriminant < 0) {
                return new SolutionsSet(SolutionsSetType.EMPTY);
            } else {
                // We don't need to take care of discriminant == 0 case since SolutionSet will ignore duplicate values
                double alpha = (-b + Math.sqrt(discriminant)) / (2 * a);
                double beta = (-b - Math.sqrt(discriminant)) / (2 * a);
                SolutionsSet solutionsSet = new SolutionsSet(SolutionsSetType.FINITE);
                solutionsSet.addValue(alpha);
                solutionsSet.addValue(beta);
                return solutionsSet;
            }
        }
    }

    @Override
    public String toString() {
        return "%.0fx^2 + %.0fx + %.0f = 0".formatted(a, b, c);
    }
}
