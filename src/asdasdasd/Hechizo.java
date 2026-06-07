package asdasdasd;


public abstract class Hechizo implements ImpactoHechizo{
    
    private String nombre;
    
    private String tipo;
    
    private int dano;

    public Hechizo(String nombre, String tipo, int dano){
    	
        this.nombre = nombre;
        
        this.tipo = tipo;
        
        this.dano = dano;
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public int getDano(){
        return dano;
    }
    
    
    
    
}