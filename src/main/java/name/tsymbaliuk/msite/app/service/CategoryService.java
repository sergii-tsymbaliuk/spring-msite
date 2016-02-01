package name.tsymbaliuk.msite.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import name.tsymbaliuk.msite.app.data.CategoryRepository;
import name.tsymbaliuk.msite.app.entity.ProductCategory;

@Service
public class CategoryService {
	@Inject
	CategoryRepository categoryRepository;

	@Transactional
	public <S extends ProductCategory> S save(S entity) {
		return categoryRepository.save(entity);
	}

	public List<ProductCategory> findAll() {
		return categoryRepository.findAll();
	}

	public List<ProductCategory> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	public Page<ProductCategory> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	public ProductCategory findOne(Long id) {
		return categoryRepository.findOne(id);
	}

	public List<ProductCategory> findAll(Iterable<Long> ids) {
		return categoryRepository.findAll(ids);
	}

	@Transactional
	public <S extends ProductCategory> List<S> save(Iterable<S> entities) {
		return categoryRepository.save(entities);
	}

	public boolean exists(Long id) {
		return categoryRepository.exists(id);
	}

	public void flush() {
		categoryRepository.flush();
	}

	@Transactional
	public <S extends ProductCategory> S saveAndFlush(S entity) {
		return categoryRepository.saveAndFlush(entity);
	}

	@Transactional
	public void deleteInBatch(Iterable<ProductCategory> entities) {
		categoryRepository.deleteInBatch(entities);
	}

	public long count() {
		return categoryRepository.count();
	}

	@Transactional
	public void deleteAllInBatch() {
		categoryRepository.deleteAllInBatch();
	}

	@Transactional
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

	public ProductCategory getOne(Long id) {
		return categoryRepository.getOne(id);
	}

	@Transactional
	public void delete(ProductCategory entity) {
		categoryRepository.delete(entity);
	}

	@Transactional
	public void delete(Iterable<? extends ProductCategory> entities) {
		categoryRepository.delete(entities);
	}

	@Transactional
	public void deleteAll() {
		categoryRepository.deleteAll();
	}
	
	
	
}
