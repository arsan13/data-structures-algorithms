package graph.representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class WeightedGraphUsingMap {

	static class Edge {
		Object src;
		Object dest;
		Object weight;
		Edge(Object src, Object dest, Object weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	Map<Object, LinkedList<Edge>> adjList = new HashMap();
    Map<Object, Integer>  indexes = new HashMap<>();
    int index = 0;
	
	public WeightedGraphUsingMap(ArrayList<Object> vertices) {
		for(int i = 0; i < vertices.size(); i++) {
			Object vertex = vertices.get(i);
			LinkedList<Edge> list = new LinkedList<>();
			adjList.put(vertex, list);
			indexes.put(vertex, index++);
		}
	}

	public void addEdge(Object src, Object dest, Object weight) {
		
		Edge edge = new Edge(src, dest, weight);
		LinkedList<Edge> list;

		list = adjList.get(src);
		list.add(edge);
		adjList.put(src, list);
		
	}
	
	public void printGraph() {
		
		System.out.println("Src \t Dest \t Weight");
		
		for(Object vertex : adjList.keySet()) {
			
			LinkedList<Edge> list = adjList.get(vertex);
			
			for(Edge edge : list) {
				System.out.print(edge.src + "\t " + edge.dest + "\t " + edge.weight);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		ArrayList<Object> vertices = new ArrayList<>();
        vertices.add(0);
        vertices.add(1);
        vertices.add(2);
        vertices.add(3);
        vertices.add(4);
        vertices.add(5);
        vertices.add(6);
		
		WeightedGraphUsingMap graph = new WeightedGraphUsingMap(vertices);
        
		graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);
        
        graph.printGraph();
	}
}

/*
 * 
 * 0 1 0 4 1 2 2 3 2 4 3 4
 * 
 */