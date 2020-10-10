package delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MyObject implements Delayed {

    private String nom;
    private long   heureAuMomentDeLinitialisationDeLObjet, delaiAvantLiberation;

    // ON CREER DES OBJETS AVEC EN NOM nom
    // QUI NE SERONT ACCESSIBLES QU APRES UN DELAI delaiAvantLiberation
    public MyObject( String nom, long delaiAvantLiberationDeLObjet ) {
        this.nom = nom;
        this.heureAuMomentDeLinitialisationDeLObjet = System.currentTimeMillis();
        this.delaiAvantLiberation = delaiAvantLiberationDeLObjet;

    }

    // GETDELAY PERMET DE SAVOIR SI LE DELAI AVANT LIBERATION EST EXPIRE
    // SI IL RESTE DU DELAI, LA METHODE RETOURNE CE DELAI
    // SI LE DELAI EST ECOULE CA RETOURNE 0
    // LE DELAI RESTANT EST RESTANT EST RENVOYE DANS L UNITE DE TEMPS MIS EN
    // PARAMETRE (TIMEUNIT UNIT)

    @Override
    public long getDelay( TimeUnit unit ) {

        // SI ON A UN OBJET AVEC UN DELAY DE 500
        // LE TEMPS RESTANT AVANT LA LIBERATION EST :
        // 500 ( this.delaiAvantLiberation )
        // moins le temps qu'il s'est écoulé depuis l'instanciation
        // c'est à dire l'heure actuel (System.currentTimeMillis()) - l'heure
        // qu'il était au moment ou on a instancié l'objet
        // le tout donnée en le tout calculé en milisecondes que l'on convertit
        // en l'unité TimeUnit passé en paramétre de la méthodexw
        return unit.convert( this.delaiAvantLiberation - ( System.currentTimeMillis() - heureAuMomentDeLinitialisationDeLObjet ),
                TimeUnit.MILLISECONDS );
    }

    // cette méthode permet definir comment comparer les objets delay de cette
    // classe entre eux pour savoir qui on libére en premier
    @Override
    public int compareTo( Delayed objetDelayAcomparer ) {
        // si l'objet à comparer est le meme et bien le delai est égal logique
        // on va juste comparer les délais restant entre eux
        if ( objetDelayAcomparer == this ) {
            return 0;
        } else {
            long differenceDelaiEntre2ObjetsDelayed = ( this.getDelay( TimeUnit.MILLISECONDS )
                    - objetDelayAcomparer.getDelay( TimeUnit.MILLISECONDS ) );
            return ( ( differenceDelaiEntre2ObjetsDelayed == 0 ) ? 0 : ( ( differenceDelaiEntre2ObjetsDelayed < 0 ) ? -1 : 1 ) );
        }

    }

    // ON REDEFINI TOSTRING CAR COMME CELA QUAND ON APPELLE
    // system.out.println(myObject) ca affiche le nom
    public String toString() {
        return this.nom;
    }

}
