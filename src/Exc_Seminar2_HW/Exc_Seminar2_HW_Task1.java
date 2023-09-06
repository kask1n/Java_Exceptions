package Exc_Seminar2_HW;
/*
 * Домашняя работа 2.
 * Задача 1.
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 * и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

import java.util.Scanner;

public class Exc_Seminar2_HW_Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        float num = 0;
        while (num == 0) {
            System.out.println("Enter a fractional number: ");
            String input = scanner.next();
            try {
                num = Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Not a number!");
            }
        }

        System.out.println(num);
    }
}
