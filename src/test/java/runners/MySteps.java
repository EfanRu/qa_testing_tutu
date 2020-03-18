package runners;

//import com.example.springcucumber.spring_cucumber.model.Role;
//import com.example.springcucumber.spring_cucumber.model.User;
//import com.example.springcucumber.spring_cucumber.service.UserService;
import cucumber.api.PendingException;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//@ContextConfiguration(classes = SpringCucumberApplication.class)
//@PropertySource("classpath:application.properties")
//@RunWith(SpringJUnit4ClassRunner.class)
public class MySteps {
    private WebDriver driver = RunAddUserTest.driver;

    @Допустим("^мы зашли на сайт \"([^\"]*)\"$")
    public void мы_зашли_на_сайт(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            driver.get("http://" + arg1);
            WebElement form = new WebDriverWait(
                    driver,
                    Duration.ofSeconds(5).getSeconds())
                    .until(ExpectedConditions
                            .elementToBeClickable(By
                                    .linkText("Ж/д билеты")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PendingException();
        }
    }

    @Допустим("^зашли в меню заказ Ж/Д билетов$")
    public void зашли_в_меню_заказ_Ж_Д_билетов() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            driver.findElement(By.linkText("Ж/д билеты")).click();
            driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
//            WebElement form = new WebDriverWait(
//                    driver,
//                    Duration.ofSeconds(10).getSeconds())
//                    .until(ExpectedConditions
//                            .elementToBeClickable(By
//                                    .className("input_field j-station_input  j-station_input_from")));
        } catch (Exception e) {
            throw new PendingException();
        }
    }

    @Если("^имееются свободные места на сегодняшнее число из \"([^\"]*)\" в \"([^\"]*)\"$")
    public void имееются_свободные_места_на_сегодняшнее_число(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");

            driver
                    .findElement(By.name("schedule_station_from"))
                    .sendKeys(arg1);
            driver
                    .findElement(By.name("schedule_station_to"))
                    .sendKeys(arg2);
            driver
                    .findElement(By.className("input_field j-permanent_open j-input j-date_to"))
                    .sendKeys(dateFormat.format(date));
        } catch (Exception e) {
            e.printStackTrace();
            throw new PendingException();
        }
    }

    @Тогда("^сформировать заказ на билет из \"([^\"]*)\" в \"([^\"]*)\"$")
    public void сформировать_заказ_на_билет_из_в(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Если("^сделать заказ на вчерашнюю дату$")
    public void сделать_заказ_на_вчерашнюю_дату() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^должно появиться сообщение об ошибке$")
    public void должно_появиться_сообщение_об_ошибке() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
