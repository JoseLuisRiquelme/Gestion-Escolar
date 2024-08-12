package cl.praxis.EscuelaRural.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumno")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", insertable = true,updatable = true)
    private Curso curso;
}
