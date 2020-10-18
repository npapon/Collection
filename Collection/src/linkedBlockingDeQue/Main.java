package linkedBlockingDeQue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main( String[] args ) {

        // On créé une queue qui n'a que dix entrée
        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque( 10 );

        // on va ajouter 2 fois 10 nombre avec 2 thread en concurrence

        MonThread monThread1 = new MonThread( null, 0, linkedBlockingDeque );
        MonThread monThread2 = new MonThread( TimeUnit.MILLISECONDS, 10L, linkedBlockingDeque );

        // ce thread ne rend pas la main si la queue est pleine
        monThread1.start();
        // ce thread oui car il lache l'affaire au bout de 10 millisecondes

        monThread2.start();

        // On fait une pause de 10 secondes et on supprime des éléments

        try {
            Thread.sleep( 10000 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // on supprime 10 éléments et monThread1 pourra finir :)
        for ( int i = 0; i < 10; i++ ) {
            linkedBlockingDeque.pollLast();
        }

        // on va essayer de mettre notre queue 1 dans une queue 2 plus petite

        // création de la queue plus petite

        LinkedBlockingDeque<Integer> linkedBlockingDeque2 = new LinkedBlockingDeque<Integer>( 3 );

        System.out.println( "Capacité restante queue 1 :" + linkedBlockingDeque.remainingCapacity() );

        System.out.println( "Capacité restante queue 2 :" + linkedBlockingDeque2.remainingCapacity() );
        // on essaye de mettre dans la queue 1 la queue 2
        linkedBlockingDeque.drainTo( linkedBlockingDeque2 );

        System.out.println( "queue 2 " + linkedBlockingDeque2 );
    }

}
