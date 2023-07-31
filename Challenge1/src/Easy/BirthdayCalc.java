package Easy;

import java.time.LocalDate;
import java.util.Scanner;

public class BirthdayCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValidDate = false; // We will use it later to check the date.

        String[] birthDateParts = new String[0];
        while (!isValidDate) {
            System.out.println("Please enter your birthday (yyyy-mm-dd like 1990-01-17): ");
            String birthday = scanner.nextLine();
            System.out.println("*****************************************************");


            if (!birthday.contains("-")) {
                System.out.println("You forgot to use '-' in the date. Please try again.");
                System.out.println("*****************************************************");
                continue;
            }

            birthDateParts = birthday.split("-");
            int year = Integer.parseInt(birthDateParts[0]);
            int month = Integer.parseInt(birthDateParts[1]);
            int day = Integer.parseInt(birthDateParts[2]);


            LocalDate currentDate = LocalDate.now();
            int currentYear = currentDate.getYear();
            int currentMonth = currentDate.getMonthValue();
            int currentDay = currentDate.getDayOfMonth();


            if (year > 1900 && year <= currentYear && (year != currentYear || month <= currentMonth) && (year != currentYear || month != currentMonth || day <= currentDay) && month > 0 && month < 13 && day > 0 && day < 32) {
                isValidDate = true; // if the date is valid, isValidDate
            } else {
                System.out.println("Invalid date. Please try again.");
                System.out.println("*****************************************************");

            }
        }

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int age = currentYear - Integer.parseInt(birthDateParts[0]);

        System.out.println("*****************************************************");
        System.out.println("Your age: " + age);
    }
}
