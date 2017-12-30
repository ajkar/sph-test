package sph_test;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class web_test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/Ajkar/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();

		// Navigate to webpage
		driver.get("http://www.straitstimes.com");

		// Click on login
		driver.findElement(By.className("nav-login")).click();

		// Enter login credentials and login
		driver.findElement(By.name("j_username")).sendKeys("mohamedajkarali@gmail.com");
		driver.findElement(By.name("j_password")).sendKeys("20091988Aa");
		driver.findElement(By.className("btn")).click();

		Thread.sleep(3000);
		// Wait for page to load and get logged in user element
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-user > a")));
		WebElement loggedInUser = driver.findElement(By.cssSelector(".nav-user > a"));

		// Verify user logged in
		if (loggedInUser.getText().equals("mohamedajkarali@gmail.com")) {
			System.out.println("User logged in successfully");
		} else {
			System.out.println("Login failed");
		}

		// Verify main article has media 
		List<WebElement> mainArticle = driver.findElements(By.cssSelector(".main-featured-story img"));
		if (mainArticle.size() > 0) {
			System.out.println("Main article media found");
		} else {
			System.out.println("Main article media not found");
		}

		// Get homepage main article title
		String mainArticleTitle = driver.findElement(By.cssSelector(".main-featured-story .story-headline > a"))
				.getText();

		// Click on main article
		mainArticle.get(0).click();

		// Get main article title in article page
		String articleTitle = driver.findElement(By.cssSelector(".headline")).getText();

		// Verify navigation to main article 
		if (mainArticleTitle.equals(articleTitle)) {
			System.out.println("Navigated to main article successfully");
		} else {
			System.out.println("Navigation to main article failed");
		}
		
		// Verify main article media 
		List<WebElement> articleMedia = driver.findElements(By.cssSelector(".media-entity img"));
		if (articleMedia.size() > 0) {
			System.out.println("Main article media found");
		} else {
			System.out.println("Main article media not found");
		}

		driver.quit();
	}

}
