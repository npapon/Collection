import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import bean.CD;
import bean.CDComparator;

public class MainSetComparator {

    public static void main( String[] args ) {
        Set<CD> treeSetDeCD = new TreeSet<CD>();
        treeSetDeCD.add( new CD( "Les arcandiers", "7€", 7d ) );
        treeSetDeCD.add( new CD( "Frank Zappa", "Tinseltown rebellion", 10.25d ) );
        treeSetDeCD.add( new CD( "Frank Zappa", "Bongo Fury", 10.25d ) );
        treeSetDeCD.add( new CD( "King Crimson", "red", 15.30d ) );
        treeSetDeCD.add( new CD( "Joe Zawinul", "World tour", 12.15d ) );

        System.out.println( "Avant le tri : " );
        Iterator<CD> it = treeSetDeCD.iterator();
        while ( it.hasNext() ) {
            System.out.println( it.next() );
        }

        Set<CD> treeSetDeCD2 = new TreeSet<CD>( new CDComparator() );
        // on rempli la seconde collection avec la première
        treeSetDeCD2.addAll( treeSetDeCD );
        System.out.println( "Après le tri : " );

        it = treeSetDeCD2.iterator();
        while ( it.hasNext() ) {
            System.out.println( it.next() );
        }

    }

}
