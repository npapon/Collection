package bean;

//impl�menter Comparable ne sert que pour la methode Sort 
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

    // Collections.sort prend en param�tre une liste d'objet Comparable
    // donc si on est pas sur un objet de type primitif (String ...), il faut
    // impl�menter � l'objet qui se met dans liste l'interface Comparable
    // et red�finir sa m�thode compareTo pour dire sur quoi on compare l'objet
    // rappel : si compareTo() retourne un entier n�gatif, le param�tre est plus
    // petit si 0 c'est �gal si n�gatif plus petit
    @Override
    public int compareTo( Object o ) {

        // on v�rifie que l'objet qu'on compare � CD est bien de type CD
        if ( o.getClass().equals( CD.class ) ) {
            // Nous allons trier sur le nom d'artiste
            // On cr�� une instance CD avec l'objet pass� en param�tre
            CD cd = (CD) o;
            // et on utilise la m�thode compareTo qui marche avec les String
            // pour l'appliquer � l'attribut auteur de notre classe et de
            // l'objet compar�

            // si les auteurs sont les m�mes
            if ( this.auteur.compareTo( cd.getAuteur() ) == 0 ) {
                // on compare par titre
                return this.titre.compareTo( cd.titre );
            }

            return this.auteur.compareTo( cd.getAuteur() );

        }

        return -1;
    }

}