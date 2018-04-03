package game.core;

public class Reference {

    private static String[] OFFICES = {
            "House",
            "Small Apartment",
            "Large Studio",
            "1 Floor Office",
            "2 Floor Office",
            "Office Building",
            "Office Complex"
    };

    public static String getOffice(int id) { return OFFICES[id]; }
}
