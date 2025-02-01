package equations;

// ax^4+bx^2+c=0
public class BiQuadraticEquation extends Equation {
    private double a = 0;

    public BiQuadraticEquation(double a, double b, double c) {
        super(b, c);
        this.a = a;
    }

    @Override
    public ISolutionsSet solve() {
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        ISolutionsSet solutionsSet = quadraticEquation.solve();

        if (solutionsSet.isEmpty()) {
            return new SolutionsSet(SolutionsSetType.EMPTY);
        } else if (solutionsSet.isInfinite()) {
            return new SolutionsSet(SolutionsSetType.INFINITE);
        } else {
            SolutionsSet biSolutionSet = new SolutionsSet(SolutionsSetType.EMPTY);
            for (double solution : solutionsSet.getValues()) {
                if (solution >= 0) {
                    double alpha = Math.sqrt(solution);
                    double beta = -Math.sqrt(solution);
                    biSolutionSet.addValue(alpha);
                    biSolutionSet.addValue(beta);
                }
            }
            return biSolutionSet;
        }
    }

    @Override
    public String toString() {
        return "%.0fx^4 + %.0fx^2 + %.0f = 0".formatted(a, b, c);
    }
}
