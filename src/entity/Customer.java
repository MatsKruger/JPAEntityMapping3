package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private List<DiscountType> discountTypes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<DiscountType> getDiscountType() {
//        return discountTypes;
//    }
//
//    public void setDiscountType(DiscountType discountType) {
//        this.discountType = discountType;
//    }
    
    public double getPrice(double pricePerItem, int quantity) {
        
        double cheapest = pricePerItem * quantity;
        
        for (DiscountType discountType : discountTypes) {
            double price = discountType.calcPrice(pricePerItem, quantity);
            if (price < cheapest) cheapest = price;
        }
        
        return pricePerItem;
    }
    
    
    
}
