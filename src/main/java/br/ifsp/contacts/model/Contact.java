package br.ifsp.contacts.model;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
/**
 * Classe que representa o modelo de dados para um Contato.
 * 
 * @Entity indica que este objeto será mapeado para uma tabela
 * no banco de dados (em cenários de persistência com JPA).
 */
@Entity
public class Contact {

    /**
     * @Id indica que este campo é a chave primária (primary key) da entidade.
     * @GeneratedValue permite que o banco de dados (ou o provedor JPA) 
     * gere automaticamente um valor único para cada novo registro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;
    @NotBlank(message = "O telefone é obrigatório.")
    @Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres.")
    private String telefone;
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O formato do email é inválido.")
    private String email;

    /**
     * Lista de todos os endereços que pertencem a este contato.
     *
     * A anotação @OneToMany configura a relação um-para-muitos e automatiza
     * o gerenciamento dos endereços junto com o contato.
     *
     * - mappedBy="contact": Informa que a relação já é gerenciada pelo campo "contact"
     * na classe Address, evitando a criação de tabelas desnecessárias.
     *
     * - cascade=ALL: Facilita as operações. Se este contato for salvo ou apagado,
     * todos os seus endereços associados também serão.
     *
     * - orphanRemoval=true: Garante que, se um endereço for removido desta lista,
     * ele também seja apagado do banco de dados, não ficando "órfão".
     */

    @OneToMany(mappedBy = "contact", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Address> addresses;


    // Construtor vazio exigido pelo JPA
    public Contact() {}

    // Construtor para facilitar a criação de objetos
    public Contact(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
