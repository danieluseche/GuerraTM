package guerra;
// Esta es la clase manejadora que se encarga de interactuar con cada lado del guerreros (Terricolas o Marcianos)
class Tropa {
    private Guerrero[] guerreros = new Guerrero[10];
    private String somos;
    // Para esta modificacion del codigo se requiere que sigan siendo 10 soldados de cada bando
    private int cant_guerreros=10;
    // Esta variable nos ayudara a saber cuantos guerreros quedan vivos y que posiciones en el vector tiene 
    // Esta variable sera instanciada en el metodo quienesViven
    private int[] vivos;

    public Tropa (String somos){
        this.somos = somos;
        for (int i = 0; i<10; i++){
             if (somos.equals("Terricolas")){
                 guerreros [i] = new Terricola(somos);
             }
             else{
                 guerreros [i] = new Marciano(somos);
             }
        }
        System.out.println("Creado guerreros de " + somos);
    }

    public void recibeDisparo(int n){
        //System.out.println("Entramos a recibeDisparo");
        int k;
        // Siempre antes de recibir el disparo invoco al metodo quienesViven para saber que soldados estan actualmente vivos
        quienesViven();
       // System.out.println("Vivos :"+vivos.length);

        // Se generara una posicion aleatoria ( un numero ) para serle pasado como parametro como posicion al vector de guerreros
        k=(int)(Math.random()*cant_guerreros);
        // ademas llamo la funcion estaVivo para verificar que el numero generado es un numero válido de posicion.
        k = estaVivo(k);
        //System.out.println("K ha sido llamada desde recibedisparo");
        //System.out.println("K es :"+k);
        if (somos.equals("Terricolas")){
            ((Terricola)(guerreros[k])).recibeDisparo(n);
            //System.out.println("Son terricolas");
        }
        else{
            ((Marciano)(guerreros[k])).recibeDisparo(n);
          //System.out.println("Son marcianos");
        }
    }
    // En este metodo generaDisparo buscaremos que el guerrero que vaya a generar el disparo este vivo
    // para eso usaremos el metodo quienesViven
    public int generaDisparo(int i){
        //System.out.println("Entramos a generaDisparo");
        quienesViven();
        //System.out.println("Cantidad de vivos generando disparo:"+vivos.length);
        // Ademas llamaremos al metodo estaVivo para verificar el valor generado "i" 
        i = estaVivo(i);
        //System.out.println("K ha sido llamada desde generaDisparo");
        return guerreros[i].dispara();
    }
    public int cuantosQuedan(){

        if (somos.equals("Terricolas")){
            
             return ((Terricola)(guerreros[1])).getTotal();
        }
        else{
             return ((Marciano)(guerreros[1])).getTotal();
        }
    }
    /* Metodo que nos ayudara a encontrar que guerreros quedan vivos de cada bando
     * este metodo nos retornara un vector de vivos que nos es mas que las posiciones de los 
     * guerreros que estan vivos.
    */
    private void quienesViven(){
        int[] v_aux;
        int cant_guerreros_actual=0;
        /* El vector auxiliar nos ayudara a guardar las posiciones de los soldados vivos,
         * dicho sera de ancho cant_guerreros que es lo maximo que maneja la clase Tropa por guerreros (para este caso son 10).
         * Ademas la variable j nos indicara cuantos soldados estan vivos.
        */ 
        v_aux= new int[cant_guerreros];
        for (int i = 0; i <cant_guerreros; i++) {
            if (somos.equals("Terricolas")){
                if(((Terricola)(guerreros[i])).isVivo()){
                    // Si el terricola sigue vivo se guardara la posicion del vector Guerreros en el que se encuentra
                    v_aux[cant_guerreros_actual]=i;
                    // Ademas sumamos en uno la cantidad de terricolas vivos
                    cant_guerreros_actual++;
                }
            }
            else{
                // Identico para los marcianos
                if(((Marciano)(guerreros[i])).isVivo()){
                    v_aux[cant_guerreros_actual]=i;
                    cant_guerreros_actual++;
                }     
            }             
        }
        // Instanciamos el vector de vivos de tamaño cant_guerreros_actual
        vivos = new int [cant_guerreros_actual];
        
        // Almacenamos el vector auxiliar en el vector de guerreros vivos , utilzando un metodo de la clase System de Java.
        System.arraycopy(v_aux, 0, vivos, 0, cant_guerreros_actual); 
    }
    
    // Metodo que devuelve una posicion valida generada del vector de guerreros
    private int estaVivo(int k){
        /* Verificamos que k sea una posicion valida dentro del vector de guerreros , ya que vivos almacena posiciones del 
         * vector de guerreros comparamos cada posicion del vector vivos con el valor k
         * si son iguales, k es un numero aleatorio válido y por ende se sale del ciclo, si no ,hay que generar otro numero aleatorio hasta que se cumpla 
         * la condicion.
         */
        int j=0;
        while(k!=vivos[j]){
            j++;
            if(j==vivos.length){
                j=0;
                k=((int)(Math.random()*cant_guerreros));
            }
        }
        /*        for (int i = 0; i <vivos.length; i++) {
        if(somos.equals("Terricolas"))
        System.out.println("Posicion Viva de terricolas:"+vivos[i]);
        else
        System.out.println("Posicion Viva de marcianos:"+vivos[i]);
        }
        System.out.println("Sin embargo k vale:"+k);*/
        return k;
    } 
    
    public String getSomos(){
        return somos;
    }
} ///:~
