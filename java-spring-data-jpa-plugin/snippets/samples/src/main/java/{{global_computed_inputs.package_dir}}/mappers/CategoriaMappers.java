package {{ global_computed_inputs.base_package }}.mappers;

import {{ global_computed_inputs.base_package }}.dto.CategoryDto;
import {{ global_computed_inputs.base_package }}.dto.ProductDto;
import {{ global_computed_inputs.base_package }}.model.Category;
import {{ global_computed_inputs.base_package }}.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMappers {

    CategoriaMappers INSTANCE = Mappers.getMapper(CategoriaMappers.class);

    CategoryDto entityToDto(Category category);

    List<CategoryDto> entitysToDtos(List<Category> Categories);

    Category DtoToEntity(CategoryDto categoryDto);


}
