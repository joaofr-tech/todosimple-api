package com.joaofrancisco.todosimple.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity // Criar uma tabela no banco de dados dessa classe
@Table(name = User.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {
    public interface CreateUser {}
    public interface UpdateUser {}

    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera os id pra gente, o strategy é a forma como esse id sera gerado
    @Column(name = "id", unique = true) // Vai ser uma coluna na tabela user, alem disso esse atributo precisa ser unico
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true) // Coloco o nome da coluna e outras propriedades, como n poder ser null
    @NotNull (groups = CreateUser.class)
    @NotEmpty (groups = CreateUser.class)
    @Size (groups = CreateUser.class, min = 2, max = 100)
    // Uma boa pratica é nao deixar o usuario alterar o identificador dele, que nesse caso é o username
    // em outros casos poderia ser o email
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY) // garante que a senha seja apenas de escrita (set), nunca get 
    @Column(name = "password", length = 60, nullable = false)
    @NotNull (groups = { CreateUser.class, UpdateUser.class })
    @NotEmpty (groups ={ CreateUser.class, UpdateUser.class }) 
    @Size (groups = { CreateUser.class, UpdateUser.class }, min = 8, max = 60)
    private String password;

    @OneToMany(mappedBy = "user") // um User pode ter varias Tasks
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Task> tasks = new ArrayList<Task>();

    
}
