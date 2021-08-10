package br.com.deveficiente.youtubeapicdc.detalhelivro;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.URL;

@Entity
public class Autor {
	
	@Deprecated
	public Autor() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private @NotNull String nome;
	private @NotBlank @URL String linkGithub;
	@PastOrPresent
	private LocalDateTime createadAt = LocalDateTime.now();

	public Autor(@NotNull String nome, @NotBlank @URL String linkGithub) {
		this.nome = nome;
		this.linkGithub = linkGithub;
	}


	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", linkGithub=" + linkGithub + ", createadAt=" + createadAt + "]";
	}

}
