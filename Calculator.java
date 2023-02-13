/**
 * Credit calculator v2
 */

import java.util.Scanner;

public class Calculator {
    private static String[] sClntData;

    public static void main(String[] args) {
        System.out.println("Введите данные:");
        try (Scanner console = new Scanner(System.in)) {
            sClntData = console.nextLine().split(" ");

            if (sClntData[3].equals("human")
                    && sClntData.length == 4) {

                Consumer client = new Consumer();
                client.fillClntData(sClntData);
                System.out.println(client.getOvrPaid());
            } else if (sClntData[3].equals("business")
                    && sClntData.length == 4) {

                Consumer client = new Consumer();
                client.fillClntData(sClntData);
                System.out.println(client.getOvrPaid());
            } else {
                System.out.println("Нет такого типа пользователя ");
                System.exit(1);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Не правильно введены данные " + e);
            System.exit(1);
        }
    }
}