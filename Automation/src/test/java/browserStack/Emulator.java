package browserStack;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Emulator {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		Map<String, String> emu = new HashMap<String, String>();

		emu.put("deviceName", "iPhone X");

		Map<String, Object> options = new HashMap<String, Object>();

		options.put("mobileEmulation", emu);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriver driver = new ChromeDriver(capabilities);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://ie.tumi.com/");

		try {
			driver.findElement(By.xpath("//div[@id='cookies-dialog']/a")).click();
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		try {
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='newsletter-dialog']/a"))));
			driver.findElement(By.xpath("//div[@id='newsletter-dialog']/a")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//a[@class='toggle-sidebar'][@href='#']"))));
		driver.findElement(By.xpath("//a[@class='toggle-sidebar'][@href='#']")).click();

		driver.findElement(By.xpath("//input[@id='q']")).click();

		// driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Hello",Keys.ENTER);

	}
}
