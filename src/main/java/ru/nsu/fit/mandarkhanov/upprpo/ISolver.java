package ru.nsu.fit.mandarkhanov.upprpo;

public interface ISolver {
    void SetInput(Object[] parameters);
    void Run();
    Object[] GetOutput();
}