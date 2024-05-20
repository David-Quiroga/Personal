package producto.producto.demo.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    //! Create
    public Paciente save(Paciente entity)
    {
        return pacienteRepository.save(entity);
    }

    //!findById
    public Paciente findById(long id)
    {
        return pacienteRepository.findById(id).orElse(null);
    }

    //! Delete
    public void deleteById(long id)
    {
        pacienteRepository.deleteById(id);
        {
            pacienteRepository.deleteById(id);
        }
    }

    //! Select All
    public List<Paciente> findAll()
    {
        return pacienteRepository.findAll();
    }

    //!update by id
    public ResponseEntity<Paciente>updateById(long id, Paciente pacienteActualizar)
    {
        try
        {
            Paciente pacienteExistente = findById(id);
            if (pacienteExistente == null) return ResponseEntity.notFound().build();

            if (pacienteActualizar.getName() != null) pacienteExistente.setName(pacienteActualizar.getName());
            
            if (pacienteActualizar.getEmail() != null) pacienteExistente.setEmail(pacienteActualizar.getEmail());
            
            Paciente PacienteGuardado = save(pacienteExistente);
            return ResponseEntity.ok(PacienteGuardado);
            
        } catch(Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
