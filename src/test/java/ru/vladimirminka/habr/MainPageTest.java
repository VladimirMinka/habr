package ru.vladimirminka.habr;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class MainPageTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");

    }

    @Test
    public void searchBtn() {
        // тест 1
        WebElement searchBox = driver.findElement(By.cssSelector("a.tm-header__become-author-btn"));
        searchBox.click();
        assertTrue(searchBox.isDisplayed(), "кнопки нет");
        // тест 2
        List<WebElement> btnIsEmpty = driver.findElements(By.xpath("//*[contains(text(),'Образовательные программы')]"));

        assertFalse(btnIsEmpty.isEmpty(), "Образовательные программы не найдены");
        /*
        Описание Теста 1:
        Открытие начальной страницы- "https://habr.com/ru/")
        Ищем кнопку "Как стать автором", кнопка имеет аттрибут - .tm-header__become-author-btn
        При  успешном поиске кликаем на кнопку и выводим  сообщение тест пройден

        Описание Теста 2:
        Необходимо проверить наличие элемента страницы с текстом "Образовательные программы" (с учётом пробелов).
        В случае если элемент не найден выводим сообщение.
         */

    }
}