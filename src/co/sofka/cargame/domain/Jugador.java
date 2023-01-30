package co.sofka.cargame.domain;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final String idJugador;
    private final String userName;
    private String email;
    private List<Integer> puntos;


    public Jugador(String idJugador, String email, String userName) {
        this.idJugador = idJugador;
        this.email = email;
        this.puntos = new ArrayList<>();
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void agregarPunto(Integer punto) {
        this.puntos.add(punto);
    }

    public Integer puntos() {
        return puntos.stream().reduce(Integer::sum).orElseThrow();
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "idJugador='" + idJugador + '\'' +
                ", email='" + email + '\'' +
                ", puntos=" + puntos +
                ", userName='" + userName + '\'' +
                '}';
    }
}
