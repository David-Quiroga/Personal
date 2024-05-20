package producto.producto.demo.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    //!Create
    @PostMapping(value = "doctor")
    public Doctor save(@RequestBody Doctor entity)
    {
        return doctorService.save(entity);
    }

    //!Select by id
    @GetMapping(value = "doctor/{id}")
    public Doctor findById(@PathVariable Long id)
    {
        return doctorService.findById(id);
    }

    //!update
    @PutMapping(value = "doctor")
    public Doctor Update(@RequestBody Doctor entity)
    {
        return doctorService.save(entity);
    }

    //!Delete
    @DeleteMapping(value = "doctor/{id}")
    public void deleteById(@PathVariable Long id)
    {
        doctorService.deleteById(id);
    }

    //!Select all
    @GetMapping(value = "doctor")
    public List<Doctor> findAll()
    {
        return doctorService.findAll();
    }

    //!Update by id
    @PutMapping(value = "doctor/{id}")
    public ResponseEntity<Doctor> updateById(@PathVariable Long id, @RequestBody Doctor entity)
    {
        return doctorService.updateById(id, entity);
    }
}
