import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;

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

    public Pfad Tiefensuche(int start, int ziel){
        Stack<Integer> St = new Stack<Integer>();
        boolean [] markiert = new boolean[adj.length];
        int [] vorgänger = new int[adj.length];
        // alle Werte im Vorgänger Array af -1 setzen
        Arrays.fill(vorgänger, -1);

        // Stack mit Startknoten bestücken
        St.push(start);

        int aktuellerKnoten;

        // Immer wieder obersten Knoten vom Stack nehmen
        while(!St.empty()){
            aktuellerKnoten = St.pop();

            // Wenn aktueller Knoten noch nicht marktiert ist
            if(!markiert[aktuellerKnoten]){
                // Markieren und weiter im Text
                markiert[aktuellerKnoten] = true;

                if(aktuellerKnoten == ziel){
                    return BauePfadAusVorgängerArray(vorgänger, ziel, false);
                }

                // Jeden Nachfolger überprüfen
                for(int i = 0; i < adj.length; i++){
                    // Wenn es Kante von aktuellem Knoten zu diesem Knoten gibt
                    if(IstKanteVorhanden(aktuellerKnoten, i)){
                        // dann lege diesen Knoten auf den Stack
                        if((markiert[i] == false) && (i != ziel)){
                            St.add(i);
                        }
                        // Speichere den Vorgänger des aktuellen Knotens, damit
                        // wir später wissen, wie wir hier her gekommen sind
                        if (vorgänger[i] == -1) vorgänger[i] = aktuellerKnoten;
                    }
                }
            }
        }
        throw new RuntimeException("Kein Weg vorhanden!");

    }

    public Pfad Breitensuche(int start, int ziel){
        LinkedList<Integer> Warteschlange = new LinkedList<Integer>();
        boolean [] markiert = new boolean[adj.length];
        int [] vorgänger = new int[adj.length];
        Arrays.fill(vorgänger, -1);

        Warteschlange.addFirst(start);

        int aktuellerKnoten;

        while(!Warteschlange.isEmpty()){
            aktuellerKnoten = Warteschlange.removeLast();

            // Wenn aktueller Knoten noch nicht marktiert ist
            if(!markiert[aktuellerKnoten]){
                // Markieren und weiter im Text
                markiert[aktuellerKnoten] = true;

                if(aktuellerKnoten == ziel){
                    return BauePfadAusVorgängerArray(vorgänger, ziel, true);
                }

                // Jeden Nachfolger überprüfen
                for(int i = 0; i < adj.length; i++){
                    // Wenn es Kante von aktuellem Knoten zu diesem Knoten gibt
                    if(IstKanteVorhanden(aktuellerKnoten, i)){
                        if((markiert[i] == false) && (i != start)){
                            // dann hänge diesen hinten an die Warteschlange an
                            Warteschlange.addFirst(i);
                            // Speichere den Vorgänger des aktuellen Knotens, damit
                            // wir später wissen, wie wir hier her gekommen sind
                            if (vorgänger[i] == -1) vorgänger[i] = aktuellerKnoten;
                        }
                    }
                }
            }
        }
        throw new RuntimeException("Kein Weg vorhanden!");

    }

    public Pfad BauePfadAusVorgängerArray(int[] vorgänger, int ziel, boolean reverse) {
        Pfad p = new Pfad();
        int aktuellerKnoten = ziel;
        while (aktuellerKnoten != -1){
            if (reverse == true){
                p.VorneHinzufügen(aktuellerKnoten);
                System.out.println("Vorne an Pfad angefügt: " + aktuellerKnoten);
                aktuellerKnoten = vorgänger[aktuellerKnoten];
            } else {
                p.HintenHinzufügen(aktuellerKnoten);
                System.out.println("Hinten an Pfad angefügt: " + aktuellerKnoten);
                aktuellerKnoten = vorgänger[aktuellerKnoten];
            }
        }
        return p;
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
