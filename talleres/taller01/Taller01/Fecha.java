  import java.time.LocalDate;

public class Fecha {
   
    public int dia;
    public final int mes;
    public int anio;

    
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

     public int dia() {
        return this.dia;
    }

    public int mes() {
       return this.mes;
    }

    public int anio() {
        return this.anio;
    }

    public String toString() {
        String texto = "Fecha: ";
        texto = texto + this.dia + "/";
        texto = texto + this.mes + "/";
        texto = texto + this.anio + ".";
        return texto;
    }
}