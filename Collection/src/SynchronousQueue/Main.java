package SynchronousQueue;

import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();

        Producteur producteur = new Producteur( synchronousQueue );
        Consommateur consommateur = new Consommateur( synchronousQueue );
        producteur.start();
        consommateur.start();

    }

}
