package com.lead.catalagofilmes.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn
    private Idioma idiomas;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String nome;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String tag;

}

