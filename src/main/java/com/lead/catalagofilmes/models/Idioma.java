package com.lead.catalagofilmes.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String nome;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String tag;

}
