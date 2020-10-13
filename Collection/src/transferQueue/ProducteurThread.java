package transferQueue;

import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

//CETTE CLASSE PRODUIT DES THREADS
//UNE AUTRE CLASSE CONSOMMERA LES THREADS

public class ProducteurThread extends Thread {

    private LinkedTransferQueue<String> linkedTransferQueue;
    private int                         modeDeTransfert = 0;
    public static int                   BLOCK           = 1, TIMEOUT = 2, DEFAULT = 0;

    public ProducteurThread( LinkedTransferQueue<String> linkedTransferQueue, int modeDeTransfert ) {

        this.linkedTransferQueue = linkedTransferQueue;
        this.modeDeTransfert = modeDeTransfert;
    }

    // ON AJOUTE 5 STRING DANS UNE LINKEDTRANSFERQUEUE
    public void run() {

        Random random = new Random();

        for ( int i = 0; i < 5; i++ ) {

            String unString = "RANDOM_" + random.nextInt( 20 );

            long debutDuStransfert = System.currentTimeMillis();

            // SI LE MODE DE TRANSFER DANS LA QUEUE EST A 1, ON UTILISE LA
            // METHODE TRANSFER POUR ALIMENTER LA QUEUE
            // CELA VEUT DIRE QUE LE TRANSFERT EST BLOQUE TANT DANS L ATTENTE D
            // UN AUTRE THREAD
            if ( modeDeTransfert == 1 ) {
                // on
                try {
                    linkedTransferQueue.transfer( unString );
                    long finDuStransfert = System.currentTimeMillis();

                    System.out.println(
                            "L'élément a été transféré en " + ( ( finDuStransfert - debutDuStransfert ) / 1000 ) + " secondes" );

                } catch ( InterruptedException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else if ( modeDeTransfert == 2 ) {

                // ON ESSAYE DE TRANSFERER PENDANT UNE SECONDE
                // LE TRANSFERT MARCHE SI UN ELEMENT DANS LA SECONDE ESSAYE DE
                // RECUPERER L ELEMENT TRANSFERE
                // trytransfer retournera true si un thread attend et false dans
                // le cas contraire.

                try {
                    boolean tryTransferReussi = linkedTransferQueue.tryTransfer( unString, 1000, TimeUnit.MILLISECONDS );
                    long finDuStransfert = System.currentTimeMillis();
                    System.out.println( "Transfer réussi " + tryTransferReussi );

                    System.out.println(
                            "L'élément a été transféré en " + ( ( finDuStransfert - debutDuStransfert ) / 1000 ) + " secondes" );

                } catch ( InterruptedException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else

            // TRANSFERT SANS BLOCAGE
            {
                linkedTransferQueue.offer( unString );

                System.out.println( "Element " + unString + " inséré sans attente " );
            }

            // PETITE PAUSE
            try {
                Thread.sleep( 1000 );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
