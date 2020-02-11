package SeleniumTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// 
public class GroupWork_updateApartmets {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\asennus\\Downloads\\chromedriver_win32\\chromedriver.exe"); // in windows
		WebDriver driver = new ChromeDriver(); // Launch Chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("localhost:8080/apartments/");
		WebElement text = driver.findElement(By.xpath("/html/body/pre"));
		String dataText = text.getText();
		String paivitykset = "";
		String eiPaivitykset = "";
		String poistettu = "";
		
		String updateGoteborg = "{\"id\":null,\"address\":{\"id\":null,\"streetAddress\":\"Göteborg vägen 12G\",\"city\":\"Göteborg\",\"zipCode\":\"2220\",\"country\":\"Ruotsi\",\"coordinates\":{\"id\":null,\"x\":420,\"y\":10,\"z\":5}},\"pictures\":[],\"floorPlans\":[],\"price\":650000.0,\"area\":80.0,\"desc\":\"Kerrostalo Etelä-Ruotsissa\",\"floor\":5,\"totalFloors\":6,\"elevator\":true,\"balcony\":false}";
		String updateKielokuja = "{\"id\":null,\"address\":{\"id\":null,\"streetAddress\":\"Kielokuja 7\",\"city\":\"Espoo\",\"zipCode\":\"01810\",\"country\":\"Suomi\",\"coordinates\":{\"id\":null,\"x\":44,\"y\":68,\"z\":0}},\"pictures\":[],\"floorPlans\":[],\"price\":200000.0,\"area\":9000.0,\"desc\":\"Rivitalo luonnon vieressä\",\"floor\":1,\"totalFloors\":2,\"elevator\":false,\"balcony\":true}";
		String updateVaisalantie = "{\"id\":null,\"address\":{\"id\":null,\"streetAddress\":\"Vaisalantie 3B\",\"city\":\"Vantaa\",\"zipCode\":\"01210\",\"country\":\"Suomi\",\"coordinates\":{\"id\":null,\"x\":34,\"y\":46,\"z\":0}},\"pictures\":[],\"floorPlans\":[],\"price\":65000.0,\"area\":800.0,\"desc\":\"Omakotitalo Helsingin rajalla\",\"floor\":1,\"totalFloors\":1,\"elevator\":false,\"balcony\":true}";
		String updatePerajankuja = "{\"id\":null,\"address\":{\"id\":null,\"streetAddress\":\"Peräjänkuja\",\"city\":\"Vantaa\",\"zipCode\":\"01760\",\"country\":\"Suomi\",\"coordinates\":{\"id\":null,\"x\":1,\"y\":21,\"z\":0}},\"pictures\":[],\"floorPlans\":[],\"price\":160000.0,\"area\":170000.0,\"desc\":\"Omakotitalo maalaismiljöössä\",\"floor\":2,\"totalFloors\":2,\"elevator\":false,\"balcony\":true}";
		String updatePerajankuja2 = "{\"id\":null,\"address\":{\"id\":null,\"streetAddress\":\"Peräjänkuja2\",\"city\":\"Vantaa\",\"zipCode\":\"01760\",\"country\":\"Suomi\",\"coordinates\":{\"id\":null,\"x\":1,\"y\":21,\"z\":0}},\"pictures\":[],\"floorPlans\":[],\"price\":160000.0,\"area\":170000.0,\"desc\":\"Omakotitalo tulevaisuuden mahdollisuus\",\"floor\":2,\"totalFloors\":2,\"elevator\":false,\"balcony\":true}";
		String updateReunatie = "{\"id\":null,\"address\":{\"id\":null,\"streetAddress\":\"Reunatie 81\",\"city\":\"Vantaa\",\"zipCode\":\"01790\",\"country\":\"Suomi\",\"coordinates\":{\"id\":null,\"x\":22,\"y\":36,\"z\":0}},\"pictures\":[],\"floorPlans\":[],\"price\":250000.0,\"area\":2100.0,\"desc\":\"Omakotitalo urheilukentän vieressä\",\"floor\":1,\"totalFloors\":5,\"elevator\":false,\"balcony\":true}";
		String updateNurenkuru = "{\"id\":null,\"address\":{\"id\":null,\"streetAddress\":\"Nurenkuru\",\"city\":\"Rundu\",\"zipCode\":\"9871\",\"country\":\"Namibia\",\"coordinates\":{\"id\":null,\"x\":244,\"y\":368,\"z\":0}},\"pictures\":[],\"floorPlans\":[],\"price\":10000.0,\"area\":17000.0,\"desc\":\"Omakotitalo aurinkoisessa Etelä-Afrikassa\",\"floor\":1,\"totalFloors\":1,\"elevator\":false,\"balcony\":true}";
		String updateMakitie = "{\"id\":null,\"address\":{\"id\":null,\"streetAddress\":\"Mäkitie 6 A12\",\"city\":\"Nurmijärvi\",\"zipCode\":\"01870\",\"country\":\"Suomi\",\"coordinates\":{\"id\":null,\"x\":4,\"y\":6,\"z\":0}},\"pictures\":[],\"floorPlans\":[],\"price\":310000.0,\"area\":17000.0,\"desc\":\"Omakotitalo puutarhatontilla\",\"floor\":1,\"totalFloors\":2,\"elevator\":false,\"balcony\":true}";
		String updateMannerheimintie = "{\"id\":null,\"address\":{\"id\":null,\"streetAddress\":\"Mannerheimintie 11B\",\"city\":\"Helsinki\",\"zipCode\":\"01220\",\"country\":\"Suomi\",\"coordinates\":{\"id\":null,\"x\":20,\"y\":30,\"z\":5}},\"pictures\":[],\"floorPlans\":[],\"price\":450000.0,\"area\":80.0,\"desc\":\"Kerrostalo Helsingin ytimessä\",\"floor\":6,\"totalFloors\":7,\"elevator\":true,\"balcony\":false}";
		String updateHiomotie = "{\"id\":null,\"address\":{\"id\":null,\"streetAddress\":\"Hiomotie 8 B5\",\"city\":\"Helsinki\",\"zipCode\":\"00210\",\"country\":\"Suomi\",\"coordinates\":null},\"pictures\":[],\"floorPlans\":[],\"price\":2000000.0,\"area\":170000.0,\"desc\":\"Kerrostalo koulutukseen\",\"floor\":5,\"totalFloors\":5,\"elevator\":true,\"balcony\":false}";
		
