package modele.environnement.varietes;

public abstract class Legume {
    public abstract Varietes getVariete();


    public void nextStep(int temp, int hydro, int ensol) {  
        
        croissance(temp,hydro,ensol);
    }


    public abstract void croissance(int temperature, int hydrometrie, int ensoleillement); // définir selon les conditions
}
