package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

//Metodo responsavel por manipular as views da pasta produtos.
@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private FileSaver fileSaver;

//	Metodo responsavel por retornar a view form.jsp quando a solicitação é feito pelo navegador atraves do mapping.
	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
		
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		
		return modelAndView;
	}

//	Atributo responsavel por instanciar o produtoDAO, com anotação para não ser preciso criar o controller.
	@Autowired
	private ProdutoDAO produtoDAO;
	
//	Este método recebera um objeto do tipo WebDataBinder que chamaremos apenas de binder. O objeto binder tem um médoto chamado addValidators que recebe uma instância de uma classe que implemente a interface Validator do pacote org.springframwork.validation.
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
	}
	
//	Metodo responsavel por receber o action do formulario, sendo chamado o produtoDAO que faz a persistencia do produto
//	E retorna a view ok.jsp.
	@RequestMapping(method = RequestMethod.POST)//Note que o BindingResult vem logo após o atributo que está assinado com a anotação @Valid, essa ordem não é por acaso, precisa ser desta forma para que o Spring consiga fazer as validações da forma corret
	@CacheEvict(value = "produtosHome", allEntries = true)
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {		

		System.out.println(sumario.getOriginalFilename());
		
		if (result.hasErrors()) {
			return form(produto);
		}
		
		String path = fileSaver.write("arquivos-sumario", sumario);
		produto.setSumarioPath(path);
		
		produtoDAO.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		List<Produto> produtos = produtoDAO.listar();
		modelAndView.addObject("produtos", produtos);
		
		return modelAndView;
	}
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDAO.find(id);
		modelAndView.addObject("produto", produto);
		return modelAndView;
	}		
}
