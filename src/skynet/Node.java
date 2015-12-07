package skynet;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String name;

	private boolean origin;

	private boolean exit;

	private List<Node> neighbors;

	private List<Route> routes;
	
	public static Node getNodeByName(String name, List<Node> nodes){
		for (int i = 0; i < nodes.size(); i++){
			if (nodes.get(i).getName().equals(name)){
				return nodes.get(i);
			}
		}
		return null;
	}
	
	public Node(String name, boolean origin, boolean exit){
		this.name = name;
		this.origin = origin;
		this.exit = exit;
		neighbors = new ArrayList<Node>();
	}
	
	public Node(Node original){
		this.name = original.getName();
		this.origin = original.isOrigin();
		this.exit = original.isExit();
		neighbors = new ArrayList<Node>();
		for (int i = 0; i < original.getNumberOfNeighbors(); i++){
			neighbors.add(original.getNeighborByIndex(i));
		}
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isOrigin(){
		return origin;
	}
	
	public boolean isExit(){
		return exit;
	}
	
	public void setExit(){
		this.exit = true;
	}
	
	public void addNeighbor(Node neighbor){
		if(!neighbors.contains(neighbor)){
			neighbors.add(neighbor);
		}
	}
	
	public void removeNeighbor(Node neighborToRemove){
		neighbors.remove(neighborToRemove);
	}
	
	public Node getNeighborByIndex(int index){
		return neighbors.get(index);
	}
	
	public int getNumberOfNeighbors(){
		return neighbors.size();
	}
	
	@Override
	public boolean equals(Object original){
		if(((Node)original).getName().equals(this.getName())){
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString(){
		String stringValue = "Node: " + this.name;
		if (isOrigin()){
			stringValue += " is an origin";
		}
		else {
			stringValue += " is not an origin";
		}
		if (isExit()){
			stringValue += " but is an exit";
		}
		else {
			stringValue += " and is not an exit";
		}
		return stringValue;
	}
	
}
