import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainMap {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        // CREATION DE LA COLLECTION

        Map<Integer, String> classementMap = new HashMap();

        classementMap.put( 1, "Goku" );
        classementMap.put( 2, "Vegeta" );
        classementMap.put( 3, "Picolo" );
        classementMap.put( 4, "Krilin" );

        // AFFICHAGE D UN ELEMENT DE LA COLLECTION

        System.out.println( "Afficher un valeur d'un élément de la liste avec sa key" );
        System.out.println( classementMap.get( 1 ) );
        // affiche Goku

        // On créé une collection de type set avec la méthode keySet de la map
        // cette collection de type Set contient toutes les key de la map

        // PARCOURIR UNE COLLECTION AVEC KEYSET()

        System.out.println(
                "Création d'une collection de type Set qui contient toutes les key de la map avec la méthode keySet de la map (qui renvoie cette collection Set)" );

        Set<Integer> collectionSetDesKeysDeLaMap = classementMap.keySet();

        // On va parcourir la collection Set avec un iterator (on aura pu
        // prendre une boucle)

        Iterator<Integer> IteratorcollectionSetDesKeysDeLaMap = collectionSetDesKeysDeLaMap.iterator();

        while ( IteratorcollectionSetDesKeysDeLaMap.hasNext() )

        {
            // affiche la valeur de la collection et passe au suivant : 2 en 2
            int cle = IteratorcollectionSetDesKeysDeLaMap.next();
            System.out.println( "Clé : " + cle + " - Valeur : " + classementMap.get( cle ) );
        }

        // PARCOURIR UNE COLLECTION AVEC ENTRYSET()

        // entrySet() retourne une collection de type Set<Entry<K, V>> avec
        // Entry
        // objet qui contiendra tous les couples clé - valeur de notre Map

        System.out.println(
                "Création d'une collection de type Set<Entry<K, V>  avec Entryobjet qui contiendra tous les couples clé - valeur de notre Map" );

        Set<Entry<Integer, String>> collectionSetDeObjetsEntry = classementMap.entrySet();

        // on créé un iterateur pour parcourir la boucle

        Iterator<Entry<Integer, String>> IteratorCollectionEntry = collectionSetDeObjetsEntry.iterator();

        while ( IteratorCollectionEntry.hasNext() ) {
            Entry<Integer, String> objetEntryCoupleCleValeur = IteratorCollectionEntry.next();
            System.out.println(
                    "Clé : " + objetEntryCoupleCleValeur.getKey() + " Valeur : " + objetEntryCoupleCleValeur.getValue() );

        }

        // PARCOURIR UNE COLLECTION AVEC values()
        // la méthode values() retourne ce type d'objet Collection<String>,
        // c'est-à-dire la liste de nos valeurs.
        // c'est le répondant de keySet() qui lui retourne les clés

        System.out.println(
                "Création d'une collection de type Collection<String>  avec String qui contiendra toutes les valeurs de notre Map" );

        Collection<String> collectionSetValeurDeLaMap = classementMap.values();
        Iterator collectionSetValeurDeLaMapIterator = collectionSetValeurDeLaMap.iterator();

        while ( collectionSetValeurDeLaMapIterator.hasNext() ) {
            String valeurSet = (String) collectionSetValeurDeLaMapIterator.next();
            System.out.println( "Valeur " + valeurSet );
        }

    }

}
