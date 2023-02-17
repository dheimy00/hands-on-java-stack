package {{ global_computed_inputs.base_package }}.mappers;

import {{ global_computed_inputs.base_package }}.dto.ProductDto;
import {{ global_computed_inputs.base_package }}.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMappers {

    ProductMappers INSTANCE = Mappers.getMapper(ProductMappers.class);

    @Mapping(source = "product.category.idCategory", target = "idCategory")
    ProductDto entityToDto(Product product);

    List<ProductDto> entitysToDtos(List<Product> products);

    @Mapping(source = "productDto.idCategory", target = "category.idCategory")
    Product DtoToEntity(ProductDto productDto);


}
