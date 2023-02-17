package {{ global_computed_inputs.base_package }}.service;


import {{ global_computed_inputs.base_package }}.dto.ProductDto;
import {{ global_computed_inputs.base_package }}.service.generics.Service;

import java.util.List;

public interface ProductService extends Service<ProductDto, String> {

	List<ProductDto> findAll();

	ProductDto save(ProductDto productDto);

	ProductDto findById(String idProduct);

	ProductDto update(String idProduct,ProductDto productDto);

	void deleteById(String idProduct);

	List<ProductDto> getProductByCategoryId(String idCategory);

	ProductDto findByProductIdentifier(String idProduct);
}
