import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainTri {

    public static void main( String[] args ) {

        Set<String> tree = new TreeSet();

        tree.add( "Nico" );
        tree.add( "Leslie" );
        tree.add( "Sasha" );
        tree.add( "Valentine" );

        Iterator iterateur = tree.iterator();

        while ( iterateur.hasNext() ) {
            System.out.println( iterateur.next() );

        }

        List<Double> desDoubles = new ArrayList<Double>();

        desDoubles.add( -10.2d );
        desDoubles.add( 8d );
        desDoubles.add( 1000.19d );
        desDoubles.add( -3.392d );
        Collections.sort( desDoubles );

        iterateur = desDoubles.iterator();

        while ( iterateur.hasNext() ) {
            System.out.println( iterateur.next() );
        }

        String[] tableauDbz = { "Vegeta", "Goku", "Buu", "Freezer" };
        Arrays.sort( tableauDbz );

        for ( String personnage : tableauDbz ) {
            System.out.println( personnage );
        }

    }

}
