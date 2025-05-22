package ru.nsu.fit.mandarkhanov.upprpo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuadraticEquationSolverTest {

    private void RunTest(ISolver solver, Object[] input, double[] expectedOutput, double delta)
    {
        solver.SetInput(input);
        solver.Run();

        var actualOutput = solver.GetOutput();
        Assertions.assertEquals(expectedOutput.length, actualOutput.length);

        for (int i = 0; i < actualOutput.length; i++) {
            Assertions.assertEquals(expectedOutput[i], (double)actualOutput[i], delta);
        }
    }

    @Test
    public void TestQuadraticEquationSolver()
    {
        RunTest(new QuadraticEquationSolver(), new Object[] { 3.0, 6.0, 2.0 }, new double[]{ -0.422, -1.577 }, 1.0e-3);
        RunTest(new QuadraticEquationSolver(), new Object[] { -1.0, 10.0, -10.0 }, new double[] { 1.127, 8.872 }, 1.0e-3);
//        RunTest(new QuadraticEquationSolver(), new Object[] { -1.0, 19.0, 20.0 }, new double[] { }, 1.0e-3);
        RunTest(new QuadraticEquationSolver(), new Object[] { 7.0, 1.0, 2.0 }, new double[] { }, 0.0);
    }
}
