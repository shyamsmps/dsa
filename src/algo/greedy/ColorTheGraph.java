package algo.greedy;

import algo.greedy.helper.classes.GraphForColoring;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * implement a function that finds a way of coloring a graph so that no two adjacent vertices are colored using the same color.
 * try using the minimum number of colors possible.
 * this approach does not in general use the minimum number of colors possible.
 */
public class ColorTheGraph {

    public static void main(String[] args) {
        // 0--1, 0--2, 1--2, 1--3, 2--3, 3--4
        int[][][] edges = {
                {{0,1}, {0,2}, {1,2}, {1,3}, {2,3}, {3,4}},
                {{0,1}, {0,2}, {1,2}, {1,4}, {2,4}, {4,3}}
        };
        int vertices[] = {5, 5};

        for(int i=0; i<edges.length; i++) {
            GraphForColoring graphForColoring = new GraphForColoring(vertices[i]);
            for(int j=0; j<edges[i].length; j++) {
                graphForColoring.addEdge(edges[i][j][0], edges[i][j][1]);
            }
            greedyColoringSelf(graphForColoring);
//            System.out.println(findLargestNumber(testCases[i][0], testCases[i][1]) == testCases[i][2] ? "Success" : "Error");
        }

    }

    public static void greedyColoring(GraphForColoring g) {
        int numofVertices = g.getVertices();
        int[] result = new int[numofVertices];

        //Initialize vertices as unassigned
        Arrays.fill(result, -1);

        //Assign the first color to first vertex
        result[0] = 0;

        boolean[] available = new boolean[numofVertices];
        // Assign colors to remaining V-1 vertices
        Arrays.fill(available, true);
        LinkedList < Integer > Llist[];
        Llist = g.getAdj();
        for (int i = 1; i < numofVertices; i++) {

            Iterator< Integer > var = Llist[i].iterator();
            while (var.hasNext()) {

                int temp = var.next();
                // Find the first available color
                if (result[temp] != -1) {
                    available[result[temp]] = false;
                }
            }
            int j;
            for (j = 0; j < numofVertices; j++) {
                if (available[j]) {
                    break;
                }
            }

            result[i] = j; // Assign the found color
            //reset the values
            Arrays.fill(available, true);
        }
        for (int i = 0; i < numofVertices; i++) {
            System.out.println("Vertex: " + i + " , " + "Color: " + result[i]);
        }
    }

    public static void greedyColoringSelf(GraphForColoring g) {
        int vertices = g.getVertices();
        int[] result = new int[vertices];
        Arrays.fill(result, -1);

        int colors = 0;
        LinkedList< Integer >[] adj = g.getAdj();
        for (int i = 0; i < vertices; i++) {

            // usedByNeighbours of every color for current node.
            // false means its available. (default value for  boolean is false, that's why)
            boolean[] usedByNeighbours = new boolean[colors];
            
            // mark colors of neighbours as true on usedByNeighbours array
            for(int j=0; j<adj[i].size(); j++) {
                int colorOfAdjacentNode = result[adj[i].get(j)];
                if(colorOfAdjacentNode != -1 && colorOfAdjacentNode < colors) {
                    usedByNeighbours[colorOfAdjacentNode] = true;
                }
            }

            // find first not used color by neighbours
            for(int p=0; p<usedByNeighbours.length; p++) {
                if(!usedByNeighbours[p])
                    result[i] = p;
                    break;
            }
            if(result[i] == -1)
                result[i] = colors++;
        }

        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex: " + i + " , " + "Color: " + result[i]);
        }
    }

}
