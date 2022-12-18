package ma.ensias.springbackend.controller;

import lombok.AllArgsConstructor;
import ma.ensias.springbackend.module.Cours;
import ma.ensias.springbackend.module.Module;
import ma.ensias.springbackend.service.CoursService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CoursController {
    private CoursService coursService ;

    @RequestMapping("/modules/{id}/cours")
    public List<Cours> getAllCours(@PathVariable Long id){
        return coursService.getAllCours(id);
    }

    @RequestMapping("/modules/{moduleId}/cours/{id}")
    public Optional<Cours> getCours(@PathVariable Long id){
        return coursService.getCours(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/modules/{moduleId}/cours")
    public void ajouterCours(@RequestBody Cours cours, @PathVariable Long moduleId) {
        cours.setModule(new Module(moduleId,"",""));
        coursService.ajouterCours(cours);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/modules/{moduleId}/cours/{id}")
    public void modifierCours(@RequestBody Cours cours, @PathVariable Long moduleId,
                              @PathVariable Integer id) {
        cours.setModule(new Module(moduleId,"",""));
        coursService.modifierCours(cours);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/modules/{moduleId}/cours/{id}")
    public void supprimerCours(@PathVariable Long id) {
        coursService.supprimerCours(id);
    }

}
