package test.miropolis.homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.miropolis.homework.page.PageLogin;

public class TestLoginAuthorization {

    @Test
    public void tesAuthorizationPositive() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.open();
        pageLogin.inputLogin("fominaelena");
        pageLogin.inputPassword("1P73BP4Z");
        pageLogin.submit();

        //Проверяем страницу
        Assert.assertEquals(true, pageLogin.checkPage());

        driver.close();
    }

    //Негативный тест. Тест успешен, если не произошла авторизация. Не верный пароль
    @Test
    public void tesAuthorizationNegativeLogin() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.open();
        pageLogin.inputLogin("qweqwe");
        pageLogin.inputPassword("1P73BP4Z");
        pageLogin.submit();


        // Соглашаемся с алертом chrom
        driver.switchTo().alert().accept();

        //Проверяем страницу
        Assert.assertEquals(false, pageLogin.checkPage());

        driver.close();
    }

    //Негативный тест. Тест успешен, если не произошла авторизация. Не верный пароль
    @Test
    public void tesAuthorizationNegativePassword() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.open();
        pageLogin.inputLogin("fominaelena");
        pageLogin.inputPassword("123123");
        pageLogin.submit();

        // Соглашаемся с алертом chrom
        driver.switchTo().alert().accept();

        //Проверяем страницу
        Assert.assertEquals(false, pageLogin.checkPage());

        driver.close();
    }
}
