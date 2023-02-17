package {{ global_computed_inputs.base_package }}.service;


import {{ global_computed_inputs.base_package }}.dto.CategoryDto;
import {{ global_computed_inputs.base_package }}.service.generics.Service;

import java.util.List;

public interface CategoryService extends Service<CategoryDto,String> {

	List<CategoryDto> findAll();

	CategoryDto save(CategoryDto categoryDto);

	CategoryDto findById(String idCategory);

	CategoryDto update(String idCategory,CategoryDto categoryDto);

	void deleteById(String idCategory);
	


}
