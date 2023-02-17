package {{ global_computed_inputs.base_package }}.repositroy;

import java.util.List;
import java.util.Optional;

import {{ global_computed_inputs.base_package }}.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	
	@Query(value = "SELECT p.name,p.price,p.idProduct,p.description "
			+ "FORM product p "
			+ "JOIN category c ON p.id_category = c.id "
			+ "WHERE c.idCategory = :idCategory ",nativeQuery = true)
	List<Product> getProductByCategoryId(@Param("idCategory") String idCategory);
	
	Optional<Product> findByIdProduct(String idProduct);

	Optional<Product>  findByProductIdentifier(String productIdentifier);
	
	

	
}
