package guerra;

public class Marciano extends Guerrero{

    private static int total = 0;
    private String soy;

    Marciano(String soy){
        super(soy.replace("s", ""));
        this.soy= soy.replace("s", "");
        total++;
    }
    public void recibeDisparo(int n){
        // Hacemos un ciclo for para comparar si alguna debilidad del guerrero
        // es igual a la del disparo recibido.
        for (int i = 0; i < 3; i++) {
            if(vivo && (debilidad[i] == n)){
                vivo = false;
                total--;
                System.out.println (soy+" Muerto por disparo num." +n);
                return ;
            }
        }
        if(vivo)
            System.out.println("Disparo no acertado por el "+soy);
    }
    public int getTotal(){
        return total;
    }

} ///:~


