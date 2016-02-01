package name.tsymbaliuk.msite.app.data;

import org.springframework.data.jpa.repository.JpaRepository;

import name.tsymbaliuk.msite.app.entity.ProductCategory;

public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {

}
