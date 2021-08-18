import java.lang.Object;
public enum AsosDetails{
    EMAIL("pauloweita@gmail.com",0),
    PASSWORD("Pauloweita16*",1),
    CARDPAN("5399412279153816",2),
    CARDEXPIRYDATE("03/2025",3),
    CARDNAME("PAUL OWEI",4),
    CVV("292",5);
    private final String value;
    private final int ordinal;
    private AsosDetails(String value,int ordinal)
    {
        this.value = value;
        this.ordinal = ordinal;
    }
    public String getValue(){
        return this.value;
    }
    public int getOrdinal(){
        return this.ordinal;
    }
}