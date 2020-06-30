class ListaNegociacoes{

    constructor(){
        this._negociacoes = [];        
    }

    adiciona(negociacao){
        
        this._negociacoes.push(negociacao);        
    }

    get negociacoes(){
        return [].concat(this._negociacoes);
        //com o metodo [].concat eu blindo o meu get negociacoes que é um tipo array e assim inpede de adicionar outra negociacao!
    }

    esvazia(){

        this._negociacoes = [];
    }

}