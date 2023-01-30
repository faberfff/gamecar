package co.sofka.cargame.domain;

import java.util.Map;

public class Pista {

    private final String id;
    private final Map<Integer, Carril> carriles;
    private String nombre;

    public Pista(String id, Map<Integer, Carril> carriles, String nombre) {
        this.id = id;
        this.carriles = carriles;
        this.nombre = nombre;
    }

    public void cambiarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getid() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Map<Integer, Carril> getCarriles() {
        return this.carriles;
    }

    public void agregarCarroACarril(Integer numeroCarril, Carro carro) {
        carriles.get(numeroCarril).agregarCarro(carro);
    }

}
