package asdasdasd;

public class HechizoTierra extends  Hechizo{
    
    private int mejoraDefensa;

    public HechizoTierra(String nombre, int dano, int mejoraDefensa){
        super(nombre, "Tierra", dano);
        
        this.mejoraDefensa = mejoraDefensa;
        
    }

    public int getMejoraDefensa(){
    	
        return mejoraDefensa;
    }

    public void setMejoraDefensa(int mejoraDefensa){
    	
        this.mejoraDefensa = mejoraDefensa;
    }

    @Override
    public double calcularPuntuacion(){
        return (getDano() * this.mejoraDefensa) / 2.0;
    }
}