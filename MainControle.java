package br.com.starlog.main;

import br.com.starlog.model.Carga;
import br.com.starlog.model.ModuloCarga;
import br.com.starlog.model.BaseLancamento;

import javax.naming.LimitExceededException;

import br.com.starlog.exception.CapacidadeExcedidaException;

public class MainControle {
    public static void main(String[] args) throws LimitExceededException{
        Carga c1 = new Carga("ORB-101-SP", "CRIOGENCIA", 2.5, 450.00);
        Carga c2 = new Carga("ORB-102-RJ", "PADRAO", 8.0, 120.00);
        Carga c3 = new Carga("ORB-103-MG", "CRIOGENCIA", 12.0, 850.00);
        Carga c4 = new Carga("ORB-104-PR", "BIOLOGICA", 15.0, 300.00);

        System.out.println(c1);
        System.out.println(c4);

        System.out.println();

        ModuloCarga modulo = new ModuloCarga("MOD-ALFA-01", 3);
        BaseLancamento base = new BaseLancamento();

        base.cadastrarModulo(modulo);

        System.out.println();

        base.buscarModulo(modulo);

        System.out.println();

            modulo.carregarCarga(c1);
            modulo.carregarCarga(c2);
            modulo.carregarCarga(c3);

        System.out.println();

        System.out.println("Seguro total do modulo: " + modulo.calcularSeguroTotal());

        System.out.println();

        System.out.println("Cargas CRIOGENCIA: " + modulo.contarCargasPorCategoria("CRIOGENCIA"));

        System.out.println();

        System.out.println("Seguro de cargas criticas: R$" + modulo.calcularSeguroCargasPesadas("CRIOGENCIA", 5.0));

        System.out.println();

        c1.adicionarCarga(c1);
        Carga c5 = new Carga("ORB-101-SP", "CRIOGENCIA", 29.0, 990.00);
        c1.adicionarCarga(c5);
        c1.adicionarCarga(c2);

        System.out.println(c1.getVerTamanho());

        try {
            Carga c6 = new Carga("", "PADRAO", 40.0, 870.00);
            c6.adicionarCarga(c6);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
