package Taller2.esqueleto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Restaurante 
{
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Combo> combos;
	private ArrayList<Pedido> pedidos;
	private Pedido pedidoEnCurso;
	
	public Restaurante() 
	{
		ingredientes= new ArrayList<Ingrediente>();
		menuBase= new ArrayList<ProductoMenu>();
		combos= new ArrayList<Combo>();
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) 
	{
		String[] pedido = input("Que desea ordenar").split(",");
		
		
		
	}
	
	public void cerrarYGuardarPedido() 
	{
		
	}
	
	public Pedido getPedidoEnCurso() 
	{
		return null;
	}
	
	public ArrayList<ProductoMenu> getMenuBase() 
	{
		
		return menuBase;
	}
	
	public ArrayList<Ingrediente> getIngredientes() 
	{
		
		return ingredientes;
	}
	
	public ArrayList<Combo> getCombos() 
	{
		
		return combos;
	}
	
	public void cargaraInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) 
	{		
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		
	}
	
	private void cargarIngredientes(File archivoIngredientes) 
	{		

		try {
			BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] listaIngredientes = linea.split(";");
				String comida = listaIngredientes[0];
				int precio = Integer.parseInt(listaIngredientes[1]);
				Ingrediente nuevo = new Ingrediente(comida, precio);
				ingredientes.add(nuevo);
				
				linea = br.readLine();
			}
			br.close();
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void cargarMenu(File archivoMenu)
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] listaMenu = linea.split(";");
				String comida = listaMenu[0];
				int precio = Integer.parseInt(listaMenu[1]);
				ProductoMenu nuevo = new ProductoMenu(comida, precio);
				menuBase.add(nuevo);
				
				
				linea = br.readLine();
			}
			System.out.println();
			br.close();
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void cargarCombos(File archivoCombos)
	{
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(archivoCombos));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] combo = linea.split(";");
				String comida = combo[0];
				String descuento = combo[1].replace("%", "");
				Double des = (Double.parseDouble(descuento)/100);
				Combo nuevo = new Combo(comida, des);
				
				
				int j = 2;
				
				for (int i = 0; i < menuBase.size() && j!=combo.length; i++) 
					{
					if  (combo[j].equals(menuBase.get(i).getNombre())) 
					{
						nuevo.agregarItemACombo(nuevo, menuBase.get(i));
						j++;
						i=0;
						
						
					}
						
					}
				combos.add(nuevo);
				linea = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	

	

	
		
}
