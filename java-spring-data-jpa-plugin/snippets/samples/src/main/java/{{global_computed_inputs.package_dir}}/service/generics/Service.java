package {{ global_computed_inputs.base_package }}.service.generics;

import java.util.List;

public interface Service <DTO,T>{

    List<DTO> findAll();
    DTO save(DTO dto);
    DTO update(T id,DTO dto);
    DTO findById(T id);
    void deleteById(T id);


}
