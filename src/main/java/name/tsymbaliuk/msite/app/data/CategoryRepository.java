package name.tsymbaliuk.msite.app.data;

import org.springframework.data.jpa.repository.JpaRepository;

import name.tsymbaliuk.msite.app.entity.ProductCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {

}
