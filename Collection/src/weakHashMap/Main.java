package weakHashMap;

import java.util.WeakHashMap;

public class Main {

    public static void main( String[] args ) {
        WeakHashMap<MyKey, String> weakHashMap = new WeakHashMap<>();

        MyKey cle1 = new MyKey( 1 );
        MyKey cle2 = new MyKey( 2 );
        MyKey cle3 = new MyKey( 3 );
        weakHashMap.put( cle1, "Nicolas" );
        weakHashMap.put( cle2, "Valentine" );
        weakHashMap.put( cle3, "Leslie" );

        // on affiche la map
        System.out.println( weakHashMap );
        // {La cl� est 1=Nicolas, La cl� est 3=Leslie, La cl� est 2=Valentine}
        // on met une des valeurs de la map a null
        cle1 = null;
        // on passe la garbage collector qui d�truit les variables pas utilis�es
        // System.gc
        System.gc();
        // la valeur null est plus dans la map
        System.out.println( weakHashMap );
        // {La cl� est 3=Leslie, La cl� est 2=Valentine//}

        cle3 = null;
        System.gc();
        System.out.println( weakHashMap );
        // {La cl� est 2=Valentine}

    }

}
