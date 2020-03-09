package edu.infnet.patrimonio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patrimonio {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer identificacao;
	
	private String nome;
	
	private String local;
	
	public Patrimonio() {
		
	}
	
	
	public Patrimonio(Integer id, Integer identificacao, String nome, String local) {
		super();
		this.id = id;
		this.identificacao = identificacao;
		this.nome = nome;
		this.local = local;
		
	}


	public Patrimonio(String identificacao, String nome, String local) {
		this.identificacao = Integer.parseInt(identificacao);
		this.nome = nome;
		this.local = local;
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdentificacao() {
		return identificacao;
	}


	public void setIdentificacao(Integer identificacao) {
		this.identificacao = identificacao;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}
	
	@Override
	public String toString() {
		return "Patrimonio [id=" + id + ", identificacao="+ identificacao + ", nome="+ nome +", local="+ local +"]";
	}
	
	

}
