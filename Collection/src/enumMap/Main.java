package enumMap;

import java.util.EnumMap;

public class Main {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        // on va ajouter une définition à l'enum
        EnumMap<Days, String> enumMap = new EnumMap( Days.class );

        enumMap.put( Days.MONDAY, "Lundi c'est ravioli" );
        enumMap.put( Days.TUESDAY, "Mardi c'est clafouti" );
        enumMap.put( Days.WENESDAY, "Mercredi c'est spaguetti" );
        enumMap.put( Days.THURSDAY, "Jeudi c'est riz" );
        enumMap.put( Days.FRIDAY, "Vendredi c'est chili " );

        // la méthode values() d'une enum retourne tous les valeurs des enums
        for ( Days valeurEnum : Days.values() ) {

            // appelle la méthode toString
            System.out.println( valeurEnum );
            // affiche la value de la map pour chaque Key (ici un élément de la
            // map
            System.out.println( enumMap.get( valeurEnum ) );
        }

        /*
         * On est Lundi Lundi c'est ravioli On est mardi Mardi c'est clafouti On
         * est mercredi Mercredi c'est spaguetti On est jeudi Jeudi c'est riz On
         * est vendredi Vendredi c'est chili On est Samedi null On est Sunday
         * null
         * 
         */

    }

}
