package dev.samarth.productService.clients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dev.samarth.productService.dto.ProductDTO;
import dev.samarth.productService.models.Product;
@Component
public class fakeStoreClient {
	private RestTemplateBuilder restTemplateBuilder;

	public fakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplateBuilder = restTemplateBuilder;
	}

	public Optional<fakeStoreProductDTO> getSingleProduct(Long product_id){
		
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		ResponseEntity<fakeStoreProductDTO> response = restTemplate.getForEntity(
				"https://fakestoreapi.com/products/{id}", 
				fakeStoreProductDTO.class, 
				product_id);
		
		fakeStoreProductDTO fakeStoreproductDto = response.getBody();
		
		if(fakeStoreproductDto == null) {
			return Optional.empty();
		}
		
		return Optional.ofNullable((fakeStoreproductDto));
	}
	
	public List<fakeStoreProductDTO> getAllProducts(){
		
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		ResponseEntity<fakeStoreProductDTO[]> list = restTemplate.getForEntity(
				"https://fakestoreapi.com/products", 
				fakeStoreProductDTO[].class);
		
		//List<fakeStoreProductDTO> answer = new ArrayList<>();
		
		return Arrays.asList(list.getBody());
	}
	
	public fakeStoreProductDTO addNewProduct(ProductDTO  productDto) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		ResponseEntity<fakeStoreProductDTO> response = restTemplate.postForEntity("https://fakestoreapi.com/products", 
				productDto, fakeStoreProductDTO.class);
		
		fakeStoreProductDTO productDTO = response.getBody();
		
		return productDTO;
	}
	
	public fakeStoreProductDTO updateProduct(long product_id, Product product) {
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
		
		return prodDto;
	}
	
	public boolean deleteProduct(long product_id) {
		return true;
	} 

}
