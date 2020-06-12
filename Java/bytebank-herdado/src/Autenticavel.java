
//contrato autenticavel
	//quem assinar esse contrato precisa implementar
            //metodo setSenha
            //metodo autentica
public abstract interface Autenticavel {

	public abstract boolean autentica(int senha);

	public abstract void setSenha(int senha);
}
