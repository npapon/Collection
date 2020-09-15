package enums;

public enum Jours {

    LUNDI( "lundi" ), MARDI( "mardi" ), MERCREDI( "mercredi" ), JEUDI( "jeudi" ), VENDREDI( "vendredi" ), SAMEDI(
            "samedi" ), DIMANCHE( "dimanche" );

    private String jour;

    Jours( String jour )

    {
        this.jour = jour;
    }

    public String toString() {
        return jour;
    }

}
