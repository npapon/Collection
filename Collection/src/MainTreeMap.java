import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MainTreeMap {

    public static void main( String[] args ) {

        // SANS TRI (MAIS CA TRI DEJA PAR DEFAUT)

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put( 3, "trois" );
        map.put( 2, "deux" );
        map.put( 1, "un" );
        map.put( 4, "quatre" );

        Set<Entry<Integer, String>> set = map.entrySet();
        Iterator<Entry<Integer, String>> iterator = set.iterator();
        while ( iterator.hasNext() ) {
            Entry<Integer, String> elementPärcouru = iterator.next();
            System.out.println( elementPärcouru.getKey() + " - " + elementPärcouru.getValue() );
        }

        // AVEC TRI
        // la TreeMap prend la map non trié en objet
        Map<Integer, String> maptrie = new TreeMap<Integer, String>( map );

        Set<Entry<Integer, String>> set2 = map.entrySet();
        Iterator<Entry<Integer, String>> iterator2 = set.iterator();
        while ( iterator2.hasNext() ) {
            Entry<Integer, String> elementPärcouru = iterator2.next();
            System.out.println( elementPärcouru.getKey() + " - " + elementPärcouru.getValue() );
        }
    }

}
