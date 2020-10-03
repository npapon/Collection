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

        // on créé une liste à part pour stocker des nombre qu'on va ajouter à
        // la queue de notre MyThread
        // en parallèle de ceux ajoutés par la méthode run()
        List<Integer> listAjoutDeNombreEnDehorsDeMyThread = new ArrayList<Integer>();

        thread.start();

        for ( int i = 0; i < 10; i++ ) {
            Random random = new Random();
            // on ne bloque pas ces nombre entre 2 valeurs pour les différencier
            // de ceuw du thread
            int nombreAjouteEnDehorsDeMyThread = random.nextInt();
            queue.offer( nombreAjouteEnDehorsDeMyThread );
            // on les ajoute dans notre list créée à part de celle du thread
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

        System.out.println( "Nomnbre ajouté à la queue via la méthode run de thread " + thread.getListAjout() );
        System.out.println( "Nomnbre ajouté à la queue via le thread principal " + listAjoutDeNombreEnDehorsDeMyThread );
        System.out.println( "Nomnre retiré de queue dans l'ordre " + thread.getListRetrait() );
        System.out.println( "Il reste dans la queue " + thread.getQueue() );

    }

}
