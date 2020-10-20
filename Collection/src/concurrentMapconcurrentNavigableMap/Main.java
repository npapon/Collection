package concurrentMapconcurrentNavigableMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {

    public static void main( String[] args ) {
        ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();

        // Si la cl� sp�cifi�e en param�tre n'est pas d�j� pr�sente dans la
        // collection, le couple cl�/valeur sera ins�r� dans la collection.

        concurrentMap.putIfAbsent( 1, "Nicolas" );

        System.out.println( concurrentMap );
        // {1=Nicolas}

        String present = concurrentMap.putIfAbsent( 1, "Leslie" );
        System.out.print( present );
        // affiche Nicolas car d�j� pr�sent

        // on retire le couple 1,"Leslie" mais comme il existe pas ca renvoie
        // false
        boolean retraitReussi = concurrentMap.remove( 1, "Leslie" );
        System.out.println( retraitReussi );
        // true

        retraitReussi = concurrentMap.remove( 1, "Nicolas" );
        System.out.println( retraitReussi );

        concurrentMap.putIfAbsent( 2, "Sasha" );
        boolean remplacementReussi = concurrentMap.replace( 2, "Sasha", "Valentine" );
        System.out.println( remplacementReussi );
        // true
        System.out.println( concurrentMap );
        // {2=Valentine}
    }

}
