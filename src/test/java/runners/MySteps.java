package runners;

//import com.example.springcucumber.spring_cucumber.model.Role;
//import com.example.springcucumber.spring_cucumber.model.User;
//import com.example.springcucumber.spring_cucumber.service.UserService;
import cucumber.api.PendingException;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.Тогда;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.xmlunit.builder.Input;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.stream.Stream;

//@ContextConfiguration(classes = SpringCucumberApplication.class)
//@PropertySource("classpath:application.properties")
//@RunWith(SpringJUnit4ClassRunner.class)
public class MySteps {
    private WebDriver driver = RunAddUserTest.driver;

    @Допустим("^мы зашли на сайт \"([^\"]*)\"$")
    public void мы_зашли_на_сайт(String arg1) throws Throwable {
        driver.get("http://" + arg1);
        WebElement form = new WebDriverWait(
                driver,
                Duration.ofSeconds(5).getSeconds())
                .until(ExpectedConditions
                        .elementToBeClickable(By
                                .linkText("Ж/д билеты")));
    }

    @Допустим("^зашли в меню заказ Ж/Д билетов$")
    public void зашли_в_меню_заказ_Ж_Д_билетов() throws Throwable {
        driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
        driver.findElement(By.linkText("Ж/д билеты")).click();
    }

    @Если("^имееются свободные места на сегодняшнее число из \"([^\"]*)\" в \"([^\"]*)\"$")
    public void имееются_свободные_места_на_сегодняшнее_число(String arg1, String arg2) throws Throwable {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dataOfTest = dateFormat.format(date);
        WebElement webElementStationFrom = driver.findElement(By.name("schedule_station_from"));
        WebElement webElementStationTo = driver.findElement(By.name("schedule_station_to"));
        WebElement webElementDate = driver.findElement(By.ByXPath.xpath("//input[@class='input_field j-permanent_open j-input j-date_to']"));
        WebDriverWait wait = new WebDriverWait(driver, 3);
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(9))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(TimeoutException.class);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(webElementStationFrom));
        webElementStationFrom.click();

        for (int i = 0; i < arg1.length(); i++) {
            String subChar = arg1.substring(i, i + 1);
            String subWord = arg1.substring(0, i + 1);
            webElementStationFrom.sendKeys(subChar);
            wait.until(ExpectedConditions.attributeContains(webElementStationFrom, "value", subWord));
        }

        wait.until(ExpectedConditions.elementToBeClickable(webElementStationTo));
        webElementStationTo.click();

        for (int i = 0; i < arg2.length(); i++) {
            String sub = arg2.substring(i, i + 1);
            String subWord = arg2.substring(0, i + 1);
            webElementStationTo.sendKeys(sub);
            wait.until(ExpectedConditions.attributeContains(webElementStationTo, "value", subWord));
        }

        fluentWait.until(webDriver -> {
            webElementDate.click();
            webElementDate.clear();
            wait.withTimeout(Duration.ofSeconds(1));

            webElementDate.sendKeys(dataOfTest);

            String result = webElementDate.getAttribute("value");

            if (result.contains(",")) {
                return result.substring(0, result.indexOf(",")).equals(dataOfTest);
            }

            return result.equals(dataOfTest);
        });

        driver
                .findElement(By.ByXPath.xpath("//button[@class='b-button__arrow__button j-button j-button-submit _title j-submit_button _blue']/span[@class='inner_wrapper']/span[@class='spinner']"))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(By.className("t-ttl")));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("train_number_link")));
    }

    @Тогда("^сформировать заказ на билет из \"([^\"]*)\" в \"([^\"]*)\"$")
    public void сформировать_заказ_на_билет_из_в(String arg1, String arg2) throws Throwable {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        driver.findElement(By.linkText("Выбрать места")).click();
        wait.until(WebDriver -> {
//            WebElement elem = driver.findElement(By.linkText("Выберите вагон и&nbsp;места"));
//            WebElement elem = driver.findElement(By.linkText("1. Укажите количество билетов"));
            WebElement elem = driver.findElement(By.xpath("/html/body/div[@id='wrapper']/div[@id='app']/div[@class='seats__root__1l2PG']/div[@class='l-passenger_count seats__mPassengersCount__1TRpu']/div[@class='b-train__seats__passenger_count']/h1[@class='t-ttl passenger_count_title']"));
//            return elem.getText().equals("Выберите вагон и&nbsp;места");
//            return elem.getText().equals("1. Укажите количество билетов");
            return elem.isEnabled();
        });
    }

//    @Если("^сделать заказ на вчерашнюю дату$")
//    public void сделать_заказ_на_вчерашнюю_дату() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Тогда("^должно появиться сообщение об ошибке$")
//    public void должно_появиться_сообщение_об_ошибке() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

}
