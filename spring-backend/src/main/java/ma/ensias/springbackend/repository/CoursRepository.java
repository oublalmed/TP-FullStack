package ma.ensias.springbackend.repository;

import ma.ensias.springbackend.module.Cours;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursRepository extends CrudRepository<Cours , Long> {
    public List<Cours> findByModuleId(Long moduleId) ;
}
