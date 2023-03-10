package co.sofka.cargame.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Juego {

    private final Podium podium;
    private final Pista pista;
    private Estado estado;

    public Juego(Integer numCarriles, Integer kilometros, String nombreDePista) {
        Map<Integer, Carril> carriles = generarCarriles(numCarriles, kilometros);
        pista = new Pista(UUID.randomUUID().toString(), carriles, nombreDePista);
        this.podium = new Podium();
        estado = Estado.NO_INICIADO;
    }

    public void agregarCarroCarril(Integer carril, Carro carro) {
        if(Objects.isNull(carro.conductor())){
            throw new IllegalArgumentException("El carro no tiene un conductor");
        }
        pista.agregarCarroACarril( carril, carro);
    }

    public Podium iniciarJuego() {
        validarCarriles();
        iniciarCarros();

        do {
            estado = Estado.INICIADO;
            pista.getCarriles().forEach(moverCarril());
        }while(estado.equals(Estado.INICIADO));

        return podium;
    }

    private Map<Integer, Carril> generarCarriles(Integer numCarriles, Integer kilometros) {
        Map<Integer, Carril> carriles = new HashMap<>();
        for(int i = 1; numCarriles >= i; i++) {
            carriles.put(i, new Carril(i, kilometros));
        }
        return carriles;
    }

    /**
     * función que evalúa si existen la cantidad suficiente de carros para realizar la carrera
     */
    private void validarCarriles() {
        int cantidadDeCarros = 0;
        for (Carril carril: pista.getCarriles().values()) {
            cantidadDeCarros = carril.carros().size() + cantidadDeCarros;
        }
        if(cantidadDeCarros <= 2) {
            throw new IllegalArgumentException("No tiene la cantidad de carros suficientes");
        }
    }

    private void iniciarCarros() {
        pista.getCarriles().values().forEach(carril -> carril.carros().forEach(Carro::iniciar));
    }

    private BiConsumer<Integer, Carril> moverCarril() {
        return (id, carril) -> carril.carros().forEach(moverCarro(carril));
    }

    private Consumer<Carro> moverCarro(Carril carril) {
        return carro -> {
            int dado = carro.conductor().lanzarDado();
            IntStream.range(0, dado * 100).forEach(value -> carro.aumentarMetro());
            determinarGanador(carril, carro);
        };
    }

    private void determinarGanador(Carril carril, Carro carro) {
        if(carro.estaEnMarcha()) {
            double progreso = carril.progresoCarro(carro.placa());
            if(progreso >= 100) {
                determinarPodium(carro);
            }
        }
    }

    private void determinarPodium(Carro carro) {
        if(Objects.isNull(podium.Primero())) {
            podium.setPrimero(carro.conductor());
            carro.pararMarcha();
        } else if(Objects.isNull(podium.Segundo())) {
            podium.setSegundo(carro.conductor());
            carro.pararMarcha();
        } else if (Objects.isNull(podium.Tercero())) {
            podium.setTercero(carro.conductor());
            carro.pararMarcha();
            finDelJuego();
        }
    }

    private void finDelJuego() {
        estado = Estado.FINALIZADO;
    }

    public enum Estado {
        INICIADO, FINALIZADO, NO_INICIADO
    }
}
