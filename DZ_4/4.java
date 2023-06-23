// Задание
// Пусть дан произвольный список целых чисел.
// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

import java.util.ArrayList;
import java.util.List;

public class NumberOperations {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(7);
        numbers.add(2);
        numbers.add(9);
        numbers.add(4);

        numbers.removeIf(n -> n % 2 == 0);
        int min = numbers.stream().min(Integer::compareTo).orElse(0);
        int max = numbers.stream().max(Integer::compareTo).orElse(0);
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        System.out.println("Список без чётных чисел: " + numbers);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }
}
