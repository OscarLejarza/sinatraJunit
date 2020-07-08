package com.sinatra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LikeSongsParent extends SongsBySinatraParent {

    WebDriver driver;
    WebDriverWait wait;
    private Integer numeroLikes;

    public void navegarSitio(String url) {
        driver = new ChromeDriver();

    }


    public void seleccionarCancion(int numeroCancion) {

        List<WebElement> listaCanciones = driver.findElements(By.cssSelector)
    }
}
