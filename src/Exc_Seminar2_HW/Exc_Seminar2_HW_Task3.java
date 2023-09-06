package Exc_Seminar2_HW;
/*
 * Домашняя работа 2.
 * Задача 3.
 * Исправить нижеприведённый код.
 */

public class Exc_Seminar2_HW_Task3 {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("ERROR: Divide by zero!");
        } catch (NullPointerException ex) {
            System.out.println("ERROR: Pointer cannot point to null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("ERROR: Out of bounds!");
        } catch (Throwable ex) {
            System.out.println("Something went wrong...");
        }
    }

    public static void printSum(Integer a, Integer b) { //удаляем лишнее throws FileNotFoundException
        System.out.println(a + b);
    }

}
