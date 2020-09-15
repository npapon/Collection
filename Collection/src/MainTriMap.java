import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import bean.CD;
import bean.CDMapComparator;

public class MainTriMap {

    public static void main( String[] args ) {

        System.out.println( "SANS TRI" );

        // PARCOURS D UNE MAP HASHMAP SANS TRI

        Map<Integer, CD> hashmapClePrimaireCD = new HashMap<Integer, CD>();

        hashmapClePrimaireCD.put( 1, new CD( "Les arcandiers", "7€", 7d ) );
        hashmapClePrimaireCD.put( 3, new CD( "Frank Zappa", "Tinseltown rebellion", 10.25d ) );
        hashmapClePrimaireCD.put( 5, new CD( "Frank Zappa", "Bongo Fury", 10.25d ) );
        hashmapClePrimaireCD.put( 4, new CD( "King Crimson", "red", 15.30d ) );
        hashmapClePrimaireCD.put( 2, new CD( "Joe Zawinul", "World tour", 12.15d ) );

        Set<Entry<Integer, CD>> setObjetsEntryCleValeurDeLaHashMap = hashmapClePrimaireCD.entrySet();

        // on peut aussi écrire Map.Entry au lieu de Entry direct

        Iterator<Entry<Integer, CD>> iteratorPourParcourirLeSetObjetsEntry = setObjetsEntryCleValeurDeLaHashMap.iterator();

        while ( iteratorPourParcourirLeSetObjetsEntry.hasNext() ) {
            Entry<Integer, CD> elementParcouru = iteratorPourParcourirLeSetObjetsEntry.next();
            System.out.println( "clé : " + elementParcouru.getKey() + " - valeur : " + elementParcouru.getValue() );
        }

        System.out.println( "AVEC TRI" );
        // PARCOURS D UN MAP//TREEMAP DE MAP AVEC TRI GRACE A UN COMPARATOR

        // 0. On créé le Comparator qui prend en paramètre une hashMap qu'on va
        // trier
        CDMapComparator cDMapCompartor = new CDMapComparator( hashmapClePrimaireCD );
        // 1.On créé une treeMap qui prend le comparator en parametre

        Map<Integer, CD> treemapDintegerEtCD = new TreeMap<Integer, CD>( cDMapCompartor );
        // on le rempli avec les éléments de la hashmap

        treemapDintegerEtCD.putAll( hashmapClePrimaireCD );

        // 2. On créé le set d'Entry pour parcourir le treeMap
        Set<Entry<Integer, CD>> setObjetsEntryCleValeurDeLatreeMap = treemapDintegerEtCD.entrySet();

        Iterator<Entry<Integer, CD>> iteratorPourParcourirLeSetObjetsEntryDuTree = setObjetsEntryCleValeurDeLatreeMap.iterator();

        while ( iteratorPourParcourirLeSetObjetsEntryDuTree.hasNext() ) {
            Entry<Integer, CD> elementParcouru = iteratorPourParcourirLeSetObjetsEntryDuTree.next();
            System.out.println( "clé : " + elementParcouru.getKey() + " - valeur : " + elementParcouru.getValue() );
        }
    }
    // attention ca vire les doublons du tri donc ici le doublon auteur FranK
    // Zappa

}
