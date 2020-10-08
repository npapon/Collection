package SynchronousQueue;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class Producteur extends Thread {
    private SynchronousQueue<String> synchronousQueue;

    public Producteur( SynchronousQueue<String> synchronousQueue ) {
        this.synchronousQueue = synchronousQueue;
    }

    public void run() {
        Random random = new Random();

        for ( int i = 0; i < 5; i++ ) {
            String string = "N°" + random.nextInt( 100 );

            try {
                // put s'arrête si y a plus de place
                synchronousQueue.put( string );
                System.out.println( "Ajout du String dans la queue : " + string );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
