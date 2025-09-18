import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    @Test
    public void checkLogin() throws InterruptedException {
//1 Открыть браузер
//2 Зайти на сайт
        WebDriver browser = new ChromeDriver();
        browser.get("https://sharelane.com/cgi-bin/register.py");
        //Другие варианты найти элемент
        //browser.findElement(By.name("zip_code"));
        //browser.findElement(By.cssSelector("*[name = 'zip_code']"));
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("12345");
        Thread.sleep(2000);
        //Другие ключи, которые можно отправить
//        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys(Keys.CONTROL + "A");
//        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys(Keys.BACK_SPACE);

        browser.findElement(By.cssSelector("*[value='Continue']")).click();
        //Позитивная проверка
        browser.findElement(By.xpath("//*[text()='First Name* ']")).isDisplayed();
        assertTrue( browser.findElement(By.xpath("//*[text()='First Name* ']")).isDisplayed());
        //Негативная проверка
        //String errorMsg = browser.findElement(By.cssSelector(".error_message")).getText();
        //assertEquals(errorMsg, "Oops, error on page. ZIP code should have 5 digits");

        browser.quit();
    }
}

//Локаторы
//*[text()='First Name* '] - byXpath -- //*[@name = 'first_name'] - byXpath, "first_name" - byName
//*[text()='Last Name '] - byXpath -- //*[@name = 'last_name'] - byXpath, "last_name" - byName
//*[text()='Email* '] - byXpath -- //*[@name = 'email'] - byXpath, "email" - byName
//*[text()='Password* '] - byXpath -- //*[@name = 'password1'] - byXpath, "password1" - byName
//*[text()='Confirm Password* '] - byXpath -- //*[@name = 'password2'] - byXpath, "password2" - byName, //*[@type = 'password'] - byXpath
//*[@value = 'Register'] - byXpath, [value = 'Register'] - byCSS
//*[@href="./shopping_cart.py"] - byXpath, [href="./shopping_cart.py"] - byCSS
