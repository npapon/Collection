package delayQueue;

import java.util.concurrent.TimeUnit;

public class MainTest {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        // TIMEUNIT PERMET DE DEFINIR UNE UNITE DE TEMPS
        // ICI LES MINUTRES
        TimeUnit timeUnit = TimeUnit.MINUTES;

        // timeUnit.convert permet de convertir le chiffre en premier param, ici
        // 1 dont l'unit� de temps est le second param�tre ici heure en l'unit�
        // de temps du timeunit ici les minutres
        // on convertit 1heure en minutres
        long uneHeureEnMinutes = timeUnit.convert( 1, TimeUnit.HOURS );
        // On obtient 60
        System.out.println( uneHeureEnMinutes );

    }

}
