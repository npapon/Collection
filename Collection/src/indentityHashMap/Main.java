package indentityHashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class Main {

    public static void main( String[] args ) {

        Integer integer1 = new Integer( 1 );
        Integer integer2 = new Integer( 1 );
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put( integer1, "Nicolas" );
        hashMap.put( integer2, "Leslie" );

        // cela affiche tout le temps Leslie !(Leslie a écrasé Nicolas)
        System.out.println( hashMap.get( integer1 ) );
        System.out.println( hashMap.get( integer2 ) );
        System.out.println( hashMap.get( 1 ) );

        /*
         * Leslie Leslie Leslie
         */

        // avec une IdentityHashMap les clés sont bien différentes d'un objet à
        // l'autre
        IdentityHashMap<Integer, String> indentityHashMap = new IdentityHashMap<Integer, String>();

        indentityHashMap.put( integer1, "Nicolas" );
        indentityHashMap.put( integer2, "Leslie" );

        System.out.println( indentityHashMap.get( integer1 ) );
        System.out.println( indentityHashMap.get( integer2 ) );
        System.out.println( indentityHashMap.get( 1 ) );
        /*
         * Nicolas Leslie null
         */
    }

}
