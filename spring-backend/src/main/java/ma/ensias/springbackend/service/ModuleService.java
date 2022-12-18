package ma.ensias.springbackend.service;


import lombok.AllArgsConstructor;
import ma.ensias.springbackend.module.Module;
import ma.ensias.springbackend.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ModuleService {
    private ModuleRepository moduleRepository ;

    public List<Module> getAllModules() {

        List<Module> modules = new ArrayList<>() ;
        moduleRepository.findAll().forEach(modules::add);

        return modules ;
    }


    public Module getModule(Long id) {
        return moduleRepository.findById(id).orElse(null) ;
    }

    public Module addModule( Module module ) {
        return moduleRepository.save(module) ;
    }

    public void modifierModule(Long id, Module module) {
        moduleRepository.save(module) ;
    }

    public void supprimerModule(Long id) {
        moduleRepository.delete(moduleRepository.findById(id).orElse(null));
    }


}
