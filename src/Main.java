import co.sofka.cargame.domain.Carro;
import co.sofka.cargame.domain.Conductor;
import co.sofka.cargame.domain.Juego;
import co.sofka.cargame.domain.Podium;

public class Main {
    public static void main(String[] args) {

        int numCarriles = 3;
        int kilometros = 200;
        Juego juego = new Juego(numCarriles, kilometros, "Pista # los Algibes");

        Carro rojo = new Carro(Carro.Colores.ROJO, "003");
        rojo.agregarConductor(new Conductor("R1", "Faber", "faber@los.com", "Fast"));

        Carro azul = new Carro(Carro.Colores.AZUL, "009");
        azul.agregarConductor(new Conductor("R2", "Helena", "helena@los.com", "la hele"));

        Carro negro = new Carro(Carro.Colores.NEGRO, "011");
        negro.agregarConductor(new Conductor("R11", "Diana", "diana@los.com", "meji"));

        Carro blanco = new Carro(Carro.Colores.BLANCO, "012");
        blanco.agregarConductor(new Conductor("R12", "jhonnier", "jhonnier@los.com", "jony"));

        Carro rosa = new Carro(Carro.Colores.ROSA, "001");
        rosa.agregarConductor(new Conductor("R3", "Liliana", "lila@los.com", "lili"));

        juego.agregarCarroCarril(1, rojo);
        juego.agregarCarroCarril(2, rosa);
        juego.agregarCarroCarril(1, negro);
        juego.agregarCarroCarril(3, azul);

        Podium podium = juego.iniciarJuego();
        System.out.println(podium);
    }
}