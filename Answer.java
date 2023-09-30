import java.util.Scanner;

class Answer {
    public float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите дробное число: ");
                String input = scanner.nextLine();
                number = Float.parseFloat(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Повторите попытку.");
            }
        }

        return number;
    }
}


