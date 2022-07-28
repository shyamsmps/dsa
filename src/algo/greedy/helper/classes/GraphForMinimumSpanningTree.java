package algo.greedy.helper.classes;

public class GraphForMinimumSpanningTree {

    //class to represent an edge
    public static class Edge implements Comparable<Edge> {
        public int source, destination, weight;
        public int compareTo(Edge var) {
            return this.weight - var.weight;
        }
    }

    //class to represent disjoint sets
    public static class DisjointSets {
        // p for parent. store parent info for every vertex to easily find if it belongs to same parent.
        // r is parenthood. greater r indicates it's a preferable parent.
        public int parent, parenthood;
    }

    public int totalVertices, totalEdges;
    public Edge listEdges[];

    // constructor
    public GraphForMinimumSpanningTree(int vertices, int edges) {
        totalVertices = vertices;
        totalEdges = edges;
        listEdges = new Edge[totalEdges];
        for (int i = 0; i < edges; ++i)
            listEdges[i] = new Edge();
    }

    // find of union find. return the parent of the group it belongs to.
    public int find(DisjointSets mySet[], int vertex) {
        if (mySet[vertex].parent != vertex) // if v is not its own parent, find its parent.
            mySet[vertex].parent = find(mySet, mySet[vertex].parent); // find root and make root as parent of i (path compression)
        return mySet[vertex].parent;
    }

    // merge parents of two groups
    public void union(DisjointSets mySet[], int i, int j) {
        if (mySet[i].parenthood < mySet[j].parenthood) // means j is the ultimate parent
            mySet[i].parent = j;
        else if (mySet[i].parenthood > mySet[j].parenthood) // means i is the ultimate parent
            mySet[j].parent = i;
        else { // if parenthood of two vertices is equal, randomly assign one as other's parent and increase its parenthood count to indicate who is the parent now
            mySet[j].parent = i;
            mySet[i].parenthood++;
        }
    }

}
