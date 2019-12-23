package test.java;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
        assertEquals(category, "Your category is Normal", "Categories are not similar");
        new Select(browser.findElement(By.name("opt1"))).selectByVisibleText("pounds");
        browser.quit();
    }

    //Testing KG input

    @Test
    public void calculateMinKg () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("10");
        browser.findElement(By.name("ht")).sendKeys("184");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String messageMin = alert.getText();
        assertEquals(messageMin, "Weight should be less than 10kgs", "Error");
        browser.quit();
    }

    @Test
    public void calculateMaxKg () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name(("wg"))).sendKeys("500");
        browser.findElement(By.name("ht")).sendKeys("184");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String messageMax = alert.getText();
        assertEquals(messageMax, "Weight should be less than 100kgs", "Error");
        browser.quit();
    }

    @Test
    public void testEmptyKg () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name(("wg"))).sendKeys("");
        browser.findElement(By.name("ht")).sendKeys("184");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String messageEmpty = alert.getText();
        assertEquals(messageEmpty, "Enter the value for weight", "Error");
        browser.quit();
    }

    @Test
    public void anySymbolKg () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name(("wg"))).sendKeys("rebi");
        browser.findElement(By.name("ht")).sendKeys("184");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String messageSymbols = alert.getText();
        assertEquals(messageSymbols, "Enter the value for weight", "Error");
        browser.quit();
    }

    //testing CMS input

    @Test
    public void CMSmin () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name(("wg"))).sendKeys("180");
        browser.findElement(By.name("ht")).sendKeys("33");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String messageMin = alert.getText();
        assertEquals(messageMin, "Height should be taller than 33cms", "Error");
        browser.quit();
    }

    @Test
    public void CMSmax () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name(("wg"))).sendKeys("180");
        browser.findElement(By.name("ht")).sendKeys("380");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String messageMax = alert.getText();
        assertEquals(messageMax, "Height should be less than 300cms", "Error");
        browser.quit();
    }

    @Test
    public void emptyCMS () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name(("wg"))).sendKeys("180");
        browser.findElement(By.name("ht")).sendKeys("");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String messageEmpty = alert.getText();
        assertEquals(messageEmpty, "Height should be taller than 33cms", "Error");
        browser.quit();
    }

    @Test
    public void anySymbolInCMS () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name(("wg"))).sendKeys("180");
        browser.findElement(By.name("ht")).sendKeys("wkmfm");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String messageAnyValue = alert.getText();
        assertEquals(messageAnyValue, "Height should be taller than 33cms", "Error");
        browser.quit();
    }

    //testing results and SI Units

    @Test
    public void getStarvation () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("60");
        browser.findElement(By.name("ht")).sendKeys("200");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Starvation", "Category is not right");
        browser.quit();
    }

    @Test
    public void getSeverelyUnderweight () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("60");
        browser.findElement(By.name("ht")).sendKeys("193.469");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Severely Underweight", "Category is not right");
        browser.quit();
    }

    @Test
    public void getUnderweight () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("60");
        browser.findElement(By.name("ht")).sendKeys("180.1");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Underweight", "Category is not right");
        browser.quit();
    }

    @Test
    public void getNormal () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("60");
        browser.findElement(By.name("ht")).sendKeys("154.92");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Normal", "Category is not right");
        browser.quit();
    }

    @Test
    public void getOverweight () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("60");
        browser.findElement(By.name("ht")).sendKeys("141.42");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Overweight", "Category is not right");
        browser.quit();
    }

    @Test
    public void getModeratelyObese () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("60");
        browser.findElement(By.name("ht")).sendKeys("130.93");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Obese", "Category is not right");
        browser.quit();
    }

    @Test
    public void getSeverelyObese () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("60");
        browser.findElement(By.name("ht")).sendKeys("122.47");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Severely Obese", "Category is not right");
        browser.quit();
    }

    @Test
    public void getVerySeverelyObese () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("60");
        browser.findElement(By.name("ht")).sendKeys("115.455");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Very Severely Obese", "Category is not right");
        browser.quit();
    }

}
