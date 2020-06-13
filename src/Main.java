public class Main {

    public static void main(String[] args){
        Graph g1 = new Graph(6);

        g1.KanteZiehen(0,2);
        g1.KanteZiehen(2,1);
        g1.KanteZiehen(1,3);
        g1.KanteZiehen(2,3);
        g1.KanteZiehen(0,1);
        g1.KanteZiehen(1,0);
        g1.KanteZiehen(3,2);
        g1.KanteZiehen(2,4);
        g1.KanteZiehen(3,5);
        g1.KanteZiehen(4,5);
        g1.KanteZiehen(5,1);

        g1.AusgebenAlsTabelle();

        //Pfad p = g1.Tiefensuche(0,5);
        Pfad p = g1.Breitensuche(0,5);
        p.Ausgeben();
    }
}
