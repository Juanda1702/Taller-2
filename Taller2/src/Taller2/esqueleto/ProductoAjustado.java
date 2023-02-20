package Taller2.esqueleto;

import java.util.ArrayList;

public class ProductoAjustado implements Producto
{
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	
	public ProductoAjustado(ProductoMenu base) 
	{
		this.base=base;
	}
	
	public String getNombre() 
	{
		return base.getNombre();
	}
	
	public int getPrecio() 
	{
		int precioBase=base.getPrecio();
		for (int i =0; i < agregados.size(); i++)
		{
			Ingrediente actualAgregado= agregados.get(i);
			precioBase+= actualAgregado.getCostoAdicional();
				
		}
		
		for (int i =0; i < eliminados.size(); i++)
		{
			Ingrediente actualEliminado= agregados.get(i);
			precioBase-= actualEliminado.getCostoAdicional();
						
		}
		return precioBase;
	}
	
	public String generarTextoFactura() 
	{
		String texto = base.getNombre()+":"+base.getPrecio();
		for (int i = 0; i < agregados.size(); i++)
		{
			Ingrediente actual = agregados.get(i);
			texto+= "\n"+actual.getNombre()+":"+actual.getCostoAdicional();
		}
		return texto;
	}
		
}
