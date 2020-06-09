import java.util.LinkedList;

public class Pfad {

    LinkedList<Integer> Liste = new LinkedList<Integer>();

    public void HintenHinzufügen(int i){
        Liste.addLast(i);
    }

    public void VorneHinzufügen(int i){
        Liste.addFirst(i);
    }

    public int GibKnotenNr(int i){
        return Liste.get(i);
    }

    public void Ausgeben(){
        int i = 0;
        System.out.print("Pfad: ");
        while (i < Liste.size()){
            System.out.print(Liste.get(i) + ", ");
            i++;
        }
        System.out.println();
    }
}
