//Nathan Wells
//Main class for graph experiment
//1 May 2023

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class GraphExperiment{

   public static int[] vertexLevels = {10,20,30,40,50};
   public static int[] edgeLevels = {20,35,50,65,80};

   /**
     * A main routine that:
     * 1. Creates the output CSV file for each dataset run
     * 2. Uses a double for loop to apply each test run to each level of vertexes and edges.
     * 3. Generates the dataset and textfile.
     * 4. Makes a graph with that dataset.
     * 5. Gets a guarenteed vertex in the dataset to apply dijkstra on.
     * 6. Records the instrumentational results for that dataset in the csv file.
     */
   public static void main(String[] args){

      File f1 = new File("datasets/experiment.csv");
      try {
         FileWriter fileWritter = new FileWriter(f1.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write("V,E,Vc,Ec,PQc,ElogV,Operations" + "\n");
            bw.close();
         
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      for (int i=0; i<vertexLevels.length;i ++ ){
         for(int j=0; j < edgeLevels.length;j++){
               Data.GenerateDataset(vertexLevels[i], edgeLevels[j]); //generates textfile
               String fileName = "Graph_" + vertexLevels[i] + "V_" + edgeLevels[j] + "E";
               Graph g = Graph.makeGraph(fileName);
               String firstNode = g.getFirstVertex("datasets/"+ fileName); //error
               g.dijkstra(firstNode);
               g.recordInstrumentalResults(f1);
                

                

      
         }

   }
   
   
    




   }
}
