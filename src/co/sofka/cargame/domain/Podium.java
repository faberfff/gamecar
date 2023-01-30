package co.sofka.cargame.domain;

public class Podium {

    private Conductor primero;
    private Conductor segundo;
    private Conductor tercero;

    public Podium() {
    }

    public void setPrimero(Conductor conductor) {
        this.primero = this.primero;
    }

    public void setSegundo(Conductor conductor) {
        this.segundo = this.segundo;
    }

    public void setTercero(Conductor conductor) {
        this.tercero = this.tercero;
    }

    public Conductor Primero() {
        return this.primero;
    }

    public Conductor Segundo() {
        return this.segundo;
    }

    public Conductor Tercero() {
        return this.tercero;
    }

    public String toString() {
        System.out.println("Esta entrando al método");
        return "Podium{primero=" + this.primero + ", segundo=" + this.segundo + ", tercero=" + this.tercero + "}";

    }
}
