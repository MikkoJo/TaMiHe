package SeleniumTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// It is studied how many apartments exist in  the different URIs.
public class GropuWork_URIs {

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

		System.out.println("\nIt is studied how many apartments exist in  the different URIs:");
		driver.get("localhost:8080/apartments/");
		WebElement text = driver.findElement(By.xpath("/html/body/pre"));
		String dataText = text.getText();
		System.out.println(
				"localhost:8080/apartments/ has " + amount.countFreq("streetAddress", dataText) + " apartments.\n");

		ArrayList<String> uriList = new ArrayList<String>(Arrays.asList("country/Namibia", "country/Rasnska",
				"country/Ruotsi", "country/Suomi", "Göteborg", "Helsinki", "Espoo", "Oulu", "Rundu", "Vantaa"));

		for (String uri : uriList) {
			driver.get("localhost:8080/apartments/" + uri);
			text = driver.findElement(By.xpath("/html/body/pre"));
			dataText = text.getText();
			System.out.println("localhost:8080/apartments/" + uri + " has "
					+ amount.countFreq("streetAddress", dataText) + " apartments.");
		}

		driver.close();
	}

}
