package transferQueue;

import java.util.concurrent.LinkedTransferQueue;

public class ConsommateurThread extends Thread {
    private LinkedTransferQueue<String> linkedTransferQueue;
    private int                         modeDeRecuperation = 0;
    public static int                   POLL               = 1, TAKE = 2;

    public ConsommateurThread( LinkedTransferQueue<String> linkedTransferQueue, int modeDeRecuperation ) {
        this.linkedTransferQueue = linkedTransferQueue;
        this.modeDeRecuperation = modeDeRecuperation;
    }

    public void run() {
        for ( int i = 0; i < 5; i++ ) {
            // on fait une pause pour laisser les Transfer du consommateur
            // galérer

            try {
                Thread.sleep( 2500 );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // AVEC CE MODE ON RECUPERE SANS BLOCAGE
            if ( modeDeRecuperation == 1 ) {
                System.out.println( "Valeur récupérée par poll " + linkedTransferQueue.poll() );
            }
            // AVEC TAKE ON RECUPERE QUE SI ON A QUELQUE CHOSE A TRANSFERER
            else {

                try {
                    System.out.println( "Valeur récupérée par take " + linkedTransferQueue.take() );
                } catch ( InterruptedException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        System.out.println( "la collection  " + this.getName() + " contient cela à la fin du thread " + linkedTransferQueue );

    }
}
