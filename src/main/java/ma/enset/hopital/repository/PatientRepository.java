package ma.enset.hopital.repository;

import ma.enset.hopital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//ca c spring data
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Page<Patient> findByNomContains(String keyword, Pageable pageable);//psq cette methode return une page on doit ajouter en parametre Pagebale

   // @Query("select p from Patient p where p.nom like :x") **** C LA 2EME METHODE***
   // Page<Patient> chercher(@Param("x") String keyword);
}
