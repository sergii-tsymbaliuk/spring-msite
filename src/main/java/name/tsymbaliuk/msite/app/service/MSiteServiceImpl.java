package name.tsymbaliuk.msite.app.service;

import name.tsymbaliuk.msite.app.data.CategoryRepository;
import name.tsymbaliuk.msite.app.data.ProductRepository;
import name.tsymbaliuk.msite.app.entity.Cart;
import name.tsymbaliuk.msite.app.entity.Product;
import name.tsymbaliuk.msite.app.entity.ProductCategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sergii_Tsymbaliuk on 2/4/2016.
 */
@Service
public class MSiteServiceImpl
    implements MSiteService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Inject
    public MSiteServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    /*
     *  Products
     */

    @Override
    public Collection<Product> findAllProducts() {
        return productRepository.findAllWithCategory();
    }

    @Override
    public Product findProductById(Long productId) {
        return productRepository.findOne(productId);
    }

    @Override
    public Collection<Product> findProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    /*
     * Categories
     */
    @Override
    public Collection<ProductCategory> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ProductCategory findCategoryById(Long categoryId) {
        return categoryRepository.getOne(categoryId);
    }

    @Transactional
    @Override
    public ProductCategory saveCategory(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }

    @Transactional
    @Override
    public void deleteCategory(ProductCategory productCategory) {
        categoryRepository.delete(productCategory);
    }

    @Override
    public Collection<Cart> findAllCarts() {
        return null;
    }

    @Override
    public Cart findCartById(Long categoryId) {
        return null;
    }

    @Override
    public Cart saveCart(Cart cart) {
        return null;
    }

    @Override
    public void deleteCart(Cart cart) {

    }





    /*
     * Cart
     */
}
