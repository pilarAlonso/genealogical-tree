package com.cristianroot.springrestsecurityexample.User;

import org.springframework.boot.test.web.client.TestRestTemplate;

public class FindAllVinyls {
	//el test normal si la petiion falla salta una excepcion en este no , si acemos una peticion y falla no nos salta una excepcion y nospermite recoger una respuesta para evaluarla
	private final  TestRestTemplate testRestTemplate;

	public FindAllVinyls(TestRestTemplate testRestTemplate) {
		this.testRestTemplate = testRestTemplate;
	}
	//getforentity le pasas una url y te da la respuesta que e va adar esa url
	//saco la uri a la que voy a llamar
	//luego digo que metodo voy a usar y qu le voy a enviar en el caso del post pondria que objeto voy a enviar
    //parametrized type reference para cuando quieres poner el .class de un objeto tipado en este cas una lista
	//los objetos me los envuelve en responseEntity


}

