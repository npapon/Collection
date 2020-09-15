import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class MainPriorityQueue {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        Queue<Integer> collectionQueue = new PriorityQueue<Integer>();

        // on retire un élément avec poll() si la collection est vide cela
        // retourne

        System.out.println( collectionQueue.poll() );
        // null

        Random random = new Random();

        // offer permet d'ajouter un élément queue et renvoie false si c'est pas
        // possible
        for ( int i = 0, j = 20; i < j; i++ ) {
            int nombreAleatoireEntre0Et20 = random.nextInt( 20 );
            collectionQueue.offer( nombreAleatoireEntre0Et20 );
        }

        System.out.println( collectionQueue );
        // [1, 2, 2, 5, 6, 5, 3, 7, 5, 10, 8, 16, 12, 12, 8, 12, 19, 12, 9, 18]

        // on met la queue dans une liste
        List<Integer> listPourYStockerLaQueue = new ArrayList<Integer>();
        Iterator<Integer> iteratorPourParcourirLaQueue = collectionQueue.iterator();

        while ( iteratorPourParcourirLaQueue.hasNext() ) {
            listPourYStockerLaQueue.add( iteratorPourParcourirLaQueue.next() );
        }

        System.out.println( listPourYStockerLaQueue );
        // [0, 2, 2, 6, 4, 11, 3, 10, 9, 10, 12, 16, 12, 6, 16, 18, 13, 17, 11,
        // 15]

        // on va supprimer dans la collection List les éléments de la
        // collections queue

        // remove all : Supprime tous les éléments de la collection se trouvant
        // dans la collection passée en paramètre.

        listPourYStockerLaQueue.removeAll( collectionQueue );
        System.out.println( listPourYStockerLaQueue );
        // []

        // remove() Retourne le premier élément de la collection, en le
        // supprimant cette fois.
        // S'il n'y a plus d'éléments lors de l'appel à cette méthode, celle-ci
        // retournera une exception de type NoSuchElementException.

        // On va retirer des éléments de la queue et les ajouter au fur et à
        // mesure dans la liste précédemment vidé

        for ( int i = 0, j = 20; i < j; i++ ) {
            int elementRetire = collectionQueue.remove();
            System.out.println( "ELEMENT RETIRE  :" + elementRetire );
            System.out.println( "QUEUE : " + collectionQueue );
            listPourYStockerLaQueue.add( elementRetire );
            System.out.println( "LIST : " + listPourYStockerLaQueue );
        }

        System.out.println( "QUEUE FINALE " + collectionQueue );
        System.out.println( "LIST FINALE " + listPourYStockerLaQueue );
        // QUEUE FINALE []
        // LIST FINALE [1, 1, 3, 3, 5, 7, 8, 9, 9, 9, 9, 10, 12, 16, 16, 16, 16,
        // 18, 19, 19]

        // EXEMPLE OU ON VA DEFINIR L ORDRE DE SORTIE DES ELEMENTS DE LA QUEUE

        Queue<Integer> queueAvecOrdreDeSortie = new PriorityQueue<Integer>( new Comparator<Integer>() {

            @Override
            public int compare( Integer integer1, Integer integer2 ) {
                // on trie en sens inverse
                return integer2.compareTo( integer1 );
            }

        } );

        Random ramdomChiffre = new Random();

        for ( int i = 0, j = 20; i < j; i++ ) {
            int chiffreAleatoireEntre0et20 = ramdomChiffre.nextInt( 20 );
            queueAvecOrdreDeSortie.add( chiffreAleatoireEntre0et20 );
        }

        System.out.println( "QUEUE AVEC ORDRE DE SORTIE " + queueAvecOrdreDeSortie );
        // pour le moment c'est aléatoire

        // [0, 0, 1, 0, 4, 5, 1, 1, 6, 9, 16, 19, 10, 1, 9, 19, 5, 19, 7, 15]

        List<Integer> listPourViderLaQueueDansLeSensDuComparator = new ArrayList<Integer>();

        for ( int i = 0, j = 20; i < j; i++ ) {

            listPourViderLaQueueDansLeSensDuComparator.add( queueAvecOrdreDeSortie.remove() );
        }

        System.out.println(
                "LIST ALIMENTE EN SENS INVERSE AU MOMENT DU VIDAGE DE LA QUEUE " + listPourViderLaQueueDansLeSensDuComparator );

        //[19, 18, 18, 15, 15, 15, 14, 13, 12, 10, 10, 8, 8, 8, 6, 6, 5, 5, 2, 1]
    }

}
