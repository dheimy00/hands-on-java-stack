package {{ global_computed_inputs.base_package }}.infrastructure.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class Constants {

    public static final class Product{
        public static final String ID_PRODUCT = "id_product";
        public static final String PRODUCT_IDENTIFIER = "product_identifier";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String PRICE = "price";
    }

    public static final class Category{
        public static final String ID_CATEGORY = "id_category";
        public static final String NAME = "name";
    }

}
