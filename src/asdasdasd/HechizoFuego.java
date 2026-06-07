package asdasdasd;

public class HechizoFuego extends Hechizo{
 
	private int duracionQuemadura;

    public HechizoFuego(String nombre, int dano, int duracionQuemadura){

    	super(nombre, "Fuego", dano); 
    	
        this.duracionQuemadura = duracionQuemadura;
    }

    public int getDuracionQuemadura(){
    	
        return duracionQuemadura;
    }
    
    public void setDuracionQuemadura(int duracionQuemadura){
    	
        this.duracionQuemadura = duracionQuemadura;
    }
    
    @Override
    public double calcularPuntuacion(){
        return getDano() * this.duracionQuemadura;
    }
}