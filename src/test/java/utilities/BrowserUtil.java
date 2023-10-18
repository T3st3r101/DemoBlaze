package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserUtil {
 
	private static final Long IMPLICIT_WAIT = 30l;
	private static final Long PAGE_LOAD_WAIT = 60l;

	public static WebDriver getDriver() throws Exception {

		// String browser="Chrome";
		String browser = System.getProperty("browser");
		System.out.println("******Browser passed from mvn command-line is:=" + browser);
		RemoteWebDriver driver = null;
		if (browser == null) {
			System.out.println("Browser command-line argument is null. Defaulting driver to Chrome.");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("browerstack")) {
			// Write something specific to browserstack to return the driver;
		} else {
			throw new Exception("Invalid browser value:=" + browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
		return driver;
	}

}
