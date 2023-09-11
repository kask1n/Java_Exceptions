/* Домашнее задание 3. Продвинутая работа с исключениями в Java.
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
 * Фамилия Имя Отчество Номер_телефона
 *
 * Форматы данных:
 * Фамилия, Имя, Отчество - строки
 * Номер_телефона - целое беззнаковое число без форматирования
 *
 * Ввод всех элементов через пробел.
 * Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
 * вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше или больше данных, чем требуется.
 *
 * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
 * Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
 * Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
 * пользователю выведено сообщение с информацией, что именно неверно.
 *
 * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
 * в него в одну строку должны записаться полученные данные, вида:
 * <Фамилия><Имя><Отчество><Номер_телефона>
 *
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
 * пользователь должен увидеть стектрейс ошибки.
 */

package Exc_Seminar3_HW;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc_Seminar3_HW_Task1_WriteToFile {
    public static void main(String[] args) {
        try {
            String[] strings = inputData();
            writeToFile(strings);
        } catch (InputFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String[] inputData() throws InputFormatException {
        System.out.println("Введите информацию через пробел: <Фамилия> <Имя> <Отчество> <Номер_телефона>");
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            String[] strings = input.split(" ");

            int status = lengthArray(strings);
            if (status == -1) {
                System.out.println("-> ERROR: Количество введённых элементов меньше, чем требуется!");
            } else if (status == 1) {
                System.out.println("-> ERROR: Количество введённых элементов больше, чем требуется!");
            } else {
                String lastName = strings[0];
                String firstName = strings[1];
                String patronymic = strings[2];
                int phone_number = Integer.parseInt(strings[3]);
                return strings;
            }
        } catch (NumberFormatException e) {
            throw new InputFormatException("-> ERROR: Номер телефона указан неверно!");
        }

        return new String[0];
    }

    public static int lengthArray(String[] strings) {
        if (strings.length < 4)
            return -1;
        else if (strings.length > 4)
            return 1;

        return 0;
    }

    private static void writeToFile(String[] filename) {
        try (FileWriter fw = new FileWriter(filename[0], true)) {
            for (String s : filename)
                fw.write("<" + s + ">");

            fw.write("\n");
            System.out.println("-> SUCCESS: Файл сохранён успешно: " + filename[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("-> ERROR: Ошибка обработки данных!");
        }
    }
}

class InputFormatException extends Exception {
    public InputFormatException(String s) {
        super(s);
    }
}
