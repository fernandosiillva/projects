class DateHelper{

    constructor(){

        throw new Error('Esta classe não pode ser instanciada!');
    }

    static dataParaTexto(data){
        
        return `${data.getDate()}/${data.getMonth()+1}/${data.getFullYear()}`;
    }

    static textoParaData(texto){

    console.log(texto);


        if(!/\d{4}-\d{2}-\d{2}/.test(texto))
            throw new Error('Deve estar no formato aaaa-mm-dd');
            
        return new Date(...texto.split('-').map((item, indice) => item - indice % 2));
    }

    /*static textoParaData(texto) {
		if (!/\d{2}\/\d{2}\/\d{4}/.test(texto))
			throw new Error('Deve estar no formato dd/mm/aaaa');

		// return new Date(...texto
		// 		.split('/')
		// 		.map((item, indice) => item - (indice % 2)));

		return new Date(...texto.split('/').reverse().map((item, indice) => item - (indice % 2)));
	}*/

}