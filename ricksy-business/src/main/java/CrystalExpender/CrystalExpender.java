package CrystalExpender;

import CreditCard.CreditCard;
import GuestDispatcher.GuestDispacher;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrystalExpender  implements GuestDispacher {

    private Integer stock = null;
    private Integer itemCost = null;


    public CrystalExpender (Integer stock, Integer itemCost) {
        this.stock = stock;
        this.itemCost =  itemCost;
    }

    @Override
    public void dispatch(CreditCard creditCard) {

        Double currentCredit = creditCard.getCredit() - getItemCost();

        if (currentCredit >= 0 && getStock() > 0) {
            setStock(getStock() -1);
            creditCard.setCredit(currentCredit);
        }
    }



    @Override
    public String toString () {
        return "stock: " + getStock() + "\n" +
                "cost: " + getItemCost();
    }
}
