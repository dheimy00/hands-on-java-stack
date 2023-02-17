package {{ global_computed_inputs.base_package }}.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import {{ global_computed_inputs.base_package }}.model.generic.BaseEntityAudit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Category")
public class Category extends BaseEntityAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "idCategory",updatable = false,unique = true,nullable = false)
	private String idCategory;
	
	@Column(name = "name")
	private String name;

}
