package producto.producto.demo.paciente;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
    @SuppressWarnings("null")
    List<Paciente> findAll();
}