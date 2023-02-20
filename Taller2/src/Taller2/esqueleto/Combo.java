package Taller2.esqueleto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Combo implements Producto
{
	private double descuento;
	private String nombreCombo;
	private HashMap<Combo, ProductoMenu> itemsCombo;
	
	
	public Combo(String nombre, double descuento) 
	{
		itemsCombo= new HashMap<Combo, ProductoMenu>();
		this.nombreCombo=nombre;
		this.descuento=descuento;
		
	}
	
	public void agregarItemACombo(Combo combo, ProductoMenu itemCombo) 
	{
		itemsCombo.put(combo ,itemCombo);
	}
	
	public int getPrecio() 
	{
		int precio = 0;
		
		itemsCombo.get().getPrecio();
		
		for (int i = 0; i < itemsCombo.size(); i++) {
			precio += 1;
		}
		precio = precio - (int) (precio*descuento);
		return precio;
	}
	
	public String generarTextoFactura() 
	{
		return null;
	}
	
	public String getNombre() 
	{
		return nombreCombo;
	}
	
	
	

}
