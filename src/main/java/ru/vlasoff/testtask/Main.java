package ru.vlasoff.testtask;

/**
 * @author Vladimir Vlasoff
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    // получаем размер массива
    public static int getSize() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        if (size < 10) throw new RuntimeException("Число должно быть не меньше 10");
        return size;
    }
    // генерируем массив [1..size(включительно)]
    public static int[] getArr(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
    // удаляем рандомный элемент
    public static int[] deleteRandomElement(int[] arr) {
        // лист, ибо из него удалять удобно
        List<Integer> listArr = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        // удаляем рандомный элемент
        listArr.remove((int) Math.floor(Math.random() * arr.length));
        return listArr.stream().mapToInt(i -> i).toArray();
    }
    // мешаем массив
    public static int[] shuffleArray(int[] arr) {
        // массив
        int[] shuffledArray = new int[arr.length];
        // индексы
        List<Integer> indexes = new ArrayList<>(arr.length);
        // счетчик
        int counter = 0;
        do {
            // выбираем индекс (рандомно)
            int index = (int) Math.floor(Math.random() * arr.length);
            // проверяем, если индекс не заполнен
            if (!indexes.contains(index)) {
                // добавляем
                indexes.add(index);
                // присваиваем
                shuffledArray[index] = arr[counter++];
            }
        } while (counter != arr.length); // пока не заполнили все элементы
        // возвращаем массив
        return shuffledArray;
    }

    // решение тупо в лоб
    public static int findDeletedIndex(int[] arr) {
        // Действие №1 - сортируем массив
        Arrays.sort(arr);
        // если удалали 1, то возвращаем её
        if (arr[0] != 1) return 1;
        // Действие №2 - проходимся и находим элемент
        for (int i = 1; i < arr.length; i++) {   //
            // если текущий и предыдущий элементы отличаются не на 1
            if (arr[i] - arr[i - 1] != 1)
                // то мы нашли удаленный элемент
                return arr[i] - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // тестим
        System.out.print("Введите размер массива(>= 10): ");
        int size = getSize();
        int[] arr = getArr(size);
        // пробелы для наглядности
        System.out.println("Массив :                " + Arrays.toString(arr));
        int[] newArr = deleteRandomElement(arr);
        System.out.println("Массив после удаления : " + Arrays.toString(newArr));
        int[] shuffledArray = shuffleArray(newArr);
        System.out.println("Перемешанный массив:    " + Arrays.toString(shuffledArray));
        System.out.println("Искомый элемент: " + findDeletedIndex(shuffledArray));
    }
}
