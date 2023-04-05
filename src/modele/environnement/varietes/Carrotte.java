package modele.environnement.varietes;

public class Carrotte extends Legume {

    @Override
    public Varietes getVariete() {
        return Varietes.carrotte;
    }

    @Override
    protected void croissance() { //croissance(int temperature, int hydrometrie, int ensoleillement)
        // TODO
    }
}
