package transferQueue;

import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;

public class Main {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        // ON CREE UNE QUEUE
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<String>();
        // On essaye via un thread de transférer 5 String aléatoire dans
        // linkedTransferQueue avec tryTransfer
        ProducteurThread producteurThread = new ProducteurThread( linkedTransferQueue, ProducteurThread.TIMEOUT );
        // On essaye via un thread de retirer 5 String aléatoire dans
        // linkedTransferQueue avec poll
        ConsommateurThread consommateurThread = new ConsommateurThread( linkedTransferQueue, ConsommateurThread.POLL );

        producteurThread.start();
        consommateurThread.start();

        // dans le consommateur la temporisation Thread.sleep( 2500 ) est trop
        // grande que celle de la tentative du tryTranfer (1000)
        // peu de contenu seront ok

        try {
            Thread.sleep( 15000 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println( "FIN TEST 1" );

        linkedTransferQueue = new LinkedTransferQueue<String>();

        // On ajoute via un thread de 5 String aléatoire dans
        // linkedTransferQueue avec offer
        ProducteurThread producteurThread2 = new ProducteurThread( linkedTransferQueue, ProducteurThread.DEFAULT );
        // On essaye via un thread de retirer 5 String aléatoire dans
        // linkedTransferQueue avec take
        ConsommateurThread consommateurThread2 = new ConsommateurThread( linkedTransferQueue, ConsommateurThread.TAKE );

        producteurThread2.start();
        consommateurThread2.start();
        try {
            Thread.sleep( 15000 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // la temporisation a permis que des OK

        System.out.println( "FIN TEST 2" );

        linkedTransferQueue = new LinkedTransferQueue<String>();

        // On ajoute via un thread de 5 String aléatoire dans
        // linkedTransferQueue avec transfer
        ProducteurThread producteurThread3 = new ProducteurThread( linkedTransferQueue, ProducteurThread.DEFAULT );
        // On essaye via un thread de retirer 5 String aléatoire dans
        // linkedTransferQueue avec take
        ConsommateurThread consommateurThread3 = new ConsommateurThread( linkedTransferQueue, ConsommateurThread.TAKE );

        producteurThread3.start();
        consommateurThread3.start();

        // QUE DES OK ICI AUSSI
        try {
            Thread.sleep( 15000 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // la temporisation a permis que des OK

        System.out.println( "FIN TEST 3" );

        linkedTransferQueue = new LinkedTransferQueue<String>();
        // on lance 2 consommateursThread en décaler qui consomme la queue que
        // si on ajoute un thread
        ConsommateurThread consommateurThread4 = new ConsommateurThread( linkedTransferQueue, ConsommateurThread.TAKE );
        ConsommateurThread consommateurThread5 = new ConsommateurThread( linkedTransferQueue, ConsommateurThread.TAKE );

        // On démarre en décaler les threads
        consommateurThread4.start();
        try {
            Thread.sleep( 5000 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        consommateurThread5.start();

        Random random = new Random();
        // retourne une estimation des threads attendant des éléments de la
        // collection ;
        System.out.println( "thread attendant d etre consommé " + linkedTransferQueue.getWaitingConsumerCount() );
        // Affiche 1

        // hasWaitingConsumerCount() : retourne true si au moins un thread
        // attend un élément de la collection.
        while ( linkedTransferQueue.hasWaitingConsumer() ) {
            System.out.println( "thread attendant d etre consommé " + linkedTransferQueue.getWaitingConsumerCount() );
            String string = "RANDOM_" + random.nextInt( 20 );
            try {
                linkedTransferQueue.transfer( string );
                System.out.println( "ajout avec succes de " + string );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // ON LAISSE AERER
            try {
                Thread.sleep( 5000 );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
