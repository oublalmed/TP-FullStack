package ma.ensias.springbackend.controller;

import ma.ensias.springbackend.module.Module;
import ma.ensias.springbackend.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModuleController {
    @Autowired
    private ModuleService moduleService ;


    @RequestMapping( value = "/modules")
    public List<Module> getModules() {
       return moduleService.getAllModules() ;
    }

    @RequestMapping("/modules/{id}")
    public Module getModule(@PathVariable(value = "id") Long id) {
        return moduleService.getModule(id) ;
    }

    @RequestMapping(value = "/modules" , method = RequestMethod.POST)
    public Module addModule(@RequestBody Module module) {
       return moduleService.addModule(module) ;
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/modules/{id}")
    public void modifierModule(@PathVariable(value = "id") Long id, @RequestBody Module module ) {
        moduleService.modifierModule(id , module);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/modules/{id}")
    public void supprimerModule(@PathVariable(value = "id") Long id) {
        moduleService.supprimerModule(id);
    }


}
