package name.tsymbaliuk.msite.app.data;

import org.springframework.data.jpa.repository.JpaRepository;

import name.tsymbaliuk.msite.app.entity.Product;

public interface ProductRepo 
	extends JpaRepository<Product,Long>{
}
