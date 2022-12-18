package ma.ensias.springbackend.service;

import lombok.AllArgsConstructor;
import ma.ensias.springbackend.module.Cours;
import ma.ensias.springbackend.repository.CoursRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CoursService {
    private CoursRepository coursRepository ;

    public List<Cours> getAllCours(Long moduleId) {
        List<Cours> cours=new ArrayList<>();
        coursRepository.findByModuleId(moduleId).forEach(cours::add);
        return cours;
    }

    public Optional<Cours> getCours(Long id) {
        return coursRepository.findById(id);
    }

    public void ajouterCours(Cours cours) {
        coursRepository.save(cours);
    }

    public void modifierCours(Cours cours) {
        coursRepository.save(cours);
    }

    public void supprimerCours(Long id) {
        coursRepository.deleteById(id);
    }

}
