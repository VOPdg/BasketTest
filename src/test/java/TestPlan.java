import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @BeforeTest
    public static void addToBasket() {
        driver.get("https://catalog.onliner.by/mobile/apple/iphone1164b/prices");
        Basket basket = new Basket(driver);
        basket.add();
        driver.get("https://cart.onliner.by");
    }

    @Test(testName = "Check the Basket", priority = 1)
    public static void checkBasket() {
        Basket basket = new Basket(driver);
        basket.check();
    }

    @Test(testName = "Check the Price", priority = 2)
    public static void checkPrice() {
        Basket basket = new Basket(driver);
        basket.checkPrice();
    }

    @Test(testName = "Add the Quantity", priority = 3)
    public static void addQuantity() {
        Basket basket = new Basket(driver);
        basket.addItem("2");
        basket.checkPrice();
    }

    @Test(testName = "Delete the Item", priority = 6)
    public static void deleteItem() {
        Basket basket = new Basket(driver);
        basket.delete();
    }

    @Test(testName = "Increment the Item", priority = 4)
    public static void incrementItem() {
        Basket basket = new Basket(driver);
        basket.increment();
    }
    @Test(testName = "Decrement the Item", priority = 5)
    public static void decrementItem() {
        Basket basket = new Basket(driver);
        basket.decrement();
    }
    @Test(testName = "Back the Item", priority = 7)
    public static void backItem() {
        Basket basket = new Basket(driver);
        basket.backItem();
    }
    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        //driver.close();
    }
}