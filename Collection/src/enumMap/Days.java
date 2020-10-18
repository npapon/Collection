package enumMap;

public enum Days {

    MONDAY( "Lundi" ), TUESDAY( "mardi" ), WENESDAY( "mercredi" ), THURSDAY( "jeudi" ), FRIDAY( "vendredi" ), SATURDAY(
            "Samedi" ), DIMANCHE( "Sunday" );

    private String jourEnFrancais;

    Days( String jourEnFrancais ) {
        this.jourEnFrancais = jourEnFrancais;
    }

    public String toString() {

        return "On est " + jourEnFrancais;
    }

}
