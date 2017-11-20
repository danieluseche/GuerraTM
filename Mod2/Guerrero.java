package guerra;

// Esta clase ha sido modificada en el metodo dispara
public abstract class Guerrero extends SerVivo {
    
    private final String soy;
    protected Armadura armadura;
    
    public Guerrero (String soy,int nodebarmadura){
        this.soy = soy;
        armadura = new Armadura(nodebarmadura);
    }
    // En este metodo se mejoro el hecho de que verificara si el guerrero estaba vivo para poder
    // disparar , con las nuevas modificaciones en la clase tierra ya no es necesario hacer dicha verificacion
    // ya que ahora se garantiza que el guerrero que dispara siempre sera un guerrero vivo.
    public int dispara (){
        int disparo = ((int)(Math.random()*10));
        System.out.println(soy+" Dispara num." +disparo);
        return disparo;   
    }
    
    /* Metodo que compara la posicion de las debilidades de cada armadura con el disparo
     * Si el disparo es igual a una debilidad de alguna posicion de la armadura entonces
     * la funcion retorna verdadero caso contrario retorna falso
     */
    public boolean armaduraDestruida(int n){
        for (int i = 0; i < armadura.getArmadura().length ; i++) {
            if(armadura.getArmadura(i)==n)
                return true;
        }
        return false;
    }


} ///:~