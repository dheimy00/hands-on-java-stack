package {{ global_computed_inputs.base_package }}.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import {{ global_computed_inputs.base_package }}.dto.CategoryDto;
import {{ global_computed_inputs.base_package }}.service.CategoryService;
import {{ global_computed_inputs.base_package }}.utils.GeneralMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@RequestMapping("/api/products/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CategoryDto> save(@Valid @RequestBody CategoryDto categoryRequest) {
        log.trace("Create category {}", categoryRequest);
        CategoryDto categorySave = categoryService.save(categoryRequest);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCategory}").buildAndExpand(categorySave.getIdCategory()).toUri();
        responseHeaders.setLocation(newURI);

        return new ResponseEntity<>(categorySave, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idCategory}", method = RequestMethod.GET)
    public ResponseEntity<CategoryDto> find(@PathVariable String idCategory) {
        return new ResponseEntity<>(categoryService.findById(idCategory), HttpStatus.OK);
    }

    @RequestMapping(value = "/{idCategory}", method = RequestMethod.PUT)
    public ResponseEntity<GeneralMessage> update(@PathVariable String idCategory, @Valid @RequestBody CategoryDto categoryUpdate) {
        categoryService.update(idCategory, categoryUpdate);
        return new ResponseEntity<>(new GeneralMessage("Category updated successfully"), HttpStatus.OK);
    }

    @RequestMapping(value = "/{idCategory}", method = RequestMethod.DELETE)
    public ResponseEntity<GeneralMessage> delete(@PathVariable String idCategory) {
        categoryService.deleteById(idCategory);
        return new ResponseEntity<>(new GeneralMessage("Category deleted successfully"), HttpStatus.OK);
    }


}
