package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Deposito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepositoRepository {

    private static List<Deposito> depositos;

    static {
        depositos = new ArrayList<>();

        Deposito xangai = new Deposito();
        xangai.setId( 1L ).setNome( "Xangai" );

        Deposito barcelona = new Deposito( 2L, "Barcelona" );
        Deposito comptom = new Deposito( 3L, "Comptom" );
        Deposito osasco = new Deposito( 4L, "Osasco" );

        depositos.addAll( Arrays.asList( xangai, barcelona, comptom, osasco ) );

    }

    public static List<Deposito> findAll() {
        return depositos;
    }

    public static Deposito findById(Long id) {
        for (int i = 0; i < depositos.size(); i++) {
            if (depositos.get( i ).getId().equals( id )) {
                return depositos.get( i );
            }
        }
        return null;
    }

    public static List<Deposito> findByName(String texto) {
        List<Deposito> depositosEncontrados = new ArrayList<>();
        for (Deposito d : depositos) {
            if (d.getNome().equalsIgnoreCase( texto )) {
                depositosEncontrados.add( d );
            }
        }
        return depositosEncontrados;
    }

    public static Deposito persist(Deposito d) {
        d.setId( depositos.size() + 1L );
        depositos.add( d );
        return d;
    }


}
