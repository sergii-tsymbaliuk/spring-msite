package name.tsymbaliuk.msite.app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import name.tsymbaliuk.msite.app.entity.Product;

@Repository
public interface ProductRepository 
	extends JpaRepository<Product,Long>{
}
