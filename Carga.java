package br.com.starlog.model;

import java.util.HashSet;
import java.util.Set;

public class Carga {
    private String codigoRastreio;
    private String categoria;
    private double pesoKg;
    private double valorSeguro;

    private Set<Carga> manifesto = new HashSet<>();

    public Carga(String codigoRastreio, String categoria, double pesoKg, double valorSeguro) {
        verificarCodigo(codigoRastreio);
        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;
    }

    public void verificarCodigo(String codigoRastreio) {
        if (codigoRastreio == null || codigoRastreio.trim().isEmpty()) {
            throw new IllegalArgumentException("Codigo de rastreio invalido, não pode ser nulo ou invalido!");
        }
    }

    public String getVerCodigo() {
        return this.codigoRastreio;
    }

    public String getVerCategoria() {
        return this.categoria;
    }

    public void setMudarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getVerPeso() {
        return this.pesoKg;
    }

    public void setMudarPeso(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public double getVerValor() {
        return this.valorSeguro;
    }

    public void setAlterarValor(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public int getVerTamanho() {
        return this.manifesto.size();
    }

    public Set<Carga> getVerLista() {
        return this.manifesto;
    }

    public void adicionarCarga(Carga carga) {
        manifesto.add(carga);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Carga)) {
            return false;
        }

        Carga outraCarga = (Carga) obj;
        return getVerCodigo().equals(outraCarga.codigoRastreio);
    }

    @Override
    public int hashCode() {
        return this.codigoRastreio.hashCode();
    }
 
    @Override
    public String toString() {
        return "Carga rastreio: " + getVerCodigo() + "\n" +
                "Categoria: " + getVerCategoria() + "\n" +
                "Peso: " + getVerPeso() + "\n" +
                "Seguro: R$" + getVerValor();
    }
}
