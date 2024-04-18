package ma.enset.hopital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data    //getter et setter de lombok
@NoArgsConstructor @AllArgsConstructor @Builder


public class Patient {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY  )
        private Long id;

        private String nom;

        @Temporal(TemporalType.DATE)    // cad je veux garder dans BD que jrs mois et annee
        private Date dateNaissance;
        private boolean malade;
        private int score;

}
