package runners;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dataOfTest = dateFormat.format(date);
        System.out.println("The word is: " + dataOfTest);
        String arg2 = "Санкт-Петербург";
        System.out.println("The word is: " + arg2);


        for (int i = 0; i < dataOfTest.length(); i++) {
            String sub = dataOfTest.substring(i, i + 1);
            String subWord = dataOfTest.substring(0, i + 1);
            System.out.println("Subword od date is: " + subWord);
        }

        for (int i = 0; i < arg2.length() - 1; i++) {
            String sub = arg2.substring(i, i + 1);
            String subWord = arg2.substring(0, i + 1);
            System.out.println("Subword od date is: " + subWord);
        }
    }
}
