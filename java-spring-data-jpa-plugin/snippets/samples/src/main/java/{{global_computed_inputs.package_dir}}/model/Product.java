package {{ global_computed_inputs.base_package }}.model;

import javax.persistence.*;

import {{ global_computed_inputs.base_package }}.model.generic.BaseEntityAudit;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product extends BaseEntityAudit {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "idProduct",updatable = false,unique = true,nullable = false)
	private String idProduct;

	@Column(name = "productIdentifier")
	private String productIdentifier;

	@Column(name = "name")
	private String name;

	@Column(name = "price" )
	private Double price;

	@Column(name = "description" )
	private String description;

	@ManyToOne
	@JoinColumn(name = "category_id" )
	private Category category;

}

