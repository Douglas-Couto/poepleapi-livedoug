package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
//classe setada como entidade
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    //chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Geração automatica de ID qdo inserir o dado
    private Long id;

    @Column(nullable = false)
    //@column, assim como na classe phone, nullable = false quer dizer que são dados obrigatórios

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    //Além de não nulo, temos um unique = true, ou seja, só podemos fazer cadastro de CPFs unicos
    private String cpf;

    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    //Uma pessoa tem muitos telefones, então é one to many, Aqui esta sendo criado uma tabela intermediaria
    //fetch type.lazy é mais performatico, cascade = estratégia de inserção
    
    private List<Phone> phones;
}
