import java.util.NavigableSet;
import java.util.TreeSet;

public class MainSet {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        TreeSet<Double> set = new TreeSet<Double>();
        set.add( -10.2d );
        set.add( 3.2d );
        set.add( -2000.9d );
        set.add( 1000.22222d );

        System.out.println( set );

        // [-2000.9, -10.2, 3.2, 1000.22222]

        // TreeSet.ceilling(valeur) ramene la prochaine valeur >= que
        // celle en paramètre
        System.out.println( set.ceiling( 3.2d ) );
        // 3.2

        // TreeSet.higher(valeur) ramene la prochaine valeur > que
        // celle en paramètre

        System.out.println( set.higher( 3.2d ) );
        // 1000.22222

        // on créé une sous liste avec le premier élement exclu et le second
        // inclu
        NavigableSet<Double> sousListe = set.subSet( -2000.9d, false, 1000.22222d, true );
        System.out.println( sousListe );

        // [-10.2, 3.2, 1000.22222]

        // retire le plus petit élément

        sousListe.pollFirst();

        System.out.println( sousListe );
        // [3.2, 1000.22222]

        // retire le plus grand élément

        sousListe.pollLast();

        System.out.println( sousListe );

        // [3.2]
    }

}
