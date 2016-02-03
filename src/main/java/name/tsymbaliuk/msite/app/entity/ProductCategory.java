package name.tsymbaliuk.msite.app.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.*;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="Category")
@ToString
@EqualsAndHashCode()
public class ProductCategory {

	private Long id;
	private String name;
	private Collection<Product> products = new ArrayList<>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_category",
			joinColumns = {@JoinColumn(name = "CATEGORY_ID", nullable = false) },
			inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID", nullable = false) })
	public Collection<Product> getProducts() {
		return this.products ;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
}
