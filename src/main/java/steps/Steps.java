package steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
	private WebDriver driver = null;

	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void closeDriver() {
		driver.quit();
	}

	public void openPage(String url) {
		driver.get(url);
	}

	public void clickOnLink(String linkText) {
		WebElement link = driver.findElement(By.linkText(linkText));
		link.click();
	}

	public void closePopup() {
		List<WebElement> popupButtons = driver.findElements(By.cssSelector("button[data-cmd='ok-disc']"));
		if (!popupButtons.isEmpty()) {
			popupButtons.get(0).click();
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
