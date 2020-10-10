package delayQueue;

import java.util.concurrent.DelayQueue;

public class Main {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        // ON CREE UNE DELAYQUEUE

        DelayQueue<MyObject> delayQueue = new DelayQueue<MyObject>();
        // ON Y MET DES MYOBJECT, objets qui implémentent Delayed et ont un
        // délai avant libération (en paramètre)

        MyObject monObjet1 = new MyObject( "objet1", 500 );
        MyObject monObjet2 = new MyObject( "objet2", 1000 );
        MyObject monObjet3 = new MyObject( "objet3", 1500 );
        MyObject monObjet4 = new MyObject( "objet4", 2000 );

        // ON AJOUTE CES OBJETS A LA QUEUE
        delayQueue.offer( monObjet1 );
        delayQueue.offer( monObjet2 );
        delayQueue.offer( monObjet3 );
        delayQueue.offer( monObjet4 );

        // ON AFFICHE LA QUEUE
        System.out.println( delayQueue );
        System.out.println( delayQueue.poll() );

        // ON ESSAYE DE RETIRER LES OBJETS
        for ( int i = 0; i < 10; i++ ) {

            try {
                Thread.sleep( 1000 );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            MyObject objetRetire = delayQueue.poll();
            System.out.println( objetRetire );
        }

    }

}
