package algo.greedy;

import algo.greedy.helper.classes.GraphForMinimumSpanningTree;

import java.util.Arrays;

public class KruskalMinimumSpanningTree {

    public static void main(String[] args) {
        GraphForMinimumSpanningTree graph = new GraphForMinimumSpanningTree(4, 5);
        int[][] edgesData = {
                {0, 0, 0, 1, 2},
                {1, 2, 3, 3, 3},
                {10, 6, 5, 15, 4}
        };
        fillGraph(edgesData, graph);
        KruskalMinimumSpanningTree.KruskalMST(graph);
        System.out.println();

        GraphForMinimumSpanningTree graph1 = new GraphForMinimumSpanningTree(6, 7);
        int[][] edgesData1 = {
                {0, 0, 1, 1, 2, 3, 4},
                {1, 2, 2, 3, 3, 4, 5},
                {4, 3, 1, 2, 4, 2, 6}
        };
        fillGraph(edgesData1, graph1);
        KruskalMinimumSpanningTree.KruskalMST(graph1);

        GraphForMinimumSpanningTree graph2 = new GraphForMinimumSpanningTree(6, 7);
        int[][] edgesData2 = {
                {0, 0, 1, 1, 2, 3, 4},
                {1, 2, 2, 3, 3, 4, 5},
                {4, 3, 1, 3, 4, 2, 6}
        };
        fillGraph(edgesData2, graph2);
        KruskalMinimumSpanningTree.KruskalMST(graph2);
    }

    static void fillGraph(int[][] edgesData, GraphForMinimumSpanningTree graph) {
        for(int i=0; i<edgesData[0].length; i++) {
            graph.listEdges[i].source = edgesData[0][i];
            graph.listEdges[i].destination = edgesData[1][i];
            graph.listEdges[i].weight = edgesData[2][i];
        }
    }

    public static void KruskalMST(GraphForMinimumSpanningTree g) {

        GraphForMinimumSpanningTree.Edge answer[] = new GraphForMinimumSpanningTree.Edge[g.totalVertices];
        int j = 0; //index for keeping track of answer[]
        int i = 0; //index for keeping track of sorted edges
        for (i = 0; i < g.totalVertices; ++i) {
            answer[i] = new GraphForMinimumSpanningTree.Edge();
        }
        //sort all edges by weight
        Arrays.sort(g.listEdges);
        //allocating memory to create subsets
        GraphForMinimumSpanningTree.DisjointSets mySet[] = new GraphForMinimumSpanningTree.DisjointSets[g.totalVertices];
        for (i = 0; i < g.totalVertices; ++i)
            mySet[i] = new GraphForMinimumSpanningTree.DisjointSets();
        //creating subsets
        for (int x = 0; x < g.totalVertices; ++x) {
            mySet[x].parent = x;
            mySet[x].parenthood = 0;
        }
        i = 0;

        // simply take edges sorted by weight one by one until you get vertices-1 edges.
        // ignore those that form a cycle with already picked edges in answer.
        // cycle is when both edges already belong to the same group. i.e. having same parent.
        while (j < g.totalVertices - 1) {

            GraphForMinimumSpanningTree.Edge nextEdge = new GraphForMinimumSpanningTree.Edge();
            nextEdge = g.listEdges[i++];

            int temp1 = g.find(mySet, nextEdge.source); // parent of the group of source
            int temp2 = g.find(mySet, nextEdge.destination); // parent of the group of destination

            //if cycle not formed, include edge in answer[] and unify two vertices
            if (temp1 != temp2) {
                answer[j++] = nextEdge;
                g.union(mySet, temp1, temp2); // join parents of both groups
            }
        }
        //printing contents of answer[] to display the MST
        for (i = 0; i < j; ++i)
            System.out.println(answer[i].source + " , " + answer[i].destination);

    }

}
