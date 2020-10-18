package linkedBlockingDeQue;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class MonThread
        extends Thread {

    private TimeUnit                     timeUnit;
    private long                         timeout;
    private LinkedBlockingDeque<Integer> linkedBlockingDeque;

    public MonThread( TimeUnit timeUnit, long timeout, LinkedBlockingDeque<Integer> linkedBlockingDeque ) {
        this.timeUnit = timeUnit;
        this.timeout = timeout;
        this.linkedBlockingDeque = linkedBlockingDeque;

    }

    // ON AJOUTE 10 NOMNRE A LA QUEUE AVEC DES POSSIBILITES DIFFERENTES SI ON
    // RENSEIGNE LE TIMEUNIT
    public void run() {
        Random random = new Random();

        for ( int i = 0; i < 10; i++ ) {
            Integer integer = random.nextInt( 20 );

            // Si pas d'unité de temps, on ajoute integer dans la liste au début
            // ou à la fin (si c'est un tour de boucle pair ou impair)
            // en bloquant le thread indéfiniment avec putFirst ou putLast
            if ( timeUnit == null ) {
                try {
                    if ( i % 2 == 0 ) {
                        this.linkedBlockingDeque.putFirst( integer );
                    } else {
                        this.linkedBlockingDeque.putLast( integer );
                    }
                } catch ( InterruptedException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            // sinon bloque un peu mais apres on lache avec offerFirst et
            // offerLast
            else {
                if ( i % 2 == 0 ) {
                    try {
                        this.linkedBlockingDeque.offerFirst( integer, timeout, timeUnit );
                    } catch ( InterruptedException e ) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    try {
                        this.linkedBlockingDeque.offerLast( integer, timeout, timeUnit );
                    } catch ( InterruptedException e ) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

        // On laisse décanter
        try {
            Thread.sleep( 100 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println( "A la fin du thread " + this.getName() + "ressemble à cela " + linkedBlockingDeque );
    }

}
