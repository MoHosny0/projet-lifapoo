package modele.environnement.varietes;

public class Carrotte extends Legume {

    @Override
    public Varietes getVariete() {
        return Varietes.carrotte;
    }

    @Override
    public void croissance(int temperature, int hydrometrie, int ensoleillement) { //
        // TODO
    }
}
