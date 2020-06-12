package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
        empresa.setNome("Alura");
        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial++);
        empresa2.setNome("Caelum");
        lista.add(empresa);
        lista.add(empresa2);
        
        Usuario usuario1 = new Usuario();
        usuario1.setLogin("fernando");
        usuario1.setSenha("123");
        
        Usuario usuario2 = new Usuario();
        usuario2.setLogin("gel");
        usuario2.setSenha("123");
        
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
	}
	
	public void adicona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public  List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = lista.iterator();
		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}			
		}
	}
	
	public Empresa buscaEmpresaId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
