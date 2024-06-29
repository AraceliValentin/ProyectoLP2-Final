package com.cibertec.modelos;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private int ID_Venta;
    private int Cliente_ID;
    private Date Fecha;

    
	 //Contructores
    public Venta() {}


	public Venta(int iD_Venta, int cliente_ID, Date fecha, double total) {
		ID_Venta = iD_Venta;
		Cliente_ID = cliente_ID;
		Fecha = fecha;
	}


	public int getID_Venta() {
		return ID_Venta;
	}


	public void setID_Venta(int iD_Venta) {
		ID_Venta = iD_Venta;
	}


	public int getCliente_ID() {
		return Cliente_ID;
	}


	public void setCliente_ID(int cliente_ID) {
		Cliente_ID = cliente_ID;
	}


	public Date getFecha() {
		return Fecha;
	}


	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

}
