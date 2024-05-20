package producto.producto.demo.especialidad;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EspecialidadRepository  extends CrudRepository<Especialidad, Long>{
    @SuppressWarnings("null")
    List<Especialidad> findAll();
}
