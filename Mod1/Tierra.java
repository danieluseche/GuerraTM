package guerra;

/* Esta clase contiene a la clase guerra
 * ya que la guerra se efectua en tierra
 */
public class Tierra {
    // Declaramos un objeto tipo guerra ya que en tierra se llevara acabo una guerra
    Guerra guerra;
    
    public Tierra(){
        guerra= new Guerra();
    }

    public static void main(String[] args){
        new Tierra();
    }
    
}
