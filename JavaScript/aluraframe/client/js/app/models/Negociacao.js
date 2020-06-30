class Negociacao{
    constructor(data, quantidade, valor){
        this._data = new Date(data.getTime());
        this._quantidade = quantidade;
        this._valor = valor;
        Object.freeze(this);/* Congelando a instancia para não ser permitido a alterações dos fields. */
    }

    get volume() {
        return this._quantidade * this._valor;
    }

    get data(){
        return new Date(this._data.getTime());/* Protegendo a alteração da data (Um Objeto) com um outro Objeto por cima. */
    }

    get quantidade(){
        return this._quantidade;
    }

    get valor(){
        return this._valor;
    }
}