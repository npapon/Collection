import java.util.EnumSet;

import enums.Jours;

public class MainEnumSet {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        for ( Jours jour : Jours.values() ) {
            System.out.println( jour.toString() );
        }

        /*
         * lundi mardi mercredi jeudi vendredi samedi dimanche
         */

        // on créé une collection de type enum qui contient tous les éléménts de
        // Enum

        EnumSet<Jours> enumJours = EnumSet.allOf( Jours.class );

        System.out.println( enumJours );
        // [lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche]

        // créé une sous collection :

        EnumSet<Jours> sousEnumJours = enumJours.range( Jours.LUNDI, Jours.MERCREDI );
        System.out.println( sousEnumJours );
        // [lundi, mardi, mercredi]

        // crée une collection des valeurs manquantes de la collection
        EnumSet<Jours> complementDesousEnumJours = enumJours.complementOf( sousEnumJours );
        System.out.println( complementDesousEnumJours );

        // [jeudi, vendredi, samedi, dimanche]

    }

}
