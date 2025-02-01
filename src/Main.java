import equations.Equation;
import equations.ISolutionsSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] files = {"input01.txt", "input02.txt", "input03.txt"};

        for (String file : files) {
            solveTask(file);
        }
    }

    private static void solveTask(String file) {
        System.out.printf("=========== Solving the task for %s =========== \n", file);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            EquationFactory equationFactory = new EquationFactory();
            List<Equation> equations = new ArrayList<>();

            // Read-in the lines and parse them to equations
            String line;
            while ((line = br.readLine()) != null) {
                List<Double> coefficients = parseCoefficients(line);
                if (!coefficients.isEmpty()) {
                    equations.add(equationFactory.createEquation(coefficients));
                }
            }

            // Solve all equations
            Map<Equation, ISolutionsSet> solutions = new HashMap<>();
            for (Equation eq : equations) {
                solutions.put(eq, eq.solve());
            }

            System.out.println("Equations with no solutions:");
            printEquations(equations.stream().filter(x -> solutions.get(x).isEmpty()).toList());
            System.out.println();


            int[] solutionsCounts = {1, 2, 3, 4};
            for (int solutionCount : solutionsCounts) {
                System.out.printf("Equations with %d solution(s):%n", solutionCount);
                printEquations(getEquationsWithSolutionCount(equations, solutions, solutionCount));
                System.out.println();
            }

            System.out.println("Equations with infinite number of solutions:");
            printEquations(equations.stream().filter(x -> solutions.get(x).isInfinite()).toList());
            System.out.println();


            List<Equation> oneSolutionEquations = getEquationsWithSolutionCount(equations, solutions, 1);
            // todo: find min & max solution equations

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("============================================");
    }

    private static List<Equation> getEquationsWithSolutionCount(List<Equation> equations, Map<Equation, ISolutionsSet> solutions, int solutionCount) {
        return equations.stream().filter(x -> !solutions.get(x).isInfinite() && solutions.get(x).size() == solutionCount).toList();
    }

    private static void printEquations(List<Equation> equations) {
        if (equations == null || equations.isEmpty()) {
            System.out.println("No equations found");
        } else {
            for (Equation equation : equations) {
                System.out.println(equation);
            }
        }
    }


    private static List<Double> parseCoefficients(String line) {
        List<Double> coefficients = new ArrayList<Double>();
        String[] coefficientStrings = line.split("\\s+"); // split on one-or-more whitespaces
        for (String coefficientStr : coefficientStrings) {
            if (!coefficientStr.isBlank()) {
                coefficients.add(Double.parseDouble(coefficientStr));
            }
        }
        return coefficients;
    }


}