package CreditCard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard {


    private String owner = null;
    private String number = null;
    private Double credit = null;
    private final String SYMBOL = "EZI";
    private final Double initialCredit = 3000.0;

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
        this.credit = initialCredit;
    }


    @Override
    public String toString() {
        return "owner: " + getOwner() + "\n" +
                "number: " + getNumber() + "\n" +
                "credit: " + getCredit() + getSYMBOL();
    }


    public Boolean pay(int cash) {

        Double currentCredit = getCredit() - cash;

        if(currentCredit >= 0) this.setCredit(currentCredit);

        return currentCredit >= 0;
    }
}
