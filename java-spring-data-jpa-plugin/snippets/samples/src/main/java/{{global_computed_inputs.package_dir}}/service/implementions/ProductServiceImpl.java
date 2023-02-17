package {{ global_computed_inputs.base_package }}.service.implementions;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import {{ global_computed_inputs.base_package }}.exceptions.errors.Errors;
import {{ global_computed_inputs.base_package }}.exceptions.requests.ApplicationException;
import {{ global_computed_inputs.base_package }}.infrastructure.valiadtion.handler.ValidacaoesHandler;
import {{ global_computed_inputs.base_package }}.mappers.ProductMappers;
import {{ global_computed_inputs.base_package }}.model.Category;
import {{ global_computed_inputs.base_package }}.model.Product;
import {{ global_computed_inputs.base_package }}.dto.ProductDto;
import {{ global_computed_inputs.base_package }}.repositroy.CategoryRepository;
import {{ global_computed_inputs.base_package }}.repositroy.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import {{ global_computed_inputs.base_package }}.service.ProductService;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMappers productMappers;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ValidacaoesHandler validacaoesHandler;

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return productMappers.entitysToDtos(products.stream().collect(Collectors.toList()));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        validacaoesHandler.executarValidacao(productDto);

        Category category = categoryRepository.findByIdCategory(productDto.getIdCategory())
                .orElseThrow(() -> new ApplicationException(Errors.CATEGORY_NOT_FOUND, Map.of("id", productDto.getIdCategory())));

        productDto.setIdProduct(UUID.randomUUID().toString());
        Product product = productMappers.DtoToEntity(productDto);
        product.getCategory().setId(category.getId());
        product = productRepository.save(product);

        return productMappers.entityToDto(product);
    }

    @Override
    public ProductDto findById(String idProduct) {
        Product product = productRepository.findByIdProduct(idProduct)
                .orElseThrow(() -> new ApplicationException(Errors.PRODUCT_NOT_FOUND, Map.of("id", idProduct)));
        return productMappers.entityToDto(product);
    }

    @Override
    public ProductDto update(String idProduct, ProductDto productDto) {

        Product product = productRepository.findByIdProduct(idProduct)
                .orElseThrow(() -> new ApplicationException(Errors.PRODUCT_NOT_FOUND, Map.of("id", idProduct)));


        return productMappers.entityToDto(product);
    }

    @Override
    public void deleteById(String idProduct) {

        Product product = productRepository.findByIdProduct(idProduct)
                .orElseThrow(() -> new ApplicationException(Errors.PRODUCT_NOT_FOUND, Map.of("id", idProduct)));

        productRepository.delete(product);
    }

    @Override
    public List<ProductDto> getProductByCategoryId(String idCategory) {

        List<Product> products = productRepository.getProductByCategoryId(idCategory);
        if (products.isEmpty()) {
            throw new ApplicationException(Errors.PRODUCT_NOT_FOUND, Map.of("id", products.stream().map(s -> s.getIdProduct()).findFirst()));
        }

        return null;
    }

    @Override
    public ProductDto findByProductIdentifier(String productIdentifier) {

        Product product = productRepository.findByProductIdentifier(productIdentifier)
                .orElseThrow(() -> new ApplicationException(Errors.PRODUCT_NOT_FOUND, Map.of("id", productIdentifier)));
        return productMappers.entityToDto(product);
    }


}
