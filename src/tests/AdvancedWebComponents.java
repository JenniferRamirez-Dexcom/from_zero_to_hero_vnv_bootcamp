package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdvancedWebComponents {

    public static void main(String[] args) {

        //For Windows
        //System.setProperty("webdriver.chrome.driver","C:\\folder\\chromedriver.exe");
        selectDeselectDropDown();
    }

    private static void openBrowser(WebDriver chromeDriver, String baseUrl){
        chromeDriver.get(baseUrl);
    }

//    private static void openGlobalSQAFormExample(){
//        openBrowser("https://www.globalsqa.com/samplepagetest/");
//    }

    private static void openSeleniumEasyDropDownExample(WebDriver driver){
        openBrowser(driver, "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
    }

//    private static void openDemoQAForm(){
//        openBrowser("https://demoqa.com/automation-practice-form");
//    }
//
//    private static void openSeleniumEasyOtherDropDown(){
//        openBrowser("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
//    }
//
//    private static void openSeleniumEasyTableExample(){
//        openBrowser("https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
//    }
//
//    private static void openSeleniumEasyDatePicker(){
//        openBrowser("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
//    }
//
//    private static void openDemoQABooksListExample(){
//        openBrowser("https://demoqa.com/books");
//    }

    private static void dropDownSelectByValue(Select select, String value){
        select.selectByValue(value);
        System.out.println("Value selected: " + value);
    }

    private static void dropDownDeSelectByValue(Select select, String value){
        select.deselectByValue(value);
        System.out.println("Value de-selected: " + value);
    }

    private static void selectDeselectDropDown(){
        //For MacOS
        System.setProperty("webdriver.chrome.driver","/users/jxr20920/chromedriver");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        //1. After opening browser find element locator (xpath, id, css, name, etc.)
        WebElement daysOfWeek = chromeDriver.findElement(By.id("select-demo"));

        //2. Instantiate Select object - The Select constructor needs a WebElement
        Select myDropDown = new Select(daysOfWeek);

        //3. Manage myDropDown behavior with methods
        Boolean isMultipleOption = myDropDown.isMultiple();

        System.out.println("This select or dropdown is multiple? " + isMultipleOption);
        if (isMultipleOption) {
            myDropDown.selectByIndex(1);
        } else {
            String previousSelectedOption = myDropDown.getFirstSelectedOption().getText();
            System.out.println("Selected option is: " + previousSelectedOption);
            myDropDown.selectByIndex(2);
            System.out.println("Selected option is: " + myDropDown.getFirstSelectedOption().getText());
           myDropDown.selectByVisibleText(previousSelectedOption);
        }

        chromeDriver.quit();
    }
}

