package br.com.deveficiente.youtubeapicdc.detalhelivro;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CrudLivrosController {
	
	
	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private Uploader uploader;
	
	
	@InitBinder
	public void InitBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new IsbnUnicoValidator(livroRepository), new TituloDoLivroUnicoValidator(livroRepository));
	}
	
	@PostMapping(value="/api/livro")
	@Transactional
	public void novo(@Valid NovoLivroForm form) {
		Livro novoLivro = form.novoLivro(autorRepository, uploader); 
		livroRepository.save(novoLivro);
	}
}
