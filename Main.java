package nulp;

// To use this class, simply call ReadGraph.readGraph(String filename)
// somewhere in your code.  This method returns a GraphInfo object which
// has four members:
//
// 	name - the name of the graph (a String)
// 	nNodes - the number of nodes (an integer)
// 	nEdges - the number of edges (an integer)
// 	edges - an array of EdgeInfo objects
//
// Each EdgeInfo object has two members, integers u and v, which are the
// labels for the nodes on that edge.
//
// Note that this method doesn't actually construct the graph data structure.
// You will need to do this yourself.  This method simply extracts all of the
// necessary data from the file, so you don't have to deal with I/O.
//
// Also note that the readGraph method returns null when either the file
// is not found, or is improperly formatted.

import java.io.*;
import java.util.*;

public class Main {
    public static GraphInfo readGraph(String filename) {
        GraphInfo g = new GraphInfo();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            g.name = br.readLine();
            g.nNodes = Integer.parseInt(br.readLine());
            g.nEdges = Integer.parseInt(br.readLine());

            g.edges = new EdgeInfo[g.nEdges];

            for (int i=0; i<g.nEdges; i++) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);

                g.edges[i] = new EdgeInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            br.close();
        }
        catch (Exception e) {
            return null;
        }

        return g;
    }
}

class GraphInfo {
    public String name;
    public int nNodes;
    public int nEdges;
    public EdgeInfo[] edges;

    public GraphInfo() {
        name = null;
        nNodes = 0;
        nEdges = 0;
        edges = null;
    }

    public String toString() {
        String s = "";

        s += "name: " + name + "\n";
        s += "nNodes: " + nNodes + "\n";
        s += "nEdges: " + nEdges + "\n";

        s += "edges: {";

        for (int i=0; i<nEdges-1; i++) {
            s += edges[i] + ",";
        }

        s += edges[nEdges-1] + "}\n";

        return s;
    }
}

class EdgeInfo {
    public int u;
    public int v;

    public EdgeInfo(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public String toString() {
        return "(" + u + "," + v + ")";
    }
}