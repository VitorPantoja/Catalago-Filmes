package com.lead.catalagofilmes.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String titulo;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String sinopse;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String imagem;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String dataDelançamento;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String duração;

    @JoinColumn
    @ManyToOne
    private Idioma idiomas;

    @ManyToOne
    @JoinColumn
    private Categoria categoria;

}
