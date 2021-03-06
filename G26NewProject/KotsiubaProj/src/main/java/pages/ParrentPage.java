package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.core.Is.is;

public class ParrentPage {
    WebDriver webDriver;
    Logger logger;
    // это мы для всех обьявляем обьекты
    ActionsWithOurElements actionsWithOurElements;

    //это конструктор имя как в классе и нет возвращаемого типа
    public ParrentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        // теперь в конструкт мы создаем обьект,
        // блягодоря этом каждая пейджа которая унаследуеться от паррент пейджа мы сне йссможем работать
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        // this - это этот класс в котором нужно проинициализировать
        // PageFactore - инициализирует те обькеты того класса который к ней обращаеться
        //
        PageFactory.initElements(webDriver, this);
    }


    /**
     * метод + параметр который передаеться на все, поетому String
     * Method open url
     *
     * @param url
     */
    public void open(String url) {
        try {
            // log всегда пишем после действия
            webDriver.get(url);
            logger.info("Page has been opened" + url);
            // Это если урл не откроеться
        } catch (Exception e) {
            logger.error("Page can't be open" + url);
            // Assert.fail - Это коллектор метрики и выводит сообщение
            Assert.fail("Page can't be open" + url);
        }

    }
    // метод который чекает ТАЙТЛ
    public void checkTitle(String expectedTitle){
        try {
            // is(expectedTitle) - выбираем хомкрест ( это библиотека )
            // is(expectedTitle) - это метод который проверят что актуальный результат равен ожидаемому результату
            Assert.assertThat("Title no matched", webDriver.getTitle(),is(expectedTitle));
        } catch (Exception e) {
            // пишет сообшение в лог и консоль
            logger.error("Cant work with Page");
            // перкращает писать сообщение
            Assert.fail("Cant work with Page");
        }
    }

    // метод который чекает H1
    public void checkTitleH1PresentOnPageWithText(String text) {
        // в нем еще метод который выбирает текст и сравнивает
        actionsWithOurElements.checkTextInElement(".//h1", text);

    }
}
