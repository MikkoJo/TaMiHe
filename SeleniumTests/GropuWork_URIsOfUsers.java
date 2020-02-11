package SeleniumTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// It is studied how many apartments exist in  the different URIs.
public class GropuWork_URIsOfUsers {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver(); // Launch Chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		GFG amount = new GFG();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("\nIt is studied how many users exist in  the different URIs:");
		driver.get("localhost:8080/users/");
		WebElement text = driver.findElement(By.xpath("/html/body/pre"));
		String dataText = text.getText();
		System.out.println("localhost:8080/users/ has " + amount.countFreq("password", dataText) + " users.\n");

		ArrayList<String> uriList = new ArrayList<String>(Arrays.asList("", "seeker", "service", "admin"));

		for (String uri : uriList) {
			driver.get("localhost:8080/users/" + uri);
			text = driver.findElement(By.xpath("/html/body/pre"));
			dataText = text.getText();
			System.out.println(
					"localhost:8080/users/" + uri + " has " + amount.countFreq("password", dataText) + " users.");
		}

		driver.close();
	}

}
