package br.com.deveficiente.youtubeapicdc.detalhelivro;

import java.util.Optional;

public class TituloDoLivroUnicoValidator extends CampoUnicoLivoValidator {

	private LivroRepository livroRepository;

	public TituloDoLivroUnicoValidator(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public Optional<Livro> buscaLivroPorCampo(NovoLivroForm novoLivroForm) {
		return livroRepository.findByTitulo(novoLivroForm.getTitulo());
	}

	@Override
	protected String getNomeCampoInvalido() {
		return "Título";
	}

}
