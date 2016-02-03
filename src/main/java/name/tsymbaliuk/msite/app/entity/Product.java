package name.tsymbaliuk.msite.app.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

	@ManyToMany( fetch = FetchType.EAGER, mappedBy = "products", cascade = CascadeType.ALL)
	public Collection<ProductCategory> getCategories() {
		return this.categories;
	}
	
	public void setCategories(Collection<ProductCategory> categories) {
		this.categories = categories;
	}

}
