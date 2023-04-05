package modele.environnement.varietes;

public class Betterave extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.betterave;
    }

    @Override
    public void croissance(int temperature, int hydrometrie, int ensoleillement) {
        //TODO
        System.out.println("Une betterave pousse");
    }
}
