package com.sinatra;

import org.junit.Test;

public class LikeSongsFrankSinatra extends LikeSongsParent {


    @Test
    public void testLike() {

        navegarSitio("http://evening-bastion-49392.herokuapp.com/");
        validarHomePage("Welcome to this website all about");
        hacerLogin("frank", "sinatra");
        validarMensajeLogin("You are now logged in as frank");
        validarSongsPage();
        seleccionarCancion(2);
        darLike();
        logOut();
        validarLogOut("You have now logged out");
        cerrarBrowser();
    }

    @Test
    public void testLogin() {
        navegarSitio("https://evening-bastion-49392.herokuapp.com/");
        validarHomePage();
        realizarLoginCorrecto("frank", "sinatra");
        validarMensajeBienvenida("You are now logged in as frank");
        validarSongsPage();
        cerrarBrowser();
        }
}
