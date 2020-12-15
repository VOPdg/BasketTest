import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Basket extends PageObject {
    private Actions actions;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div[2]/div[1]/main/div/div/div[2]/div[1]/div/div[3]/div/div[3]/div[1]/div[1]/div/div[2]/div[1]/a")
    private WebElement addToCart;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[2]/div[2]/a")
    private WebElement basketItem;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[4]/div/div[3]/div/span")
    private WebElement itemPrice;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div[1]/div[2]/div/span")
    private WebElement totalPrice;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[4]/div/div[2]/div/div[1]/div/input")
    private WebElement inputQuantity;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[4]/div/div[1]/div/a")
    private WebElement deleteItem;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[4]/div/div[2]/div/div[1]/a[2]")
    private WebElement addItemQuantity;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[4]/div/div[2]/div/div[1]/a[1]")
    private WebElement reduceItemQuantity;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[2]/div/div[3]/div/div/div[2]/div/div[2]/div[2]/a[1]")
    private WebElement backItem;

    public Basket(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    public void add() {
        this.addToCart.click();
    }

    public void check() {
        this.basketItem.getText().contains("iphone");
    }

    public void checkPrice() {
        this.itemPrice.getText().equals(this.totalPrice.getText());
    }

    public void addItem(String value) {
        this.inputQuantity.sendKeys(Keys.CONTROL + "a");
        this.inputQuantity.sendKeys(value);
    }

    public void increment(){
        actions.moveToElement(this.addItemQuantity).perform();
        this.addItemQuantity.click();
    }
    public void decrement(){
        actions.moveToElement(this.reduceItemQuantity).perform();
        this.reduceItemQuantity.click();
    }
    public void delete() {
        actions.moveToElement(this.deleteItem).perform();
        this.deleteItem.click();
    }
    public void backItem(){
        this.backItem.click();
    }}

