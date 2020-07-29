package petz.com.br.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	@Column(unique=true, nullable=false) 
	private String cpf;
	private String celular;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Pet> pets;
	
	public Cliente() {}
	
	public Cliente(String nome, String cpf, String celular) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
	}
	
	public Cliente(String nome, String cpf, String celular, List<Pet> pets) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.pets = pets;
	}
	
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", celular=" + celular + ", pets=" + pets
				+ "]";
	}
}