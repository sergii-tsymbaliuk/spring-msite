package name.tsymbaliuk.msite.app.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
//@Getter
//@Setter
@ToString
@EqualsAndHashCode
public class Product {

	private Long id;
	private String name;
	private String description;
	private Collection<ProductCategory> categories = new ArrayList<>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public Long getId() {
		return id;
	}
	
	public static class Builder {
		private String name;
		private String description;
		
		public Builder name(String name){
			this.name = name;
			return this;
		}
		
		public Builder description(String description){
			this.description = description;
			return this;
		}
		
		public Product build(){
			Product product = new Product();
			product.name = this.name;
			product.description = this.description;
			
			return product;
		}
	}
	
	private Product() {
		super();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany( fetch = FetchType.EAGER, mappedBy = "products", cascade = CascadeType.ALL )
	public Collection<ProductCategory> getCategories() {
		return this.categories;
	}
	
	public void setCategories(Collection<ProductCategory> categories) {
		this.categories = categories;
	}

}
