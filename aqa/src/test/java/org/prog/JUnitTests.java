package org.prog;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitTests {

//    //    @Test
//    public void myJUnitTest() {
//        System.out.println("my first test");
//        String a = "a";
//        String b = "a";
//        Assertions.assertEquals(a, b, "Strings a and b are not the same!");
//    }
//
//    //    @Test
//    public void myJUnitTest2() {
//        String a = null;
//        Assertions.assertNotNull(a, "this string is empty!");
//
//        System.out.println("my first test 2");
//    }
//
//    //    @Test
//    public void myJUnitTest3() {
//        String a = null;
//        System.out.println(a.length());
//    }

    @Test
    public static void Rozetkaclick (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get ("https://rozetka.com.ua/mobile-phones/c80003/producer=apple;series=iphone-14,iphone-14-plus,iphone-14-pro,iphone-14-pro-max/#search_text=iphone+14");
        WebElement iPhone14 =
                driver.findElement(By.xpath("//span[@class='goods-tile__title']"));
        iPhone14.click();
        driver.quit();

    }
}
