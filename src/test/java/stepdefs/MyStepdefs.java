package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideWait;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Затем;
import cucumber.api.java.ru.Также;
import org.openqa.selenium.By;
import static page.AbstractPage.getPageByTitle;
import static page.AbstractPage.getUrlByTitle;
import static  test.strings.userMessage;
import static test.strings.userLogin;
import static test.strings.userPassword;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {

    @И("Начинаем тест")
    public void начинаемТест() {
        System.out.println("Тест начат");
    }

    @И("Открываем страницу {string}")
    public void открываемСайт(String site) throws ClassNotFoundException, InterruptedException  {
        open(getUrlByTitle(site));
    }

    @И("На странице {string} находим кнопку {string}")
    public void находимКнопкуВойти(String str, String nameEL) throws ClassNotFoundException,InterruptedException {
        System.out.println("Находим кнопку Войти");
        getPageByTitle(str).getElementByName(nameEL).click();
    }

    @Затем("на странице {string} ввести логин {string}")
    public void вводимЛогин(String str, String login) throws ClassNotFoundException, InterruptedException {
        System.out.println("Проходим авторизацию");
        getPageByTitle(str).getElementByName(login).val(userLogin);

    }

    @Также("на странице {string} ввести пароль {string}")
    public void вводимПароль(String str, String pass) throws ClassNotFoundException, InterruptedException {
        getPageByTitle(str).getElementByName(pass).val(userPassword).pressEnter();
    }


    @И("на странице {string} проверить наличие иконки {string}")
    public void проверяемАвторизацию(String str, String icon) throws ClassNotFoundException, InterruptedException {
        System.out.println("Проверяем авторизацию");
        getPageByTitle(str).getElementByName(icon).should(Condition.image);
    }

    @Затем("на странице {string} открыть тему {string}")
    public void выбираемСлучайнуюТему(String str, String page) throws ClassNotFoundException, InterruptedException {
        Selenide.sleep(9000);
        getPageByTitle(str).getElementByName(page).should(Condition.visible).click();
    }


    @И("на странице {string} нажать кнопку ответить {string}")
    public void находимИЖмемКнопкуОтветить(String str, String answer) throws ClassNotFoundException, InterruptedException {
        Selenide.sleep(5000);
        getPageByTitle(str).getElementByName(answer).should(Condition.visible).click();
    }

    @И("на странице {string} написать {string} в поле ввода")
    public void оставляемКомментарий(String str, String text) throws ClassNotFoundException, InterruptedException {
        getPageByTitle(str).getElementByName(text).val(userMessage).submit();
    }

    @И("на странице {string} проверить наличие ответа {string}")
    public void проверяемНаличиеКомментария(String str, String checkAnswer) throws ClassNotFoundException, InterruptedException{
        getPageByTitle(str).getElementByName(checkAnswer).should(Condition.visible);
    }

    @Затем("на странице {string} перейти на страницу темы {string}")
    public void переходимВоВкладкуТемы(String str, String bar) throws ClassNotFoundException, InterruptedException {
        Selenide.sleep(5000);
        getPageByTitle(str).getElementByName(bar).should(Condition.visible).click();
    }

    @Также("повторить шаги с коментарием")
    public void повторяемШагиСКоментарием() {

    }


}
