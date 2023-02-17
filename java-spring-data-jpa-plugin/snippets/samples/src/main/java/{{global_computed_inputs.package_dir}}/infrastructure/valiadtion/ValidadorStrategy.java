package {{ global_computed_inputs.base_package }}.infrastructure.valiadtion;

public interface ValidadorStrategy <T> {

    void executarValidacao(T value);
}
