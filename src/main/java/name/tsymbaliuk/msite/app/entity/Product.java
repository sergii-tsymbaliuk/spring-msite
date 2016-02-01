package name.tsymbaliuk.msite.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.ManyToMany;

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
	private Set<ProductCategory> categories = new HashSet<ProductCategory>(0);

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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	@ManyToMany(fetch = FetchType.EAGER/*, cascade = CascadeType.ALL*/)
	@JoinTable(name = "product_category",
		joinColumns = {@JoinColumn(name = "PRODUCT_ID", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false) })
	public Set<ProductCategory> getCategories() {
		return this.categories;
	}
	
	public void setCategories(Set<ProductCategory> categories) {
		this.categories = categories;
	}

}
