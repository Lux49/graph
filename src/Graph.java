import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    int[][] adj;

    public Graph(int anzahlKnoten) {
        adj = new int[anzahlKnoten][anzahlKnoten];
    }

    public void KanteZiehen(int von, int nach) {
        adj[von][nach] ++;
    }

    public void KanteEntfernen(int von, int nach) {
        adj[von][nach] --;
    }

    public boolean IstKanteVorhanden(int von, int nach) {
        return (adj[von][nach] > 0);
    }

    public int GibAnzahlKantenZwischen(int von, int nach) {
        return adj[von][nach];
    }

    public void Tiefensuche(int start, int ziel){
        //TODO: implement Tiefensuche
    }

    public void Ausgeben(){
        System.out.print("\nGraph hat " + this.adj.length + " Knoten. \n");
        for(int x = 0; x < this.adj.length; x++){
            for(int y = 0; y < this.adj[0].length; y++){
                if(adj[x][y] > 0) {
                    System.out.println("Kante von " + x + " nach " + y);
                }
            }
        }
        System.out.println();
    }

    public void AusgebenAlsTabelle(){
        // printing first line of grid
        System.out.print("+-----+");
        for(int i = 0; i < adj.length; i++){
            System.out.print("-----+");
        }
        System.out.println();

        // first row of numbers
        System.out.print("| adj ‖  ");
        for(int i = 0; i < adj.length; i++){
            System.out.print(i + "  |  ");
        }
        System.out.println();

        // separating line
        System.out.print("+=====+");
        for(int i = 0; i < adj.length; i++){
            System.out.print("=====+");
        }
        System.out.println();

        for(int x = 0; x < this.adj.length; x++) {
            System.out.print("|  " + x + "  ‖  ");
            for(int y = 0; y < this.adj[0].length; y++){
                System.out.print(adj[y][x] + "  |  ");
            }
            System.out.println();

            // Printing the grid
            System.out.print("+-----+");
            for(int i = 0; i < adj.length; i++){
                System.out.print("-----+");
            }
            System.out.println();
        }
    }
}
