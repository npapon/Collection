package BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class DoIt {

    public static void doIt( BlockingQueue<Integer> blockingQueue ) {

        // ON CREE UNE BLOCKINGQUEUE PASSE EN PARAMETRE
        BlockingQueue<Integer> blockingQueueLimite = blockingQueue;

        // ON LANCE 2 THREADS QUI AJOUTE 10 ELEMENTS CHACUN A LA BLOCKING QUEUE
        // LE PREMIER N A PAS D UNITE DE TEMPS DONC BLOQUERA LE THREAD SI PAS DE
        // PLACE
        SampleThread sampleThread1 = new SampleThread( null, 0, blockingQueue );
        sampleThread1.setName( "Thread sans unité de temps" );
        // LE PREMIER A UNE UNITE DE TEMPS DONC DEBLOQUERA LE THREAD AU BOUT DE
        // 2 SECONDES (PAR TOUR DES QU ON A PLUS DE PLACE)
        SampleThread sampleThread2 = new SampleThread( TimeUnit.SECONDS, 3L, blockingQueue );
        sampleThread2.setName( "Thread avec unité de temps" );
        sampleThread1.start();
        sampleThread2.start();

        // ON FAIT UNE PAUSE LE TEMPS QUE CA AJOUTE DANS LE MAIN

        try {
            System.out.println( "pause dix secondes le temps d'ajouter " );
            Thread.sleep( 10000 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // ON SUPPRIME QUELQUES ELEMENTS DE LA QUEUE

        for ( int i = 0; i < 10; i++ ) {
            blockingQueue.poll();
        }

        // ON FAIT UNE PAUSE LE TEMPS QUE CA SUPPRIME

        try {
            System.out.println( "pause 3 secondes le temps qu'on supprime 10 éléments" );
            Thread.sleep( 3000 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println( "etat queue apres suppression " + blockingQueue );

        // ON CREE UNE AUTRE QUEUE LIMITE A 4 EMPLACEMENTS
        LinkedBlockingQueue<Integer> blockingQueueLimite2 = new LinkedBlockingQueue<Integer>( 3 );

        // ON AFFICHE LA CAPACITE RESTANTE DES 2 QUEUES
        System.out.println( "Capacité restante queue illimite 1 " + blockingQueueLimite.remainingCapacity() );
        System.out.println( "Capacité restante queue illimite 2 " + blockingQueueLimite2.remainingCapacity() );

        // ON MET TOUS LES ELEMENTS DE LA QUEUE1 DANS LA 2

        try {
            blockingQueueLimite.drainTo( blockingQueueLimite2 );
        } catch ( IllegalStateException e ) {
            System.out.println( "La queue est pleine" );
        }
        // ON AFFICHE LA QUEUE LIMITE 2

        System.out.println( blockingQueueLimite2 );

    }

}
