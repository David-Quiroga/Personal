package producto.producto.demo.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    //!Create
    public Doctor save(Doctor entity)
    {
        return doctorRepository.save(entity);
    }

    //!findById
    public Doctor findById(long id)
    {
        return doctorRepository.findById(id).orElse(null);
    }

    //!Delete
    public void deleteById(long id)
    {
        doctorRepository.deleteById(id);
        {
            doctorRepository.deleteById(id);
        }
    }

    //!select all
    public List<Doctor> findAll()
    {
        return doctorRepository.findAll();
    }

    //!update by id
    public ResponseEntity<Doctor>updateById(long id, Doctor doctorActualizar)
    {
        try
        {
            Doctor doctorExistente = findById(id);
            if(doctorExistente == null)  return ResponseEntity.notFound().build();

            if(doctorActualizar.getName() != null) doctorExistente.setName(doctorActualizar.getName());
            if(doctorActualizar.getLicencia() != null) doctorExistente.setLicencia(doctorActualizar.getLicencia());

            Doctor DoctorGuardado = save(doctorExistente);
            return ResponseEntity.ok(DoctorGuardado);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
