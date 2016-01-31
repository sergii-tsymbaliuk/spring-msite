package name.tsymbaliuk.msite.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import name.tsymbaliuk.msite.app.data.ProductRepository;
import name.tsymbaliuk.msite.app.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductRepository prodRepo;
	
	Product findOneById(Long id){
		return prodRepo.findOne(id);
	}

	public long count() {
		return prodRepo.count();
	}

	@Transactional
	public void delete(Iterable<? extends Product> arg0) {
		prodRepo.delete(arg0);
	}

	public void delete(Long arg0) {
		prodRepo.delete(arg0);
	}

	public void delete(Product arg0) {
		prodRepo.delete(arg0);
	}

	public void deleteAll() {
		prodRepo.deleteAll();
	}

	public void deleteAllInBatch() {
		prodRepo.deleteAllInBatch();
	}

	public void deleteInBatch(Iterable<Product> arg0) {
		prodRepo.deleteInBatch(arg0);
	}

	public boolean exists(Long arg0) {
		return prodRepo.exists(arg0);
	}

	public List<Product> findAll() {
		return prodRepo.findAll();
	}

	public List<Product> findAll(Iterable<Long> arg0) {
		return prodRepo.findAll(arg0);
	}

	public Page<Product> findAll(Pageable arg0) {
		return prodRepo.findAll(arg0);
	}

	public <S extends Product> S save(S entity) {
		return prodRepo.save(entity);
	}

	public <S extends Product> List<S> save(Iterable<S> entities) {
		return prodRepo.save(entities);
	}

	public List<Product> findAll(Sort arg0) {
		return prodRepo.findAll(arg0);
	}

	public Product findOne(Long arg0) {
		return prodRepo.findOne(arg0);
	}

	public Product getOne(Long arg0) {
		return prodRepo.getOne(arg0);
	}
	


}
