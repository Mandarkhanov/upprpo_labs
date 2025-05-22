package ru.nsu.fit.mandarkhanov.upprpo;

import java.util.ArrayList;
import java.util.List;

public class LinearCombinations {

    public static void main(String[] args) {
        // Базисные векторы
        int[] v1 = {1, 0, 0, 2, 0, 1};
        int[] v2 = {0, 1, 0, 1, 0, 2};
        int[] v3 = {0, 0, 1, 0, 1, 2};

        // Список для хранения всех линейных комбинаций
        List<int[]> combinations = new ArrayList<>();

        // Перебираем все возможные коэффициенты c1, c2, c3 ∈ {0, 1, 2}
        for (int c1 = 0; c1 < 3; c1++) {
            for (int c2 = 0; c2 < 3; c2++) {
                for (int c3 = 0; c3 < 3; c3++) {
                    // Вычисляем линейную комбинацию
                    int[] combination = new int[6];
                    for (int i = 0; i < 6; i++) {
                        combination[i] = (c1 * v1[i] + c2 * v2[i] + c3 * v3[i]) % 3;
                    }
                    combinations.add(combination);
                }
            }
        }

        // Выводим все комбинации
        System.out.println("Все линейные комбинации:");
        for (int[] comb : combinations) {
            for (int value : comb) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // Проверяем количество комбинаций
        System.out.println("Количество комбинаций: " + combinations.size());
    }
}