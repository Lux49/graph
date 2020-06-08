public class Main {

    public static void main(String[] args){
        Graph g1 = new Graph(4);

        g1.KanteZiehen(0,2);
        g1.KanteZiehen(2,1);
        g1.KanteZiehen(1,3);
        g1.KanteZiehen(2,3);
        g1.KanteZiehen(0,1);
        g1.KanteZiehen(1,0);

        //g1.Ausgeben();
        g1.AusgebenAlsTabelle();
    }
}
