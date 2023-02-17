package {{ global_computed_inputs.base_package }}.repositroy;

import {{ global_computed_inputs.base_package }}.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {

	Optional<Category> findByIdCategory(String idCategory);

	Category findByName(String name);

}
