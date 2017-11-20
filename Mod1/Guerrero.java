package guerra;

// Esta clase ha sido modificada en el metodo dispara
public abstract class Guerrero extends SerVivo {
	
	protected int[] debilidad;
	private final String soy;
    public Guerrero (String soy){
        debilidad = generaBlanco();
        this.soy = soy;
    }
    // En este metodo se mejoro el hecho de que verificara si el guerrero estaba vivo para poder
    // disparar , con las nuevas modificaciones en la clase tierra ya no es necesario hacer dicha verificacion
    // ya que ahora se garantiza que el guerrero que dispara siempre sera un guerrero vivo.
    public int dispara (){
        int disparo = ((int)(Math.random()*10));
        System.out.println(soy+" Dispara num." +disparo);
        return disparo;   
    }
    public int [] getBlanco(){
        return debilidad;
    }
    // Metodo generaBlanco ahora en vez de generar un solo blanco
    // siempre me generara tres blancos y los devolvera como un vector
    // de blancos.
    private int[] generaBlanco (){
        int[] v = new int[3];
            for (int i = 0; i < 3; i++){
                v[i]=(int)(Math.random()*10); 
            }
        return v;
    }

} ///:~