package name.tsymbaliuk.msite.app.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Sergii_Tsymbaliuk on 2/4/2016.
 */
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany ()
    Collection<Product> products;


}
