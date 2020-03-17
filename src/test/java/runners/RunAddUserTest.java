package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "com.example.springcucumber.spring_cucumber",
//        tags = "@add",
        snippets = SnippetType.CAMELCASE
)
@SpringBootTest
public class RunAddUserTest {
    private static ChromeDriverService service;
    protected static WebDriver driver;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File("C:\\Users\\tanch\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe"))
                .usingDriverExecutable(new File("/home/slava/Downloads/chromedriver_linux64/chromedriver"))
                .usingAnyFreePort()
                .build();
        service.start();
        driver = new ChromeDriver(service);
    }
}
