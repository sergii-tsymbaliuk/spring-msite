package name.tsymbaliuk.msite.app.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import name.tsymbaliuk.msite.app.entity.Product;

@Repository
public interface ProductRepository 
	extends JpaRepository<Product,Long>{
	
	@Query(name="Product.findByCategoryId",value="SELECT p FROM Product p JOIN FETCH p.categories c where c.id=?1")
	List<Product> findByCategoryId(Long categoryId);
}