		String[][] updateArray = new String[10][];
		updateArray[0] = new String[] {updateGoteborg,"Göteborg vägen 12G kerrostalo Etelä-Ruotsissa ja 650000€","Göteborg vägen 12G"};
		updateArray[1] = new String[] {updateKielokuja,"Kielokuja 7 rivitalo luonnon vieressä ja 9000 m^2","Kielokuja 7"};
		updateArray[2] = new String[] {updateVaisalantie,"Vaisalantie 3B omakotitalo Helsingin rajalla","Vaisalantie 3B"};
		updateArray[3] = new String[] {updatePerajankuja,"Peräjänkuja omakotitalo maalaismiljöössä","Peräjänkuja"};
		updateArray[4] = new String[] {updatePerajankuja2,"Peräjäkuja2 omakotitalo tulevaisuuden mahdollisuus","Peräjäkuja2"};
		updateArray[5] = new String[] {updateReunatie,"Reunatie 81 omakotitalo urheilukentän vieressä","Reunatie 81"};
		updateArray[6] = new String[] {updateNurenkuru,"Nurenkuru omakotitalo aurinkoisessa Etelä-Afrikassa","Nurenkuru"};
		updateArray[7] = new String[] {updateMakitie,"Mäkitie 6 A12 omakotitalo puutarhatontilla ja 2 kerrosta","Mäkitie 6 A12"};
		updateArray[8] = new String[] {updateMannerheimintie,"Mannerheimintie 11B kerrostalo Helsingin ytimessä ja kerros 6/7","Mannerheimintie 11B"};
		updateArray[9] = new String[] {updateHiomotie,"Hiomotie 8 B5 kerrostalo koulutukseen ilman parveketta","Hiomotie 8 B5"};
		
		for (int i=0; i<10; i++) {
		if (dataText.contains(updateArray[i][0]))
			paivitykset = paivitykset + updateArray[i][1] + "\n";
		else if (dataText.contains(updateArray[i][2]))
			eiPaivitykset = eiPaivitykset + updateArray[i][1] + "\n";
		else
			poistettu = poistettu + updateArray[i][2] + "\n";
		}
		
		System.out.println("");
		System.out.println("Päivitykset:\n"+ paivitykset);
		System.out.println();
		System.out.println("Ei päivityksiä:\n"+ eiPaivitykset);
		System.out.println();
		System.out.println("Poistetut kiinteistöt:\n"+ poistettu);
		
		driver.close();
	}
}
