package {{ global_computed_inputs.base_package }}.service.implementions;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import {{ global_computed_inputs.base_package }}.exceptions.errors.Errors;
import {{ global_computed_inputs.base_package }}.exceptions.requests.ApplicationException;
import {{ global_computed_inputs.base_package }}.mappers.CategoriaMappers;
import {{ global_computed_inputs.base_package }}.model.Category;
import {{ global_computed_inputs.base_package }}.dto.CategoryDto;
import {{ global_computed_inputs.base_package }}.repositroy.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import {{ global_computed_inputs.base_package }}.service.CategoryService;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoriaMappers categoriaMappers;

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoriaMappers.entitysToDtos(categories);
    }


    @Override
    public CategoryDto save(CategoryDto categoryDto) {

        Category categoryNome = categoryRepository.findByName(categoryDto.getName());
        if (categoryNome != null) {
            throw new ApplicationException(Errors.CATEGORY_ALREADY_EXISTS, Map.of("id", categoryDto.getName()));
        }

        categoryDto.setIdCategory(UUID.randomUUID().toString());
        Category category = categoriaMappers.DtoToEntity(categoryDto);
        category = categoryRepository.save(category);
        return categoriaMappers.entityToDto(category);
    }

    @Override
    public CategoryDto findById(String idCategory) {

        Category category = categoryRepository.findByIdCategory(idCategory)
                .orElseThrow(() -> new ApplicationException(Errors.CATEGORY_NOT_FOUND, Map.of("id", idCategory)));
        return categoriaMappers.entityToDto(category);
    }

    @Override
    public CategoryDto update(String idCategory, CategoryDto categoryDto) {

        Category category = categoryRepository.findByIdCategory(idCategory)
                .orElseThrow(() -> new ApplicationException(Errors.CATEGORY_NOT_FOUND, Map.of("id", idCategory)));

        category.setName(categoryDto.getName());

        return categoriaMappers.entityToDto(category);
    }

    @Override
    public void deleteById(String idCategory) {

        Category category = categoryRepository.findByIdCategory(idCategory)
                .orElseThrow(() -> new ApplicationException(Errors.CATEGORY_NOT_FOUND, Map.of("id", idCategory)));

        categoryRepository.delete(category);

    }

}
