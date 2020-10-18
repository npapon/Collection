package hashMapLinkedHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

    public static void main( String[] args ) {
        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put( 1, "un" );

        hashMap.put( 3, "trois" );
        hashMap.put( 2, "deux" );
        // parcours de la Map

        // map.entrySet() retourne un objet de type Set<Entry<K,V> 
        // avec K la clé des collections et V la valeur
        // du coup on peut la parcourir avec un iterator

        Set<Entry<Integer, String>> set = hashMap.entrySet();
        Iterator<Entry<Integer, String>> iterator = set.iterator();

        while ( iterator.hasNext() ) {
            Entry<Integer, String> entry = iterator.next();
            System.out.println( entry.getKey() + " - " + entry.getValue() );

        }

        /*
         * 1 - un 2 - deux 3 - trois
         */

        // afficher la valeur de la clé 2

        System.out.println( "valeur de la clé 2 " + hashMap.get( 2 ) );
        // valeur de la clé 2 deux

        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

        linkedHashMap.put( 1, "un" );

        linkedHashMap.put( 3, "trois" );
        linkedHashMap.put( 2, "deux" );

        Set<Entry<Integer, String>> set2 = linkedHashMap.entrySet();

        Iterator<Entry<Integer, String>> iterator2 = set2.iterator();

        while ( iterator2.hasNext() ) {
            Entry<Integer, String> entry = iterator2.next();

            System.out.println( entry.getKey() + " - " + entry.getValue() );
        }

    }

}
