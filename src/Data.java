//Nathan Wells
//Generating dataset code
//1 May 2023


import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Data {

    
    /**
     * This method creates a new dataset, in the format we were told to replicate, so it can be read and loaded into a graph.
     * @param numVertices The number of vertices that we want in our dataset.
     * @param numEdges The number of unique edges we want to have, consisting of source,dest and cost.
     */
    public static void GenerateDataset(int numVertices, int numEdges){
        String[] vertices = new String[numVertices];
        // Generate vertices with names nodeXXX
        for (int i = 0; i < numVertices; i++) {
            vertices[i] = "Node" + String.format("%03d", i); //Node001,Node002...Node20
        }

        // Generate edges with random weights
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        Set<String> edgeSet = new HashSet<>();
        int numUniqueEdges = 0;
        
        while (numUniqueEdges < numEdges ) { //until we have = unique edges
            int source = random.nextInt(numVertices);
            int dest = random.nextInt(numVertices);
            while (source == dest) { //if they are the same
                dest = random.nextInt(numVertices);
            }
            int weight = random.nextInt(10) + 1; // Weight is between 1 and 10
            String edge = vertices[source] + " " + vertices[dest]; //Node001 Node009
            if (!edgeSet.contains(edge)) { //If it is a unique edge
                sb.append(vertices[source]).append(" ").append(vertices[dest]).append(" ").append(weight).append("\n");
                edgeSet.add(edge);
                numUniqueEdges++;
            }
        }


        // Write the edges to a new text file in my datasets folder
        String filename = "datasets/" + "Graph_" + numVertices + "V_" + numEdges + "E";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("beep boop wrong");
        }
    }

    
}


