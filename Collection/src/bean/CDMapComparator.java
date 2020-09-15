package bean;

import java.util.Comparator;
import java.util.Map;

public class CDMapComparator implements Comparator<Integer> {
    Map<Integer, CD> mapClePrimaireCD;

    // ON CREE UN CONSTRUCTEUR QUI VA PRENDRE UNE MAP EN PARAMETRE LA MAP QUE L
    // ON VA TRIER
    public CDMapComparator( Map<Integer, CD> mapClePrimaireCD ) {

        this.mapClePrimaireCD = mapClePrimaireCD;
    }

    // CETTE METHODE PERMET DE DIRE PAR QUOI ON COMPARE (ICI L AUTEUR)
    @Override
    public int compare( Integer cle1, Integer cle2 ) {

        CD cd1 = mapClePrimaireCD.get( cle1 );
        CD cd2 = mapClePrimaireCD.get( cle2 );

        if ( cd1.getAuteur().compareTo( cd2.getAuteur() ) == 0 ) {
            return cd1.getTitre().compareTo( cd2.getTitre() );

        } else {
            return cd1.getAuteur().compareTo( cd2.getAuteur() );
        }

    }

}
