package modele.environnement.varietes;

public abstract class Legume {
    public abstract Varietes getVariete();
     public void nextStep() {  //nextStep(int temp, int hydro, int ensol)
        croissance(); //croissance(temp,hydro,ensol)
    }


    protected abstract void croissance(); // définir selon les conditions
}
//croissance(int temperature, int hydrometrie, int ensoleillement);