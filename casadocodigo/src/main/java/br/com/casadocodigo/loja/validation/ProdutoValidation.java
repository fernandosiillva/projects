package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Produto;

//A interface Validator correta é a que está no pacote org.springframework.validation.
public class ProdutoValidation implements Validator{

	
	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);//O que esse código faz é verificar se o objeto recebido para a validação tem uma assinatura da classe Produto. Com isso o Spring pode verificar se o objeto é uma instância daquela classe ou não.
	}

//	Perceba que o método Validate é onde realmente acontecerá a validação.
	@Override
	public void validate(Object target, Errors errors) {
		
//		rejeite se for vazio
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		
		Produto produto = (Produto) target;
		if (produto.getPaginas() <= 0) {
			errors.rejectValue("paginas", "field.required");
		}
	}
}
