package tutorial;

import ru.nsu.fit.mandarkhanov.upprpo.QuadraticEquationSolver;

public class Main {
    public static void main(String[] args) {
        var quadraticEquationSolver = new QuadraticEquationSolver();
        quadraticEquationSolver.SetInput(new Object[]{3.0, 6.0, 2.0});
        quadraticEquationSolver.Run();

        var solution = quadraticEquationSolver.GetOutput();

        System.out.printf("x_1 = %f, x_2 = %f\n", (double)solution[0], (double)solution[1]);
    }
}