package com.sinatra;

public class LikeSongsFrankSinatra {


    @Test
    public void testLike {

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
        navegar("https://evening-bastion-49392.herokuapp.com/");
        validarHomePage();
        realizarLoginCorrecto("frank", "sinatra");
        validarMensajeBienvenida("You are now logged in as frank");
        validarSongsPage();
        cerrarBrowser();
        }
    }
}
