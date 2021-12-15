package test.miropolis.homework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {

    private WebDriver driver;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
    }

    //Открываем страницу по url
    public void open() {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
    }

    //Вводим логин
    public void inputLogin(String name) {
        driver.findElement(By.name("user")).sendKeys(name);
    }
    //Вводим пароль
    public void inputPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    //Нажимаем вход
    public void submit(){
        driver.findElement(By.id("button_submit_login_form")).submit();
    }

    //Проверяем авторизацию
    public boolean checkPage() {
        if (driver.getTitle().equals("Mirapolis LMS"))
            return true;
        else
            return false;


    }
}
