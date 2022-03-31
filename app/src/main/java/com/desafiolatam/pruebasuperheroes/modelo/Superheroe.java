package com.desafiolatam.pruebasuperheroes.modelo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Superheroe{

	@SerializedName("Superheroe")
	private List<SuperheroeItem> superheroe;

	public void setSuperheroe(List<SuperheroeItem> superheroe){
		this.superheroe = superheroe;
	}

	public List<SuperheroeItem> getSuperheroe(){
		return superheroe;
	}

	@Override
 	public String toString(){
		return 
			"Superheroe{" + 
			"superheroe = '" + superheroe + '\'' + 
			"}";
		}
}