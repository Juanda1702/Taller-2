package Taller2.esqueleto;

import java.util.ArrayList;


public class Combo implements Producto
{
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo;
	
	
	public Combo(String nombre, double descuento) 
	{
		itemsCombo= new ArrayList<ProductoMenu>();
		this.nombreCombo=nombre;
		this.descuento=descuento;
		
	}
	
	public void agregarItemACombo(ProductoMenu itemCombo) 
	{
		itemsCombo.add(itemCombo);
	}
	
	public int getPrecio() 
	{
		int precio = 0;
		
		for (int i = 0; i < itemsCombo.size(); i++) {
			precio += itemsCombo.get(i).getPrecio();
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
