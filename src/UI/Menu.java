package UI;

import Gestion.Biblioteca;
import JSON.JSONUtiles;
import Modelo.Articulo;
import Modelo.Libro;
import Modelo.Material;
import Modelo.Revista;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

public class Menu {

    public static Biblioteca<Material> biblioteca = new Biblioteca<>();


    public static void menu(){

        //carga de datos
        Revista revista = new Revista("Rolling", "cami", 2022, 2, true, 1, true);
        Libro libro = new Libro("After 1", "Anna Todd", 2020, 3, true, 400);
        Articulo articulo = new Articulo("Pepsi", "nico", 2024, 1, true, "Que daño hace la gaseosa");

        biblioteca.agregarElemento(revista);
        biblioteca.agregarElemento(libro);
        biblioteca.agregarElemento(articulo);

        JSONArray jbiblioteca = biblioteca.listaAJSON();

        JSONArray bibliotecas = new JSONArray();
        bibliotecas.put(jbiblioteca);

        JSONUtiles.guardarJSONArray(bibliotecas, "bibliotecas.json");

        //varibales para el menu
        Libro libro2;
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("MENU: \n 1. Agregar elemento \n 2. Eliminar elemento \n 3. Buscar por nombre \n 4. Prestamo \n 5. Devolver \n 6.Ver lista \n 7. Salir.");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    libro2 = new Libro("After 2", "Anna Todd", 2021, 1, true,450);
                    System.out.println(biblioteca.agregarElemento(libro2));
                    break;
                case 2:
                    System.out.println(biblioteca.eliminarElemento(articulo));
                    break;
                case 3:
                    System.out.println(biblioteca.buscarElementoPorNombre("After 1"));
                    break;
                case 4:
                    System.out.println(revista.prestar());
                    System.out.println(revista.prestar());
                    break;
                case 5:
                    System.out.println(revista.devolver());
                    break;
                case 6:
                    System.out.println(biblioteca.mostrarElementos());
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }while(opcion != 7);

        JSONUtiles.guardarJSONArray(biblioteca.listaAJSON(), "bibliotecas.json");

    }

    public static Biblioteca<Material> cargarBibliotecaDesdeJson (String nombre){
        Biblioteca<Material> biblioteca = new Biblioteca<>();
        try{
            JSONArray arrayBiblioteca = new JSONArray(JSONUtiles.leerArchivo(nombre));

            if(arrayBiblioteca.length() > 0){
                JSONArray biblio = arrayBiblioteca.getJSONArray(0);

                for(int i = 0; i < biblio.length(); i++){
                    JSONObject objBiblioteca = biblio.getJSONObject(i);

                    if(objBiblioteca.has("NumEdicion")){
                        biblioteca.agregarElemento(Revista.traerDeJson(objBiblioteca));
                    }
                    else if(objBiblioteca.has("Resumen")){
                        biblioteca.agregarElemento(Articulo.traerDeJson(objBiblioteca));
                    }
                    else if(objBiblioteca.has("NumPaginas")){
                        biblioteca.agregarElemento(Libro.traerDeJson(objBiblioteca));
                    }
                }
            }
        }catch(JSONException e ){
            throw new RuntimeException("Error al procesar los objetos");
        }
        return biblioteca;
    }
}

