package concurrentLinkedQueue;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyThread extends Thread {

    private ConcurrentLinkedQueue<Integer> queue;
    private List<Integer>                  listRetrait, listAjout;

    public MyThread( ConcurrentLinkedQueue queue, List<Integer> listRetrait, List<Integer> listAjout ) {
        this.queue = queue;
        this.listRetrait = listRetrait;
        this.listAjout = listAjout;

    }

    public void run() {
        int nombrePourSortirDuWhile = 0;
        Random random = new Random();
        while ( true ) {

            try {
                // on fait retarder chaque boucle d'une seconde
                this.sleep( 1000 );
                Integer nombreAjouteALaQueue = random.nextInt( 20 );
                // offer permet d'ajouter un élément queue et renvoie false si
                // c'est
                // pas possible

                queue.offer( nombreAjouteALaQueue );

                /// on retire un élément avec poll() si la collection est vide
                /// cela
                // ca retourne null

                Integer nombreRetireDeLaQueue = queue.poll();
                // on stocke le chiffre retiré dans la liste des retraits
                listRetrait.add( nombreRetireDeLaQueue );
                // on stocke le chiffre ajouté dans la liste des ajouts
                listAjout.add( nombreAjouteALaQueue );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // on soirt de la liste au bout de 10 tours
            nombrePourSortirDuWhile++;
            if ( nombrePourSortirDuWhile > 10 ) {
                break;
            }

        }
        System.out.println( "fin du thread " + this.currentThread().getName() );

    }

    public ConcurrentLinkedQueue<Integer> getQueue() {
        return queue;
    }

    public void setQueue( ConcurrentLinkedQueue<Integer> queue ) {
        this.queue = queue;
    }

    public List<Integer> getListRetrait() {
        return listRetrait;
    }

    public void setListRetrait( List<Integer> listRetrait ) {
        this.listRetrait = listRetrait;
    }

    public List<Integer> getListAjout() {
        return listAjout;
    }

    public void setListAjout( List<Integer> listAjout ) {
        this.listAjout = listAjout;
    }

}
