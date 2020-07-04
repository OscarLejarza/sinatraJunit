package com.sinatra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.ws.WebEndpoint;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SongsBySinatraParent {
    public static WebDriver driver;
    static WebDriverWait wait;

    public void navegarSitio(String url) {

        driver = new ChromeDriver(); //carga el driver de Chrome
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //hace un delay de 20 segs
        wait = new WebDriverWait(driver, 10);
        driver.navigate().to(url); //abre la URL solicitada
    }

    public void validarHomePage() {

        WebElement welcomeText = wait.until(ExpectedConditions.visibi        WebElement imgSinatra = driver.findElement(By.cssSelector("[src='/images/sinatra.jpg']"));
        WebElement linkLogin = driver.findElement(By.cssSelector("[href='/login']"));

        if (imgSinatra.isDisplayed() && linkLogin.isDisplayed()) {
            System.out.println("Imagen de Sinatra y Link login desplegados correctamente");
        } else {
            System.out.println("No se encontro la imagen");
            System.exit(-1);
        }
    }

    public void realizarLoginCorrecto(String usuario, String password) {

        WebElement linkLogin = driver.findElement(By.cssSelector("[href='/login']"));
        if (linkLogin.isDisplayed() && linkLogin.isEnabled()) {
            linkLogin.click();
        } else {
            System.out.println("El link de login no existe");
            System.exit(-1);
        }

        WebElement usernameTxt = driver.findElement(By.id("username"));
        usernameTxt.sendKeys(usuario);
        WebElement passwordTxT = driver.findElement(By.id("password"));
        passwordTxT.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.cssSelector("[value^='Log In']"));
        loginBtn.click();
        System.out.println("El usuario hizo login correctamente");
    }



    public void validarMensajeBienvenida(String mensajeBienvenida) {


        WebElement homeBtn = driver.findElement(By.cssSelector(".current"));

        WebElement msgBienvenida = driver.findElement(By.cssSelector(".flash"));
        if (msgBienvenida.isDisplayed()) {
            System.out.println("El mensaje de bienvenida si aparece");
        } else {
            System.out.println("El mensaje de bienvenida no aparece");
            System.exit(-1);
        }

        WebElement linkLogout = driver.findElement(By.cssSelector("[href='/logout']"));
        if (linkLogout.isDisplayed()) {
            System.out.println("Link logout desplegado correctamente");
        } else {
            System.out.println("El link de logout no aparece desplegado");
            System.exit(-1);
        }

    }

    public void validarSongsPage() {
        WebElement songsTitle = driver.findElement(By.cssSelector("section h1"));
        String currentUrl = driver.getCurrentUrl();
        WebElement songsLink = driver.findElement(By.cssSelector("[href='/songs']"));
        String currentClass = songsLink.getAttribute("class");
        List<WebElement> listaCanciones = driver.findElements(By.cssSelector("#songs li"));

        if(songsTitle.isDisplayed()  &&
                currentUrl.endsWith("songs") &&
                currentClass.equals("current") &&
                listaCanciones.size() > 0) {
            System.out.println("Si estoy en la pagina de songs");
        }
        else {
            System.out.println("No estoy en la pagina de songs.");
            cerrarBrowser();

            System.exit(-1);
        }
    }

    public void cerrarBrowser() {
        driver.quit();
    }
}
