import java.util.Scanner;
class PageRank {
    private Digraph graph;
}

class WebSearch {

}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // read the first line of the input to get the number of vertices
        int v = Integer.parseInt(sc.nextLine());
        // iterate count of vertices times
        for (int i = 0; i < v; i++) {
            String[] line = sc.nextLine().split(" ");
            int vertex = Integer.parseInt(line[0]);
            Bag<Integer> bag = new Bag<Integer>();
            bag.add(Integer.parseInt(line[1]));
        }
        Digraph graph = new Digraph(v);
        // to read the adjacency list from std input
        // and build the graph
        
        
        // Create page rank object and pass the graph object to the constructor
        
        // print the page rank object
        
        // This part is only for the final test case
        
        // File path to the web content
        String file = "WebContent.txt";
        
        // instantiate web search object
        // and pass the page rank object and the file path to the constructor
        
        // read the search queries from std in
        // remove the q= prefix and extract the search word
        // pass the word to iAmFeelingLucky method of web search
        // print the return value of iAmFeelingLucky
        
    }
}
