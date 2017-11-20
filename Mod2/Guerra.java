package guerra;
/*  Importamos la clase scanner de java.util  
 *  esta clase nos ayudara a leer los datos de entrada por consola
 *  en el contructor de la clase
 */
import java.util.Scanner;

final class Guerra {
	
    private Tropa guerreros1, guerreros2;
    // Para que en la guerra no haya ventajas los primeros en disparar seran guerreros1
    // entonces asignamos a guerreros1 y guerreros2 de forma aleatoria
    // de esta manera guerreros1 puede ser tanto marcianos como terricolas
    public Guerra(){
        // Variable booleana que me indicara si modificar o no las condiciones inciales de la guerra
        boolean mod = cargaGuerra();
        if((int)(Math.random()*2)==0){
            guerreros1 = new Tropa("Terricolas" , mod);
            guerreros2 = new Tropa( "Marcianos" , mod);
        }
        else{
            guerreros1 = new Tropa( "Marcianos" , mod);
            guerreros2 = new Tropa("Terricolas" , mod);  
        }
        empiezaGuerra();
    }

    public void empiezaGuerra(){

        do{
            // Generamos posiciones aleatorias iniciales para que cada ejercito
            // posiciones iniciales para cada ejercito , cada numero generado representa la posicion de el vector de guerreros, es decir , la posicion
            // del guerrero que va a disparar.
            int i=(int)(Math.random()*10); 
            int j=(int)(Math.random()*10); 
            //System.out.println("Terricolas:"+guerreros1.cuantosQuedan());
            //System.out.println("Marcianos:"+guerreros2.cuantosQuedan());
            guerreros2.recibeDisparo(guerreros1.generaDisparo(i));
            // Con esto hacemos doble verificacion si algun ejercito se queda sin guerreros se sale del ciclo 
            // es decir la guerra acaba.
            if(guerreros1.cuantosQuedan()==0)  
                break;
            else if(guerreros2.cuantosQuedan()==0)
                break;
            guerreros1.recibeDisparo(guerreros2.generaDisparo(j));
            
        }while(guerreros1.cuantosQuedan()>0 && guerreros2.cuantosQuedan()>0);
        //Metodo que verifica el ganador de la guerra
        quienGana();
    }
    // Funcion que verifica quien gana 
    private void quienGana(){
        if( guerreros1.cuantosQuedan()>0 && guerreros1.getSomos().equals("Terricolas")){
            System.out.println("GANARON LOS TERRICOLAS!!!!!");
        }
        else if (guerreros1.cuantosQuedan()>0 && guerreros1.getSomos().equals("Marcianos") ){
            System.out.println("GANARON LOS MARCIANOS");
        }
        else if (guerreros2.cuantosQuedan()>0 && guerreros2.getSomos().equals("Terricolas") ){
            System.out.println("GANARON LOS TERRICOLAS!!!!!");
        }
        else
            System.out.println("GANARON LOS MARCIANOS");
    }
    // Metodo que verifica si el usuario quiere cambiar las condiciones iniciales de la guerra
    private boolean cargaGuerra(){
	Scanner lectura = new Scanner(System.in);
        String resp;
	System.out.println("¿ Desea modificar las condiciones iniciales del guerra ? S/N :");
	resp = lectura.next();
        // Si el usuario quiere modificar las condiciones entonces retornara verdadero
        return (resp.equals("S") || resp.equals("s"));
    }

} ///:~

