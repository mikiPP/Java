package RickMenu;

import CreditCard.CreditCard;
import GuestDispatcher.GuestDispacher;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RickMenu implements GuestDispacher {

    private Integer stock = null;
    private Double itemCost = null;
    private List<CreditCard> buyers = new ArrayList<CreditCard>();

    public RickMenu (Integer stock, Double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }


    @Override
    public void dispatch(CreditCard creditCard) {

        Double credit = creditCard.getCredit() - getItemCost();

        if (credit >= 0 && getStock() > 0) {
                setStock(getStock() -1);
                creditCard.setCredit(credit);
                this.getBuyers().add(creditCard);
        }
    }

    public Integer getNumberOfBuyers () {
        return getBuyers().size();
    }

    public void getBuyersNames () {
         getBuyers().forEach(buyer -> System.out.println(buyer.getOwner()));
    }

    public void displayBuyers() {
        getBuyers()
                .forEach( buyer -> System.out.println(buyer));
    }
}
