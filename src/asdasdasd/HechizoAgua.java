package asdasdasd;

public class HechizoAgua extends Hechizo {
	private int cantidadHeal;
	
    private int presionDeAgua;

    public HechizoAgua(String nombre, int dano, int cantidadHeal, int presionDeAgua){
        super(nombre, "Agua", dano);
        
        this.cantidadHeal = cantidadHeal;
        
        this.presionDeAgua = presionDeAgua;
    }

    public int getCantidadHeal(){
        return cantidadHeal;
    }

    public void setCantidadHeal(int cantidadHeal){
    	
        this.cantidadHeal = cantidadHeal;
    }

    public int getPresionDeAgua(){
        return presionDeAgua;
    }

    public void setPresionDeAgua(int presionDeAgua) {
        this.presionDeAgua = presionDeAgua;
    }

    @Override
    public double calcularPuntuacion() {
        return (getDano() + this.cantidadHeal + this.presionDeAgua) * 2;
    }

}
