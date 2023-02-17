package {{ global_computed_inputs.base_package }}.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import {{ global_computed_inputs.base_package }}.dto.ProductDto;
import {{ global_computed_inputs.base_package }}.service.ProductService;
import {{ global_computed_inputs.base_package }}.utils.GeneralMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;

	@Transactional(rollbackFor = Exception.class) 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProductDto> save(@Valid @RequestBody ProductDto productRequest) {

		ProductDto productDto = productService.save(productRequest);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{idProduct}")
				.buildAndExpand(productDto.getIdProduct())
				.toUri();
		responseHeaders.setLocation(newURI);

		return new ResponseEntity<>(productDto, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductDto>> findAll() {
		List<ProductDto> products = productService.findAll();
		if(products.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/{idProduct}", method = RequestMethod.GET)
	public ResponseEntity<ProductDto> find(@PathVariable String idProduct) {
		return new ResponseEntity<>(productService.findById(idProduct), HttpStatus.OK);
	}

	@RequestMapping(value = "/{idProduct}", method = RequestMethod.PUT)
	public ResponseEntity<GeneralMessage> update(@PathVariable String idProduct, @Valid @RequestBody ProductDto productUpdate) {
		productService.update(idProduct, productUpdate);
		return new ResponseEntity<>(new GeneralMessage("Product updated successfully"), HttpStatus.OK);
	}

	@RequestMapping(value = "/{idProduct}", method = RequestMethod.DELETE)
	public ResponseEntity<GeneralMessage> delete(@PathVariable String idProduct) {
		productService.deleteById(idProduct);
		return new ResponseEntity<>(new GeneralMessage("Product deleted successfully"), HttpStatus.OK);
	}
		
	@RequestMapping(value = "/category/{idCategory}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDto>> getProductByCategory(@PathVariable String idCategory) {
		return new ResponseEntity<>(productService.getProductByCategoryId(idCategory), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/productIdentifier/{productIdentifier}", method = RequestMethod.GET)
	public ResponseEntity<ProductDto> findByProductIdentifier(@PathVariable String productIdentifier) {
		return new ResponseEntity<>(productService.findByProductIdentifier(productIdentifier), HttpStatus.OK);
	}

}
