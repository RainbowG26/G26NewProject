package libs;

        import org.apache.log4j.Logger;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.awt.*;

        import static org.hamcrest.CoreMatchers.is;


public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver,15);
    }

    /**
     * Method clears and inputs text to webElement
     *
     * @param element
     * @param text
     */
    public void enterText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted.");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    /**
     * Method clicks to webElement
     *
     * @param element
     */
    public void clickOnElement(WebElement element) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean getTitle(WebElement url) {
        try {
            return getTitle(url);
        } catch (Exception e) {
            return false;
        }
    }

    public void checkTextInElement(String xpath, String text) {
        try{
            webDriverWait15.until(ExpectedConditions.textToBePresentInElement(By.xpath(xpath),text));
            String textFromElement = webDriver.findElement(By.xpath(xpath)).getText();
            Assert.assertThat("Text in element not matched",textFromElement, is(text));
        } catch (Exception e){
            logger.error("Can not work with text");
            Assert.fail("Can not work with text");
        }
    }

    public void selectTextInDDByText(WebElement dropDown, String text) {
        try{
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByVisibleText(text);
            logger.info(text + " was selected in DropDown");
        } catch (Exception e){
            logger.error("Can not work with DropDown");
            Assert.fail("Can not work with DropDown");
        }
    }

    public void selectValueInDDByValue(WebElement dropDown, String value) {
        try{
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByValue(value);
            logger.info(value + " was selected in DropDown");
        } catch (Exception e){
            logger.error("Can not work with value in DropDown");
            Assert.fail("Can not work with value in DropDown");
        }
    }

    public boolean getCheckboxState (WebElement checkbox) {
        if(checkbox.isSelected()){
            logger.info("Element is selected");
            return true;
        }
        else {
            logger.info("Element isn't selected");
            return false;
        }

    }

    public void setCheckboxState(WebElement checkbox, String expectedState){
        // чекнутый
        boolean actualState = getCheckboxState(checkbox);

        // чекнутый чекнуть
        if (actualState == true && expectedState == "checked"){
            logger.info("Checkbox is checked");
        }
        // нечекнутый чекнуть
        else if (actualState == true && expectedState == "unchecked"){
            checkbox.click();
            logger.info("Checkbox is checked");
        }
        // нечекнутый
        else if (actualState == false && expectedState == "checked"){
            checkbox.click();
            logger.info("Checkbox is checked");
        }
        else if (actualState == false && expectedState == "unchecked"){
            logger.info("Checkbox is unchecked");
        }
    }


}

