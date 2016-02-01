package name.tsymbaliuk.msite.app.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="Category")
@ToString
@EqualsAndHashCode()
public class ProductCategory {

	private Long id;
	private String name;
	private Set<Product> products = new HashSet<Product>(0);

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
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Product> getProducts() {
		return this.products ;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
