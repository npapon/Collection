package SynchronousQueue;

import java.util.concurrent.SynchronousQueue;

public class Consommateur extends Thread {
    private SynchronousQueue<String> synchronousQueue;

    public Consommateur( SynchronousQueue<String> synchronousQueue ) {
        this.synchronousQueue = synchronousQueue;

    }

    public void run() {

        for ( int i = 0; i < 5; i++ ) {

            // on temporise pour éviter une boucle à vide
            try {
                this.sleep( 1000 );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            String string = synchronousQueue.poll();

            System.out.println( "Element retiré de la queue " + string );
        }
    }
}
