package ma.ensias.springbackend.repository;

import ma.ensias.springbackend.module.Module;
import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository extends CrudRepository<Module , Long> {
}
