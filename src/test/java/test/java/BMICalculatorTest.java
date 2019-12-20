package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class BMICalculatorTest {

    @Test
    public void calculateKgCms () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        /* открыть браузер, переход по ссылке на сатйт https://healthunify.com/bmicalculator/
        * найти элемент для ввода веса, ввести вес, найти ввод роста, ввести рост, найти calculate
        * и нажать её, проверить категорию массы тела */

        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("100");
        browser.findElement(By.name("ht")).sendKeys("184");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Normal", "Categories are not siilar");

        new Select(browser.findElement(By.name("opt1"))).selectByVisibleText("pounds");
        browser.quit();
    }
}
