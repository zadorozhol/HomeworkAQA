package org.prog;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.web.pageobjects.GooglePage;
import org.prog.web.pageobjects.RozetkaPage;
import org.prog.web.pageobjects.UkrNetPage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RozetkaOlesiaTest extends BaseTest {
    private final static String EXPECTED_iPhone = "iPhone";
    private final static String EXPECTED_Lenovo = "Lenovo";
    private final static String EXPECTED_Samsung = "Samsung";
    private static RozetkaPage rozetkaPage;

    @BeforeAll
    public static void setUpPageObject() {
        rozetkaPage = new RozetkaPage(driver);
    }

    @BeforeEach
    public void preTest() {
        loadRozetkaPage();
    }

    @AfterEach
    public void postTest() {
        System.out.println("post any test");
    }

    @ParameterizedTest
    @MethodSource("rozetkaSearchProvider")
    public void rozetkaSearch(String searchValue, String searchResultValue, String headerValue) {
        rozetkaPage.setSearchValue(searchValue);
        rozetkaPage.performSearch(false);
        Assertions.assertTrue(rozetkaPage.getSearchResults().contains(searchResultValue),
                "search results did not contain expected text");
        if (headerValue != null) {
            Assertions.assertEquals(rozetkaPage.getHeaderText(), headerValue);
        }
    }

    private static Stream<Arguments> rozetkaSearchProvider() {
        return Stream.of(
                Arguments.of("iPhone", EXPECTED_iPhone, "iPhone"),
                Arguments.of("Lenovo", EXPECTED_Lenovo, "Lenovo"),
                Arguments.of("Samsung", EXPECTED_Samsung, "Samsung")
        );
    }
//    @Test
//    public void rozetkaSearchiPhone14Test() {
//        rozetkaPage.setSearchValue("iPhone");
//        rozetkaPage.performSearch(false);
//        List<String> searchResults = rozetkaPage.getSearchResults();
//        Assertions.assertTrue(searchResults.contains(EXPECTED_iPhone));
//    }
//    @Test
//    public void rozetkaSearchLenovoTest() {
//        rozetkaPage.setSearchValue("Lenovo");
//        rozetkaPage.performSearch(false);
//        List<String> searchResults = rozetkaPage.getSearchResults();
//        Assertions.assertTrue(searchResults.contains(EXPECTED_Lenovo));
//    }
//    @Test
//    public void rozetkaSearchSamsungTest() {
//        rozetkaPage.setSearchValue("Samsung");
//        rozetkaPage.performSearch(false);
//        List<String> searchResults = rozetkaPage.getSearchResults();
//        Assertions.assertTrue(searchResults.contains(EXPECTED_Samsung));
//
//    }


//        Assertions.assertTrue(rozetkaPage.getSearchResults().contains(EXPECTED_TEXT),
//                "search results did not contain expected text");

    public void loadRozetkaPage () {       driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
    }
 }