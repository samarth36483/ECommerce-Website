package dev.samarth.productService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import dev.samarth.productService.dto.ProductDTO;
import dev.samarth.productService.dto.fakeStoreProductDTO;
import dev.samarth.productService.models.Category;
import dev.samarth.productService.models.Product;
@Service
public class fakeStoreProductServiceImpl implements ProductService {
	private RestTemplateBuilder restTemplateBuilder;

	public fakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplateBuilder = restTemplateBuilder;
	}
	
	// this is a low level method of RestTemplate.class that we have configured manually
//	private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
//			Class<T> responseType, Object... uriVariables) throws RestClientException {
//		//RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
//		
//		RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
//
//		RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
//		ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
//		return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
//	}
	
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
	public Product getSingleProduct(Long product_id) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<fakeStoreProductDTO> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", 
				fakeStoreProductDTO.class, product_id);
		fakeStoreProductDTO productDto = response.getBody();
		Product product = convertToProductFromFakeStoreProductDTO(productDto);
		
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<fakeStoreProductDTO[]> list = restTemplate.getForEntity("https://fakestoreapi.com/products", 
				fakeStoreProductDTO[].class);
		List<Product> products = new ArrayList<Product>();
		for(fakeStoreProductDTO Dto : list.getBody()) {
			Product product = convertToProductFromFakeStoreProductDTO(Dto);
			products.add(product);
		}
		return products;
	}

	
	@Override
	public Product addNewProduct(ProductDTO productDto) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<fakeStoreProductDTO> response = restTemplate.postForEntity("https://fakestoreapi.com/products", 
				productDto, fakeStoreProductDTO.class);
		
		fakeStoreProductDTO productDTO = response.getBody();
		Product product = convertToProductFromFakeStoreProductDTO(productDTO);
		
		return product;
	}

	@Override
	public Product updateProduct(long product_id, Product product) {
		RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
		fakeStoreProductDTO FakeStoreproductDto = new fakeStoreProductDTO();
		FakeStoreproductDto.setCategory(product.getCategory().getName());
		FakeStoreproductDto.setDescription(product.getDescription());
		FakeStoreproductDto.setImage(product.getImageURL());
		FakeStoreproductDto.setPrice(product.getPrice());
		FakeStoreproductDto.setTitle(product.getTitle());
		
		fakeStoreProductDTO prodDto = restTemplate.patchForObject("https://fakestoreapi.com/products/{id}", 
				FakeStoreproductDto, 
				fakeStoreProductDTO.class, 
				product_id);
		
//		ResponseEntity<fakeStoreProductDTO> response = requestForEntity(HttpMethod.PATCH, "https://fakestoreapi.com/products/7", 
//				productDto, fakeStoreProductDTO.class, product_id);
		
		Product product1 = convertToProductFromFakeStoreProductDTO(prodDto);
		return product1;
	}

	@Override
	public boolean deleteProduct(long product_id) {
		// TODO Auto-generated method stub
		return true;
	}

	
}
