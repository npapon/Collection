import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import bean.CD;

public class MainTriMap {

    public static void main( String[] args ) {
        Map<Integer, CD> mapClePrimaireCD = new HashMap<Integer, CD>();

        mapClePrimaireCD.put( 1, new CD( "Les arcandiers", "7€", 7d ) );
        mapClePrimaireCD.put( 3, new CD( "Frank Zappa", "Tinseltown rebellion", 10.25d ) );
        mapClePrimaireCD.put( 5, new CD( "Frank Zappa", "Bongo Fury", 10.25d ) );
        mapClePrimaireCD.put( 4, new CD( "King Crimson", "red", 15.30d ) );
        mapClePrimaireCD.put( 2, new CD( "Joe Zawinul", "World tour", 12.15d ) );

        Set<Entry<Integer, CD>> setObjetsEntryCleValeurDeLaMap = mapClePrimaireCD.entrySet();

        // on peut aussi écrire Map.Entry au lieu de Entry direct
        Iterator<Entry<Integer, CD>> iteratorPourParcourirLeSetObjetsEntry = setObjetsEntryCleValeurDeLaMap.iterator();

        while ( iteratorPourParcourirLeSetObjetsEntry.hasNext() ) {
            Entry<Integer, CD> elementParcouru = iteratorPourParcourirLeSetObjetsEntry.next();
            System.out.println( "clé : " + elementParcouru.getKey() + " - valeur : " + elementParcouru.getValue() );
        }
    }

}
