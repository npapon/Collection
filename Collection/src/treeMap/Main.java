package treeMap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class Main {

    public static void main( String[] args ) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put( 1, "un" );
        treeMap.put( 2, "deux" );
        treeMap.put( 3, "trois" );

        System.out.println( treeMap );
        // {1=un, 2=deux, 3=trois}

        // headMap(K toKey, boolean inclusive) retourne une NavigableMap<K,V>
        // inférieur à la clé en param (inclusive ou non)

        NavigableMap<Integer, String> navigableMap = treeMap.headMap( 2, true );
        System.out.println( navigableMap );
        // {1=un, 2=deux}

        //// tailMap(K toKey, boolean inclusive) retourne une NavigableMap<K,V>
        // supérieur à la clé en param (inclusive ou non)

        NavigableMap<Integer, String> navigableMap2 = treeMap.tailMap( 2, true );
        System.out.println( navigableMap2 );
        // {2=deux, 3=trois}

        // collection.values affiche uniquement les values de la collection (et
        // pas les keys)
        System.out.println( treeMap.values() );

        // [un, deux, trois]
        // collection.ceillingEntry retourne l'Entry<K,V> de la clé 2

        System.out.println( treeMap.ceilingEntry( 2 ) );
        // 2=deux
        // collection.firstEntry ramène la première Entry<K,V> de le collection
        System.out.println( treeMap.firstEntry() );
        // 1=un

        // lowerKey ramène la clé plus petite que la 3
        System.out.println( treeMap.lowerKey( 3 ) );
        // 2
        // collection.subMap retourne une sous collection de la clé 1 inclu à la
        // clé 3 exclu
        System.out.println( treeMap.subMap( 1, true, 3, false ) );
        // {1=un, 2=deux}

        // on va parcourir la map
        // la méthode entrySet retourne un set d'entry<integer,String> des
        // éléments de la map
        Set<Entry<Integer, String>> set = treeMap.entrySet();
        Iterator<Entry<Integer, String>> iterator = set.iterator();

        while ( iterator.hasNext() ) {
            Entry<Integer, String> entry = iterator.next();
            System.out.println( entry.getKey() + " - " + entry.getValue() );
        }

        /*
         * 1 - un 2 - deux 3 - trois
         */

        // on va créer une nouvelle treeMap qu'on va trier dans le désordre
        // on redéfini la méthode compare de l'interface Comparator passée en
        // paramétre

        TreeMap<Integer, String> treeMap2 = new TreeMap<>( new Comparator<Integer>() {
            public int compare( Integer key1, Integer key2 ) {

                return key2.compareTo( key1 );
            }

        } );

        iterator = set.iterator();
        while ( iterator.hasNext() ) {
            Entry<Integer, String> entry = iterator.next();
            treeMap2.put( entry.getKey(), entry.getValue() );

        }
        System.out.println( treeMap2 );

        // {3=trois, 2=deux, 1=un}

        // pollFirstEntry()
        // Retourne un objet Map.Entry<K,V> correspondant à la
        // plus petite clé,
        // tout en supprimant cette entrée de la collection. Renvoie null si la
        // clé n'existe pas.

        iterator = set.iterator();

        System.out.println( "Vidage de map" );
        Entry<Integer, String> entry = null;
        while ( ( entry = treeMap2.pollFirstEntry() ) != null ) {
            System.out.println( entry );
            System.out.println( treeMap2 );
        }

        /*
         * 3=trois {2=deux, 1=un} 2=deux {1=un} 1=un {}
         */

    }

}
