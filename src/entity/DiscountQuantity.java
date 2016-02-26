package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class DiscountQuantity extends DiscountType implements Serializable {
    
    int quantityForDiscount = 3;
    double discount = 0.2; //20% on all if quantity is 3 or more

    @Override
    public double calcPrice(double pricePerItem, int quantity) {
        return quantity >= quantityForDiscount ? pricePerItem * quantity * discount : 0;
    }
    
}
