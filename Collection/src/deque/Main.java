package deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        Deque<String> deque = new ArrayDeque<String>();
        // offerLast ajoute un élément à la fin de la file et renvoie null si
        // pas possible
        deque.offerLast( "Nicolas" );
        // offer ajoute à la suite (apres Nicolas)
        deque.offer( "Valentine" );
        // offerFirst ajoute au début (avant Nicolas)
        deque.offerFirst( "Leslie" );

        System.out.println( deque );
        // [Leslie, Nicolas, Valentine]

        // removeFirstOccurence
        // retire la première occurrence de l'élément passé en paramétre de la
        // deque en paramétre et retourne true
        // si ca a été fait

        boolean supprime = deque.removeFirstOccurrence( "Sasha" );

        System.out.println( supprime );

        // false
        supprime = deque.removeFirstOccurrence( "Leslie" );
        System.out.println( supprime );
        // true

        System.out.println( deque );

        // offerLast insére un élément à la fin de la file et retourne false si
        // ca a pas marché

        deque.addLast( "Sasha" );

        System.out.println( deque );

        // removeFirstOccurence
        // retire la derniere occurrence de l'élément passé en paramétre de la
        // deque en paramétre et retourne true
        // si ca a été fait

        supprime = deque.removeLastOccurrence( "Nicolas" );
        // [Nicolas, Valentine, Sasha]

        System.out.println( supprime );
        // true

        System.out.println( deque );
        // [Valentine, Sasha]

        // on parcoure la liste dans le bon sens
        Iterator<String> iterator = deque.iterator();

        while ( iterator.hasNext() ) {
            System.out.println( iterator.next() );
        }

        // on parcoure dans le sens inverse
        // Valentine
        // Sasha
        Iterator<String> descendingiterator = deque.descendingIterator();

        while ( descendingiterator.hasNext() ) {
            System.out.println( descendingiterator.next() );
        }
        // sasha
        // valentine

    }

}
