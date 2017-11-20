package guerra;

public class Marciano extends Guerrero{

    private static int total = 0;
    private String soy;

    Marciano(String soy,int nodebarmadura){
        // Al constructor del padre le pasamos como parametro el numero de debilidades que tendra la armadura de marciano
        super(soy.replace("s", ""),nodebarmadura);
        this.soy= soy.replace("s", "");
        total++;
    }
    public void recibeDisparo(int n){
        if(vivo && armaduraDestruida(n)){
            vivo = false;
            total--;
            System.out.println (soy+" Muerto por disparo num." +n);
            return ;
        }
        if(vivo)
            System.out.println("Disparo no acertado por el marciano");
    }
    
    public int getTotal(){
        return total;
    }

} ///:~


