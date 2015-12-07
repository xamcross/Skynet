package skynet;

import java.util.ArrayList;
import java.util.List;

public class Route {

	private String name;
	
	private Node start;
	
	private Node finish;
	
	private List<Node> shortestPath;
	
	public Route (String name, Node start, Node finish){
		this.name = name;
		this.start = start;
		this.finish = finish;
		shortestPath = new ArrayList<Node>();
	}
	
	/**
	 * Gets the shortest possible path from "start" Node to "finish" Node
	 * @return
	 */
	public List<Node> getShortestPath(){
		
		boolean shortestPathFound = false;
		int shortestPathLength = Integer.MAX_VALUE;
		
		//while (!shortestPathFound){
			if (getPath().size() == shortestPathLength){
				shortestPathFound = true;
				//break;
			}
			else {
				
			}
		//}
		
		return shortestPath;
	}
	
	public List<Node> getPath(){
		
		Node currentNode = new Node(start);
		List<Node> path = new ArrayList<Node>();
		

		if(getAvailableNeighbors(currentNode, path).size() > 0){
			nextStep();
		}

		
		return path;
	}
	
	/**
	 * Gets neighbors of the current Node that have not been included into path yet
	 * @param currentNode - last Node added to the path
	 * @param path - serie of Nodes starting with "start" node
	 * @return - neighbors of the current Node that have not been included into path yet
	 */
	private List<Node> getAvailableNeighbors(Node currentNode, List<Node> path) {
		List<Node> availableNeighbors = new ArrayList<Node>();
		for (int i=0; i < currentNode.getNumberOfNeighbors(); i++){
			if (!path.contains(currentNode.getNeighborByIndex(i))){
				System.err.println("Current path does not contain Node: " + currentNode.getNeighborByIndex(i).getName());
				for (int j=0; j < path.size(); j++){
					System.err.println("Path contains Node: " + path.get(j));
				}
				availableNeighbors.add(currentNode.getNeighborByIndex(i));
				System.err.println("Node: " + currentNode.getNeighborByIndex(i).getName() + " has been added to available neighbors list");
			}
		}
		return availableNeighbors;
	}
	
}
