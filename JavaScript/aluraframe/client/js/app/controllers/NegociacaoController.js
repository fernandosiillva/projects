class NegociacaoController{

    constructor(){
        let $ = document.querySelector.bind(document);
        this._inputData = $("#data");
        this._inputQuantidade = $("#quantidade");
        this._inputValor = $("#valor");

        this._listaNegociacoes = new Bind(
            new ListaNegociacoes(),
            new NegociacoesView($("#negociacoesView")),
            'adiciona', 'esvazia')

        this._mensagem = new Bind(
            new Mensagem(),
            new MensagemView($("#mensagemView")),
            'texto')

        this._service = new NegociacaoService();

        this._init();
    }

    _init(){

        this._service
            .lista()
            .then(negociacoes =>
                negociacoes.forEach(negociacao =>
                    this._listaNegociacoes.adiciona(negociacao)))
            .catch(erro => this._mensagem.texto = error);

        setInterval(() => {
            this.importaNegociacoes();
        }, 3000)
    }

    adiciona(event){

        event.preventDefault();

        let negociacao = this._criaNegociacao();

        this._service
            .cadastra(negociacao)
            .then(mensagem => {
                this._listaNegociacoes.adiciona(negociacao);
                this._mensagem.texto = mensagem;
                this.limpaFormulario();
            })
            .catch(erro => this._mensagem.texto = erro);
    }

    importaNegociacoes(){

        this._service
            .importa(this._listaNegociacoes.negociacoes)
            .then(negociacoes => {
            negociacoes
                .reduce((previousValue, currentValue) => previousValue.concat(currentValue), [])
                .forEach(negociacao=> this._listaNegociacoes.adiciona(negociacao));
            this._mensagem.texto = 'Negociações importadas com sucesso.';
            })
                .catch(error => this._mensagem.texto = error);
    }

    apaga(){


        this._service
            .apaga()
            .then(mensagem => {
                this._mensagem.texto = mensagem;
                this._listaNegociacoes.esvazia();
            })
            .catch(erro => this._mensagem.texto = erro);
    }

    _criaNegociacao(){
        
        return new Negociacao(
            
            DateHelper.textoParaData(this._inputData.value),
            parseInt(this._inputQuantidade.value),
            parseFloat(this._inputValor.value)
        );
    }

    limpaFormulario(){
     
        this._inputData = '';
        this._inputQuantidade = 1;
        this._inputValor = 0.0;
        document.querySelector("#data").focus();
    }
}