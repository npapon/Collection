package bean;

//implémenter Comparable ne sert que pour la methode Sort 
public class CD implements Comparable {
    private String auteur, titre;
    private double prix;

    public CD( String auteur, String titre, double prix ) {
        this.auteur = auteur;
        this.titre = titre;
        this.prix = prix;
    }

    public String toString() {

        return "CD [auteur=" + auteur + ", titre=" + titre + ", prix=" + prix
                + "]";
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public double getPrix() {
        return prix;
    }

    // Collections.sort prend en paramètre une liste d'objet Comparable
    // donc si on est pas sur un objet de type primitif (String ...), il faut
    // implémenter à l'objet qui se met dans liste l'interface Comparable
    // et redéfinir sa méthode compareTo pour dire sur quoi on compare l'objet
    // rappel : si compareTo() retourne un entier négatif, le paramètre est plus
    // petit si 0 c'est égal si négatif plus petit
    @Override
    public int compareTo( Object o ) {

        // on vérifie que l'objet qu'on compare à CD est bien de type CD
        if ( o.getClass().equals( CD.class ) ) {
            // Nous allons trier sur le nom d'artiste
            // On créé une instance CD avec l'objet passé en paramètre
            CD cd = (CD) o;
            // et on utilise la méthode compareTo qui marche avec les String
            // pour l'appliquer à l'attribut auteur de notre classe et de
            // l'objet comparé

            // si les auteurs sont les mêmes
            if ( this.auteur.compareTo( cd.getAuteur() ) == 0 ) {
                // on compare par titre
                return this.titre.compareTo( cd.titre );
            }

            return this.auteur.compareTo( cd.getAuteur() );

        }

        return -1;
    }

}