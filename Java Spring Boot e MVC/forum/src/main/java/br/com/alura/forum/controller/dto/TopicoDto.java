package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.alura.forum.modelo.Topico;

public class TopicoDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static Page<TopicoDto> coverter(Page<Topico> topicos) {
//		List<TopicoDto> listaTopicoDto = new ArrayList<>();
//		for (int i = 0; i < topicos.size(); i++) {
//			listaTopicoDto.add(new TopicoDto(topicos.get(i)));
//		}		
//		return listaTopicoDto;
		
//		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
		
		return topicos.map(TopicoDto::new);
	}
	
}
