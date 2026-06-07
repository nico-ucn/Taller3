package asdasdasd;

import java.util.ArrayList;
import java.util.List;

public class Mago {
    
    
    private String nombre;
    
    private ArrayList <Hechizo> hechizosDominados;

    public Mago(String nombre){
        this.nombre = nombre;
        
        this.hechizosDominados = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public List<Hechizo> getHechizosDominados(){
        return hechizosDominados;
    }

    public void aprenderHechizo(Hechizo hechizo){
        this.hechizosDominados.add(hechizo);
    }
    
   
    public void olvidarHechizo(Hechizo hechizo){
        this.hechizosDominados.remove(hechizo);
    }

    public double calcularPuntuacionTotal(){
        double puntuacionTotal = 0;
        
        for (Hechizo hechizo : hechizosDominados){
            
            puntuacionTotal += hechizo.calcularPuntuacion();
        }
        
        return puntuacionTotal;
    }
}