package dev.samarth.productService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.samarth.productService.clients.fakeStoreClient;
import dev.samarth.productService.clients.fakeStoreProductDTO;
import dev.samarth.productService.dto.ProductDTO;
import dev.samarth.productService.models.Category;
import dev.samarth.productService.models.Product;
@Service
public class fakeStoreProductServiceImpl implements ProductService {
	
	private fakeStoreClient client;
	
	public fakeStoreProductServiceImpl(fakeStoreClient client) {
		super();
		this.client = client;
	}

	private Product convertToProductFromFakeStoreProductDTO(fakeStoreProductDTO productDto) {
		Product product = new Product();
		product.setId(productDto.getId());
		product.setDescription(productDto.getDescription());
		product.setImageURL(productDto.getImage());
		product.setPrice(productDto.getPrice());
		product.setTitle(productDto.getTitle());
		Category category = new Category();
		category.setName(productDto.getCategory());
		product.setCategory(category);
		
		return product;
	}

	@Override
	public Optional<Product> getSingleProduct(Long product_id) {
		
		Optional<fakeStoreProductDTO> productDto = client.getSingleProduct(product_id);
		
		if(productDto == null) {
			return Optional.empty();
		}
		
		
		return Optional.of(convertToProductFromFakeStoreProductDTO(productDto.get()));
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<fakeStoreProductDTO> list = client.getAllProducts();
		
		List<Product> products = new ArrayList<Product>();
		
		for(fakeStoreProductDTO Dto : list) {
			Product product = convertToProductFromFakeStoreProductDTO(Dto);
			products.add(product);
		}
		return products;
	}

	
	@Override
	public Product addNewProduct(ProductDTO productDto) {
		
		fakeStoreProductDTO productDTO = client.addNewProduct(productDto);
		
		Product product = convertToProductFromFakeStoreProductDTO(productDTO);
		
		return product;
	}

	@Override
	public Product updateProduct(long product_id, Product product) {
		
		fakeStoreProductDTO prodDto = client.updateProduct(product_id, product);
		
		Product product1 = convertToProductFromFakeStoreProductDTO(prodDto);
		return product1;
	}

	@Override
	public boolean deleteProduct(long product_id) {
		// TODO Auto-generated method stub
		return true;
	}

	
}
