import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainList {

    public static void main( String[] args ) {

        ArrayList<String> listExemple = new ArrayList<String>();

        listExemple.add( "1" );
        listExemple.add( "2" );
        listExemple.add( "3" );
        listExemple.add( "4" );
        listExemple.add( "5" );

        System.out.println( "Parcours de la liste pour suppression �l�ment 3" );
        // On r�cup�re l'objet Iterator de la list qui va nous permettre de
        // faire plein de trucs sur elle

        int boucle = 0;

        Iterator iterateur = listExemple.iterator();
        // si on veut pas caster apres
        // Iterator<String> iterateur2 = listExemple.iterator();
        // hasNext() retourne true tant qu'on a des �l�ments � parcourir
        // et avec le while on parcoure le suivant � chaque fois
        // au d�but on a tout � parcourir :)

        // on va parcourir toute la liste et supprime le 3 au passage
        while ( iterateur.hasNext() ) {
            boucle++;

            // next() double usage : recupere l'�l�ment courant et fait avancer

            String elementDeLaListeParcouru = (String) iterateur.next();
            if ( elementDeLaListeParcouru.equals( "3" ) ) {
                iterateur.remove();

            }

        }

        System.out.println( "Parcours de la liste pour afficher les �l�ments avec iterator" );
        // on r�initialise l'it�rateur � 0

        iterateur = listExemple.iterator();

        // On reparcoure la liste pour voir que le 3 a disparu
        while ( iterateur.hasNext() ) {
            System.out.println( iterateur.next() );
        }

        System.out.println( "Parcours classique de la liste pour afficher les �l�ments avec boucle" );

        System.out.println( "Boucle 1" );

        for ( String element : listExemple ) {

            System.out.println( element );

        }

        System.out.println( "Boucle " );
        for ( int i = 0, c = listExemple.size(); i < c; i++ ) {

            System.out.println( listExemple.get( i ) );

        }

        System.out.println( "On m�lange la liste" );
        Collections.shuffle( listExemple );

        Iterator iterateur2 = listExemple.iterator();
        while ( iterateur2.hasNext() ) {
            System.out.println( iterateur2.next() );
        }

        System.out.println( "sous-liste" );

        List<String> subListExemple = listExemple.subList( 2, 4 );

        iterateur2 = subListExemple.iterator();
        while ( iterateur2.hasNext() ) {
            System.out.println( iterateur2.next() );
        }

        System.out.println( "list invers�e" );
        List<Character> listChar = new ArrayList<Character>();

        listChar.add( 'a' );
        listChar.add( 'b' );
        listChar.add( 'c' );
        listChar.add( 'd' );

        Iterator iterateur3 = listChar.iterator();
        while ( iterateur3.hasNext() ) {
            System.out.println( iterateur3.next() );
        }

        System.out.println( "--------" );
        Collections.reverse( listChar );
        iterateur3 = listChar.iterator();

        while ( iterateur3.hasNext() ) {
            System.out.println( iterateur3.next() );
        }

        System.out.println( "Changer une valeur de la liste pendant son parcours gr�ce � ListIterator" );

        ListIterator<Character> listIterateur = listChar.listIterator();

        System.out.println( "On change le b par un z" );

        while ( listIterateur.hasNext() ) {

            Character caractere = listIterateur.next();
            if ( caractere.equals( 'b' ) ) {
                listIterateur.set( 'z' );

            }

        }

        System.out.println( "On r�initie le listIterator et on reparcoure" );
        listIterateur = listChar.listIterator();

        while ( listIterateur.hasNext() ) {

            System.out.println( listIterateur.next() );

        }

    }

}
