package ma.enset.hopital.web;


import lombok.AllArgsConstructor;
import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller  // pour quil soit un springMVC
@AllArgsConstructor //on va faire injection via CONSTRUCTEUR parametre psq spring prefere ca au lieu dde autowired
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")   //pour faire appel a index "lorsque je tappe /index ca va returner une vue qui sappel patients.html"
    public String index(Model model,
                        @RequestParam(name="page",defaultValue = "0") int p,
                        @RequestParam(name="size",defaultValue = "8") int s,
                        @RequestParam(name="keyword",defaultValue = "") String kw){
        Page<Patient> pagePatient=patientRepository.findByNomContains(kw,PageRequest.of(p,s));//cette liste je vais la stocker dans model
        model.addAttribute("listPatients",pagePatient.getContent());
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("keyword",kw);
        return "patients";
    }

    @GetMapping("/delete")   //lorsque je vois /delete dans url cette methode va executer
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword; //une fois je supprime je redirege vers /index
    }
}
