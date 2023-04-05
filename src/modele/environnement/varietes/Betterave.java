package modele.environnement.varietes;

public class Betterave extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.betterave;
    }

    @Override
    protected void croissance() {
        //TODO
        System.out.println("Une betterave pousse");
    }
}
