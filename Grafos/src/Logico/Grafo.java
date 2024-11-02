package Logico;

import java.util.ArrayList;
import java.util.Collections;

public class Grafo {
	private ArrayList<String> vertices;
	private ArrayList<ArrayList<String>> listaAdyacencia;
	
	public Grafo() {
	    this.vertices = new ArrayList<>();
	    this.listaAdyacencia = new ArrayList<>();
	}
	
	// Método para agregar un vértice
	public void agregarVertice(String vertice) {
	    if (!vertices.contains(vertice)) {
	        vertices.add(vertice);
	        listaAdyacencia.add(new ArrayList<>()); // Añade una nueva lista vacía para este vértice
	    }
	}
	
	// Método para obtener el índice de un vértice
	private int obtenerIndice(String vertice) {
	    return vertices.indexOf(vertice);
	}
	
	// Método para agregar una arista no dirigida
	public void agregarArista(String origen, String destino) {
	    // Asegurarse de que ambos vértices existan
	    agregarVertice(origen);
	    agregarVertice(destino);
	    
	    // Obtener los índices de los vértices
	    int indiceOrigen = obtenerIndice(origen);
	    int indiceDestino = obtenerIndice(destino);
	    
	    // Agregar la arista en ambas direcciones ya que es no dirigido
	    if (!listaAdyacencia.get(indiceOrigen).contains(destino)) {
	        listaAdyacencia.get(indiceOrigen).add(destino);
	    }
	    if (!listaAdyacencia.get(indiceDestino).contains(origen)) {
	        listaAdyacencia.get(indiceDestino).add(origen);
	    }
	}
	
	// Método para calcular la secuencia de grados
	public ArrayList<Integer> calcularSecuenciaGrados() {
		ArrayList<Integer> secuencia = new ArrayList<>();
	    
	    for (ArrayList<String> adyacentes : listaAdyacencia) {
	        secuencia.add(adyacentes.size());
	    }
	    
	    // Ordenar la secuencia en orden descendente
	    Collections.sort(secuencia, Collections.reverseOrder());
	    return secuencia;
	}
	
	// Método para obtener la lista de adyacencia
	public void imprimirListaAdyacencia() {
	    for (int i = 0; i < vertices.size(); i++) {
	        System.out.println("Vértice " + vertices.get(i) + ": " + 
	                         listaAdyacencia.get(i).toString());
	    }
	}
	
	public static void main(String[] args) {
	    Grafo grafo = new Grafo();
	    
	    // Agregar primero todos los vértices
	    grafo.agregarVertice("A");
	    grafo.agregarVertice("B");
	    grafo.agregarVertice("C");
	    grafo.agregarVertice("D");
	    grafo.agregarVertice("E");
	    grafo.agregarVertice("F");
	    grafo.agregarVertice("G");
	    grafo.agregarVertice("H");
	    grafo.agregarVertice("I");
	
	    // Agregar las aristas especificadas
	    grafo.agregarArista("A", "B");
	    grafo.agregarArista("A", "C");
	    grafo.agregarArista("B", "D");
	    grafo.agregarArista("B", "E");
	    grafo.agregarArista("C", "F");
	    grafo.agregarArista("C", "G");
	    grafo.agregarArista("D", "E");
	    grafo.agregarArista("D", "H");
	    grafo.agregarArista("E", "I");
	    grafo.agregarArista("F", "G");
	    grafo.agregarArista("G", "H");
	    grafo.agregarArista("H", "I");
	    grafo.agregarArista("I", "F");
	
	    // Mostrar la secuencia de grados
	    System.out.println("Secuencia de grados:");
	    ArrayList<Integer> secuenciaGrados = grafo.calcularSecuenciaGrados();
	    System.out.println(secuenciaGrados);
	
	    // Mostrar la lista de adyacencia
	    System.out.println("\nLista de adyacencia:");
		        grafo.imprimirListaAdyacencia();
		 }
}
