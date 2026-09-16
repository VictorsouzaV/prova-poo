package br.com.starlog.model;

import java.util.HashMap;
import java.util.Map;

public class BaseLancamento {
    private Map<String, ModuloCarga> modulos = new HashMap<>();

    public Map<String, ModuloCarga> getVerLista() {
        return this.modulos;
    }

    public void cadastrarModulo(ModuloCarga modulo) {
        if (modulos.containsKey(modulo.getVerCodigo())) {
            System.out.println("Modulo ja cadastrado!");

        } else {
            modulos.put(modulo.getVerCodigo(), modulo);
            System.out.println("Modulo " + modulos.get(modulo.getVerCodigo()) + " cargas");
        }
    }

    public  void buscarModulo(ModuloCarga modulo) {
        if (modulos.containsKey(modulo.getVerCodigo())) {
            System.out.println("Modulo encontrado: " + modulos.get(modulo.getVerCodigo()));

        } else {
            System.out.println("Codigo informado não existe " + modulo.getVerCodigo());
        }
    }
}
