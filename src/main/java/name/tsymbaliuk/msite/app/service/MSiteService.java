package name.tsymbaliuk.msite.app.service;

import name.tsymbaliuk.msite.app.entity.Cart;
import name.tsymbaliuk.msite.app.entity.Product;
import name.tsymbaliuk.msite.app.entity.ProductCategory;

import java.util.Collection;
import java.util.List;

/**
 * Created by Sergii_Tsymbaliuk on 2/4/2016.
 */
public interface MSiteService {
    /* products */

    /**
     * @return List of all products
     */
    Collection<Product> findAllProducts();

    /**
     * Get product by id
     * @param productId - Id of product
     * @return Product or Null if not found
     */
    Product findProductById(Long productId);

    /**
     * Return all product for specified category
     * @return
     */
    Collection<Product> findProductsByCategoryId(Long categoryId);

    /**
     * Saves product to repository
     */
    Product saveProduct(Product product);

    /**
     * Delete product from repository
     */
    void deleteProduct(Product product);

    /* Categories */

    /**
     *
     * @return collection of all categories
     */
    Collection<ProductCategory> findAllCategories();

    /**
     * Get the category from Repo by id
     * @param categoryId ID of category to get
     * @return Category of Null
     */
    ProductCategory findCategoryById(Long categoryId);

    /**
     * Saves category to repository
     */
    ProductCategory saveCategory(ProductCategory category);

    /**
     * Delete category to repository
     */
    void deleteCategory(ProductCategory category);

    /*
    * Carts
    */

    /**
     *
     * @return collection of all categories
     */
    Collection<Cart> findAllCarts();

    /**
     * Get the category from Repo by id
     * @param categoryId ID of category to get
     * @return Category of Null
     */
    Cart findCartById(Long categoryId);

    /**
     * Saves category to repository
     */
    Cart saveCart(Cart cart);

    /**
     * Delete category to repository
     */
    void deleteCart(Cart cart);

}
