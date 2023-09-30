import java.util.Scanner;

public class EmptyStringExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите текст: ");
            String userInput = scanner.nextLine();

            if (userInput.isEmpty()) {
                throw new RuntimeException("Пустые строки вводить нельзя!");
            } else {
                System.out.println("Вы ввели: " + userInput);
            }
        }
    }
}