package UfosPark;

import CreditCard.CreditCard;
import GuestDispatcher.GuestDispacher;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
@Setter
public class UfosPark implements GuestDispacher {

    private Map<String, CreditCard> flota = new HashMap<String, CreditCard>();
    private final Double FEE = 500.0;


    public void add(String id) {
        getFlota().put(id, null);
    }


    @Override
    public void dispatch(CreditCard creditCard) {

        if (getFlota().containsValue(creditCard) || !getFlota().containsValue(null)) return;

        Double creditoRestante = creditCard.getCredit() - getFEE();

        if (creditoRestante >= 0) {
            creditCard.setCredit(creditoRestante);
            for (Map.Entry<String, CreditCard> entry : getFlota().entrySet()) {
                if (entry.getValue() == null) {
                    getFlota().put(entry.getKey(), creditCard);
                    return;
                }
            }
        } else {
            return;
        }
    }

    public String getUfoOf(String owner) {

//        for(Map.Entry<String, CreditCard> entry : getFlota().entrySet()) {
//            if( entry.getValue() != null && owner.equals(entry.getValue().getNumber())) {
//                return entry.getKey();
//            } else { ; }
//        }
//        return null;
//    }
        try {
            return getFlota()
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() != null && owner.equals(entry.getValue().getNumber()))
                    .findFirst()
                    .get()
                    .getKey();

        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return this.getFlota().keySet().toString();
    }

}
