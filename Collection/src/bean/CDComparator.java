package bean;

import java.util.Comparator;

public class CDComparator implements Comparator {

    @Override
    public int compare( Object o1, Object o2 ) {
        CD cd1 = (CD) o1;
        CD cd2 = (CD) o2;
        // il faut mettre le primitif Double et non double pour utiliser
        // compareTo
        Double prixCd1 = (Double) cd1.getPrix();
        Double prixCd2 = (Double) cd2.getPrix();
        // TODO Auto-generated method stub
        int result = prixCd1.compareTo( prixCd2 );

        if ( result == 0 ) {
            return cd1.compareTo( cd2 );
        }
        return result;
    }

}
