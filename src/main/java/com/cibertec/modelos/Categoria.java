package com.cibertec.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Categoria;
	private String Nombre;
	
	
	 //Contructores
	public Categoria() {}

	
	
	public Categoria(int iD_Categoria, String nombre) {
		super();
		ID_Categoria = iD_Categoria;
		Nombre = nombre;
	}

	public int getID_Categoria() {
		return ID_Categoria;
	}

	public void setID_Categoria(int iD_Categoria) {
		ID_Categoria = iD_Categoria;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	

}
