package name.tsymbaliuk.msite.app.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import name.tsymbaliuk.msite.app.entity.Product;

@Repository
public interface ProductRepository 
	extends JpaRepository<Product,Long>{
	
	@Query(name="Product.findProductsByCategoryId",
			value="SELECT DISTINCT p FROM Product p JOIN FETCH  p.categories c WHERE c.id=?1")
	List<Product> findByCategoryId(Long categoryId);

	@Query(name="Product.findProductsByCategoryId",
			value="SELECT DISTINCT p FROM Product p JOIN FETCH  p.categories c")
	List<Product> findAllWithCategory();
}
