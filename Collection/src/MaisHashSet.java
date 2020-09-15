import java.util.HashSet;
import java.util.Iterator;

public class MaisHashSet {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        HashSet<String> jeux = new HashSet<String>();

        jeux.add( "FFVII" );
        jeux.add( "Marion Bros" );

        jeux.add( "BioShock" );

        Iterator iterateur = jeux.iterator();

        while ( iterateur.hasNext() ) {

            System.out.println( iterateur.next() );
        }

    }

}
