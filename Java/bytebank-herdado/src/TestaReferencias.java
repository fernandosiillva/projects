
public class TestaReferencias {

	public static void main(String[] args) {
		
		Funcionario fernando = new Gerente();
		
		fernando.setNome("Fernando");
		fernando.setSalario(5000.0);
		
		Funcionario bezerra = new Gerente();
		bezerra.setSalario(2000.0);
		
		Funcionario editor = new EditorVideo();
		editor.setSalario(2500.0);
		
		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(fernando);
		controle.registra(bezerra);
		controle.registra(editor);
		
		System.out.println(controle.getSoma());
	}

}
