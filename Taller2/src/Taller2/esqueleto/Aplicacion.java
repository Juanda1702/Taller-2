package Taller2.esqueleto;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Aplicacion 
{
	private Restaurante restaurante;
	
	public Aplicacion()
	{
		restaurante = new Restaurante();
		restaurante.cargaraInformacionRestaurante(new File("./data/ingredientes.txt"), new File("./data/menu.txt"), new File("./data/combos.txt"));
	
	}
	
	public static void main(String[]args)
	{
		Aplicacion app = new Aplicacion();
		app.ejecutarOpcion(0);
	}
	
	
	public void mostrarMenu() 
	{
		System.out.println("1. Iniciar un nuevo pedido");
		System.out.println("2. Agregar un elemento a un pedido");
		System.out.println("3. Cerrar un pedido y guardar la factura");
		System.out.println("4. Consultar la información de un pedido dado su id");
		System.out.println("5. Salir del restaurante");
		
	}
	
	
	public void ejecutarOpcion(int opcionSeleccionada) 
	{
		System.out.println("\nBienvenido al restaurante\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarMenu();
					
				else if (opcion_seleccionada == 2)
					restaurante.getPedidoEnCurso();
				else if (opcion_seleccionada == 3)
					restaurante.cerrarYGuardarPedido();
				else if (opcion_seleccionada == 4)
					;
				else if (opcion_seleccionada == 5)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
			
	}
		
	public void ejecutarMenu() 
	{
		ArrayList<ProductoMenu> menuPrincipal = restaurante.getMenuBase();
		System.out.println("\nMenu base\n");
		for (int i = 0; i < menuPrincipal.size(); i++)
		{
			ProductoMenu actualMenu = menuPrincipal.get(i);
			System.out.println(actualMenu.getNombre()+": "+actualMenu.getPrecio());
			
		}	

		ArrayList<Combo> listaCombos = restaurante.getCombos();
		System.out.println("\nCombos\n");
		for (int i = 0; i < listaCombos.size(); i++)
		{
			
			System.out.println(listaCombos.get(i).getNombre()+": "+listaCombos.get(i).getPrecio());
			
		}	
		
		ArrayList<Ingrediente> listaIngredientes = restaurante.getIngredientes();
		System.out.println("\nIngredientes adicionales\n");
		for (int i = 0; i < listaIngredientes.size(); i++)
		{
			Ingrediente actualIngrediente = listaIngredientes.get(i);
			System.out.println(actualIngrediente.getNombre()+": "+actualIngrediente.getCostoAdicional());
			
		}	
		
		System.out.println("\nPorfavor dar nombre y direccion");
		String nombreCliente = input("Nombre");
		String direccionCliente = input("Direccion");
		restaurante.iniciarPedido(nombreCliente, direccionCliente);
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
