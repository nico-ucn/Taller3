package asdasdasd;

public class HechizoPlanta extends Hechizo{
	
	private int duracionStun;

	private int cantPlanta;

public HechizoPlanta(String nombre, int dano, int duracionStun, int cantPlanta){
    super(nombre, "Planta", dano);
    
    this.duracionStun = duracionStun;
    
    this.cantPlanta = cantPlanta;
	}
	
	public int getDuracionStun(){
	    return duracionStun;
	}
	
	public void setDuracionStun(int duracionStun){
		
	    this.duracionStun = duracionStun;
	    
	}
	
	public int getCantPlanta() {
	    return cantPlanta;
	}
	
	public void setCantPlanta(int cantPlanta){
		
	    this.cantPlanta = cantPlanta;
	}
	
	@Override
	public double calcularPuntuacion(){
	    return getDano() + (this.duracionStun * this.cantPlanta);

}
}
