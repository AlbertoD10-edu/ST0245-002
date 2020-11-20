
public class Bee
{
    private double latitud;
    private double longitud;
    private double altitud;
    
    public Bee (double latitud, double longitud, double altitud){
        this.latitud=latitud;
        this.longitud=longitud;
        this.altitud=altitud;
    }

    
    public double getLatitud(){
        return latitud;
    }

    
    public double getLongitud(){
        return longitud;
    }

    public double getAltitude(){
        return altitud;
    }
}