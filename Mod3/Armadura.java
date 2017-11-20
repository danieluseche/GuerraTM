package guerra;

// Clase armadura que me modela la armadura del guerrero 
public class Armadura {
    private int[] armadura;
    // Constructor de la clase se la pasa como parametro el numero de debilidades de la armadura
    public Armadura(int nodebilidades){
        this.armadura = generaArmadura(nodebilidades);
    }
    // Metodo que genera las debilidades de la armadura
    private int[] generaArmadura(int nodebilidades){
        int vaux[] = new int[nodebilidades];
        for (int i = 0; i < nodebilidades; i++) {
            vaux[i]= (int)(Math.random()*10);  
        }
        return vaux;
    }
    // Metodo que retorna el valor de la debilidad en la posicion i
    public int getArmadura(int i){
        return armadura[i];
    }
    // Metodo que retorna todo el vector de armadura y ademas sobrecargamos el metodo getArmadura
    public int[] getArmadura(){
        return armadura;
    }
}
