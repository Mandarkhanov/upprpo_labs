package ru.nsu.fit.mandarkhanov.upprpo;

public class QuadraticEquationSolver implements ISolver
{
    private double coefficientA;
    private double coefficientB;
    private double coefficientC;
    private Object[] output;

    @Override
    public void SetInput(Object[] parameters) {
        coefficientA = (double) parameters[0];
        coefficientB = (double) parameters[1];
        coefficientC = (double) parameters[2];
    }

    @Override
    public void Run() {
        double discriminant = Math.pow(coefficientB, 2) - 4 * coefficientA * coefficientC;

        if (discriminant < 0)
        {
            output = new Object[]{};
            return;
        }
        output = new Object[2];
        output[0] = (-coefficientB + Math.sqrt(discriminant)) / (2 * coefficientA);
        output[1] = (-coefficientB - Math.sqrt(discriminant)) / (2 * coefficientA);
    }

    @Override
    public Object[] GetOutput() {
        return output;
    }
}
