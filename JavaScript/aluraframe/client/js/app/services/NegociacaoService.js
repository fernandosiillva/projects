class NegociacaoService {

    constructor(){

        this._http = new HttpService();
    }

    obterNegociacoesDaSemana(){

        return new Promise((resolve, reject) => {

            this._http
                .get('http://localhost:3000/negociacoes/semana')
                .then(negociacoes => {
                    console.log(negociacoes);
                    resolve(negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)));
                })
                .catch(errorCallback => {
                    console.log(errorCallback);
                    reject('Não foi possível obter as negociações da semana.')
                });
        });
    }

    obterNegociacoesDaSemanaAnterior(){

        return new Promise((resolve, reject) => {

            this._http
                .get('http://localhost:3000/negociacoes/anterior')
                .then(negociacoes => {
                    console.log(negociacoes);
                    resolve(negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)));
                })
                .catch(errorCallback => {
                    console.log(errorCallback);
                    reject('Não foi possível obter as negociações da semana anterior.')
                });
        });
    }

    obterNegociacoesDaSemanaRetrasada(){

        return new Promise((resolve, reject) => {

            this._http
                .get('http://localhost:3000/negociacoes/retrasada')
                .then(negociacoes => {
                    console.log(negociacoes);
                    resolve(negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)));
                })
                .catch(errorCallback => {
                    console.log(errorCallback);
                    reject('Não foi possível obter as negociações da semana retrasada.')
                });
        });
    }

    cadastra(negociacao) {

        return ConnectionFactory
            .getConnection()
            .then(connection => new NegociacaoDao(connection))
            .then(dao => dao.adiciona(negociacao))
            .then(() => 'Negociação adicionada com sucesso.')
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi pssível adicionar a negociação.');
            });
    }

    lista() {

        return ConnectionFactory
            .getConnection()
            .then(connection => new NegociacaoDao(connection))
            .then(dao => dao.listaTodos())
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi pssível obter as negociações.');
            })


    }

    apaga(){

        return ConnectionFactory
            .getConnection()
            .then(connection => new NegociacaoDao(connection))
            .then(dao => dao.apagaTodos())
            .then((value) => 'Negociações apagadas com sucesso.')
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível apagar as negociações')
            })
    }

    importa(listaAtual){


        return Promise.all([this.obterNegociacoesDaSemana(),
            this.obterNegociacoesDaSemanaAnterior(),
            this.obterNegociacoesDaSemanaRetrasada()]
        )
            .then(negociacaoes =>
                negociacaoes.filter(negociacao =>
                    !listaAtual.some(negociacaoExistente =>
                        JSON.stringify(negociacao) == JSON.stringify(negociacaoExistente)))
            )
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível buscar negociações para importar.');
            })
    }
}