package BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class SampleThread extends Thread {

    private TimeUnit               uniteDeTemps;
    private long                   timeOut;
    private BlockingQueue<Integer> blockingQueue;

    // VOICI UN CONSTRUCTEUR AVEC UNE UNITE DE TEMPS (SECONDES,MINUTES), UN
    // CHIFFRE ASSOCIE A CETTE UNITE ET UNE BLOCKINGQUEUE
    public SampleThread( TimeUnit uniteDeTemps, long timeOut, BlockingQueue<Integer> blockingQueue ) {
        this.uniteDeTemps = uniteDeTemps;
        this.timeOut = timeOut;
        this.blockingQueue = blockingQueue;
    }

    // VOICI LA METHODE RUN LANCE AVEC LE THREAD
    // ON A UNE BOUCLE DE 10
    // ON Y CREE A CHAQUE TOUR UN NOMBRE ALEATOIRE ENTRE 0 ET 20
    public void run() {
        Random random = new Random();

        for ( int i = 0; i < 10; i++ ) {

            int nombre = random.nextInt( 20 );
            /*
             * System.out.println( "tour " + i + " - nombre ajouté " + nombre );
             */

            // offer(E elem, long timeout, TimeUnit unit) bloque le thread
            // pendant une durée timeout unit

            // put bloque indefiniment si pas de place

            // SI ON RENSEIGNE PAS D UNITE DE TEMPS ON BLOQUE SI Y A PAS DE
            // PLACE INDIFINIMENT
            if ( this.uniteDeTemps == null ) {

                try {
                    blockingQueue.put( nombre );
                } catch ( InterruptedException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // SINON ON BLOQUE QUE LE TEMPS DEFINI DANS L UNITE DE TEMPS
            } else {
                try {
                    blockingQueue.offer( nombre, this.timeOut, this.uniteDeTemps );
                } catch ( InterruptedException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        // ON AFFICHE LA QUEUE A LA FIN
        System.out.println( "Thread terminé " + this.currentThread().getName() + "\n le queue contient " + blockingQueue );

    }

}
