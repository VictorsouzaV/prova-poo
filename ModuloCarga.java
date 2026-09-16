package br.com.starlog.model;

import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

import javax.naming.LimitExceededException;

public class ModuloCarga {
    private String codigoModulo;
    private int capacidadeMaxima;
    private Set<Carga> cargas = new HashSet<>();

    public ModuloCarga(String codigoModulo, int capacidadeMaxima) {
        this.codigoModulo = codigoModulo;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getVerCodigo() {
        return this.codigoModulo;
    }

    public int getVerCapacidade() {
        return this.capacidadeMaxima;
    }

    public Set<Carga> getVerListaDeCargas() {
        return this.cargas;
    }

    public void carregarCarga(Carga carga) throws LimitExceededException {
        if (cargas.size() >= capacidadeMaxima) {
            throw new LimitExceededException("Modulo " + carga.getVerCodigo() + " atingiu a capacidade maxima de " + getVerCapacidade() + " cargas");
        } 
        cargas.add(carga);
            System.out.println("Carga " + carga.getVerCodigo() + " carregada no modulo com sucesso!");
    }

    public double calcularSeguroTotal() {
        return cargas.stream()
                     .mapToDouble(Carga::getVerValor)
                     .sum();
    }

    public long contarCargasPorCategoria(String categoria) {
        return cargas.stream()
                     .filter(Carga -> categoria != null
                        && (Carga.getVerCategoria().equalsIgnoreCase(categoria))
                    )
                     .count();
    }

    public double calcularSeguroCargasPesadas(String categoria, double pesoMinimo) {
        return cargas.stream()
                     .filter(Carga -> categoria != null
                        && (Carga.getVerCategoria().equalsIgnoreCase(categoria))
                        && (Carga.getVerPeso() > pesoMinimo)
                     )
                     .mapToDouble(Carga::getVerValor)
                     .sum();
    }

    @Override
    public String toString() {
        return "Codigo: " + getVerCodigo() + "\n" +
                "Capacidade " + getVerCapacidade();
    }
}
