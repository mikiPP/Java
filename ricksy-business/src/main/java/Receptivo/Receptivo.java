package Receptivo;

import CreditCard.CreditCard;
import GuestDispatcher.GuestDispacher;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Receptivo {

    List<GuestDispacher> orders = new ArrayList<>();


    public void registra (GuestDispacher order) {
        this.getOrders().add(order);
    }

    public void dispatch (CreditCard creditCard) {

//        for (GuestDispacher order : this.getOrders()) {
//            order.dispatch(creditCard);
//        }

        getOrders()
                .forEach(order -> order.dispatch(creditCard));
    }
}
