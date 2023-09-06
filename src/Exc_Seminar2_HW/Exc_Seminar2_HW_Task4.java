package Exc_Seminar2_HW;
/*
 * Домашняя работа 2.
 * Задача 4.
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

import java.util.Scanner;

public class Exc_Seminar2_HW_Task4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String input = scanner.nextLine();

        try {
            if (input == null || input.isEmpty()) throw new Exception();
            System.out.println(input);
        } catch (Exception e) {
            System.out.println("ERROR: Blank lines cannot be entered!");
        }

    }
}
