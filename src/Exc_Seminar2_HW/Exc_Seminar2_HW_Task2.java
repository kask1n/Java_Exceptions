package Exc_Seminar2_HW;
/*
 * Домашняя работа 2.
 * Задача 2.
 * Исправить нижеприведённый код.
 */

public class Exc_Seminar2_HW_Task2 {
    public static void main(String[] args) {

        int[] intArray = {11, 12, 13, 14, 15, 16, 17, 18, 19};
        try {
            int d = 0;
            int catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: Out of bounds!");
        }

    }
}
