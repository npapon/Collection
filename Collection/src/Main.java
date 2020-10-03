import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import concurrentLinkedQueue.MyThread;

public class Main {

    public static void main( String[] args ) {

        List<Integer> listAjout = new ArrayList<Integer>();
        List<Integer> listRetrait = new ArrayList<Integer>();
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

        MyThread thread = new MyThread( queue, listRetrait, listAjout );
        thread.setName( "Mon premier thread" );

        // on cr�� une liste � part pour stocker des nombre qu'on va ajouter �
        // la queue de notre MyThread
        // en parall�le de ceux ajout�s par la m�thode run()
        List<Integer> listAjoutDeNombreEnDehorsDeMyThread = new ArrayList<Integer>();

        thread.start();

        for ( int i = 0; i < 10; i++ ) {
            Random random = new Random();
            // on ne bloque pas ces nombre entre 2 valeurs pour les diff�rencier
            // de ceuw du thread
            int nombreAjouteEnDehorsDeMyThread = random.nextInt();
            queue.offer( nombreAjouteEnDehorsDeMyThread );
            // on les ajoute dans notre list cr��e � part de celle du thread
            // pour bien les distinguer
            listAjoutDeNombreEnDehorsDeMyThread.add( nombreAjouteEnDehorsDeMyThread );
            try {
                Thread.sleep( 1000 );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {
            thread.join();
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println( "Nomnbre ajout� � la queue via la m�thode run de thread " + thread.getListAjout() );
        System.out.println( "Nomnbre ajout� � la queue via le thread principal " + listAjoutDeNombreEnDehorsDeMyThread );
        System.out.println( "Nomnre retir� de queue dans l'ordre " + thread.getListRetrait() );
        System.out.println( "Il reste dans la queue " + thread.getQueue() );

    }

}
