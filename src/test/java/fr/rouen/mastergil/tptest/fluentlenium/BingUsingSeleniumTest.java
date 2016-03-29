package fr.rouen.mastergil.tptest.fluentlenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class BingUsingSeleniumTest {

    @Test
    public void title_of_bing_should_contain_search_query_name() {
        //GIVEN
        WebDriver webDriver = new FirefoxDriver();
        //WHEN
        webDriver.get("http://www.bing.com");
        webDriver.findElement(By.id("sb_form_q"))
                .sendKeys("Selenium");
        webDriver.findElement(By.id("sb_form_go"))
                .click();
        //THEN
        assertThat(webDriver.getTitle()).contains("Selenium");
        webDriver.close();
    }
}