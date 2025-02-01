package equations;

// bx + c = 0
public class Equation {
    protected double b = 0;
    protected double c = 0;

    public Equation(double b, double c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "%.0fx + %.0f = 0".formatted(b, c);
    }

    public ISolutionsSet solve() {
        if (b == 0) {
            if (c == 0) {
                // 0x + 0 = 0 has infinite solutions
                return new SolutionsSet(SolutionsSetType.INFINITE);
            } else {
                // 0x + c = 0, c != 0 has no solutions
                return new SolutionsSet(SolutionsSetType.EMPTY);
            }
        } else {
            // bx + c = 0, b != 0 has exactly one solution
            SolutionsSet solutionsSet = new SolutionsSet(SolutionsSetType.FINITE);
            solutionsSet.addValue(-c / b);
            return solutionsSet;
        }

    }
}
