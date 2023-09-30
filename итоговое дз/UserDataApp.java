import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataApp {
    public static void main(String[] args) {

        System.out.println("Введите данные в формате: ФИО Дата_рождения Номер_телефона Пол:");
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        scanner.close();

        // Разделяем введенные значения по пробелу
        String[] userData = inputData.split(" ");

        // Проверяем количество данных
        if (userData.length != 6) {
            System.err.println("Ошибка: неверное количество данных. Введите все данные в требуемом формате.");
            return;
        }

        // Извлекаем значения параметров
        String lastName = userData[0];
        String firstName = userData[1];
        String middleName = userData[2];
        String birthDate = userData[3];
        String phoneNumberString = userData[4];
        String genderString = userData[5];


        // Парсим номер телефона
        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: номер телефона должен быть целым числом. Введите корректные данные.");
            return;
        }

        // Проверяем формат даты рождения
        if (!birthDate.matches("\\d{2}.\\d{2}.\\d{4}")) {
            System.err.println("Ошибка: неверный формат даты рождения. Введите дату в формате dd.mm.yyyy.");
            return;
        }

        // Проверяем формат пола
        char gender = genderString.charAt(0);
        if (genderString.isEmpty() || (!genderString.equalsIgnoreCase("f") && !genderString.equalsIgnoreCase("m"))) {
            System.err.println("Ошибка: неверный формат пола. Введите пол как 'F', 'f', 'M' или 'm'.");
            return;
        }

        // Создаем строку для записи в файл
        String fileData = lastName + " " + firstName + " " + middleName + " " + birthDate + " " +
                phoneNumber + " " + gender;

        // Записываем данные в файл
        try (FileWriter writer = new FileWriter(lastName + ".txt", true)) {
            writer.write(fileData);
            writer.write(System.lineSeparator()); // Переход на новую строку
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Все выполнено успешно
        System.out.println("Данные записаны в файл " + lastName + ".txt");
    }
}