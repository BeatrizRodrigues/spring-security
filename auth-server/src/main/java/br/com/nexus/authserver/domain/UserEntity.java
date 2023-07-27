package br.com.nexus.authserver.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_USER")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator="sequsers")
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME_USER")
    private String name;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD_USER")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusCadastros status;

    @Column(name = "CRIADO_EM", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "ALTERADO_EM")
    private LocalDateTime dataAtualizacao;

    public enum Tipo {
        ADMIN,
        CLIENT
    }

    public enum StatusCadastros {
        A,
        I
    }
}
