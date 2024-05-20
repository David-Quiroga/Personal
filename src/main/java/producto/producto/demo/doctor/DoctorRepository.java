package producto.producto.demo.doctor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository  extends CrudRepository<Doctor, Long>{
    @SuppressWarnings("null")
    List<Doctor> findAll();
}
