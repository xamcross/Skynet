package skynet;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node("0", true, false));
        
        for (int i = 1; i < N; i++){
        	nodes.add(new Node(i + "", false, false));
        }
        
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            
            Node currentNode = Node.getNodeByName(N1+"", nodes);
            if (currentNode != null){
            	currentNode.addNeighbor(Node.getNodeByName(N2+"", nodes));
            }
            currentNode = Node.getNodeByName(N2+"", nodes);
            if (currentNode != null){
            	currentNode.addNeighbor(Node.getNodeByName(N1+"", nodes));
            }
            
        }
        
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            nodes.get(EI).setExit();
        }
        
        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("0 1"); // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }
    }
}