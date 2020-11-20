import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
public class Octree
{
    private double midD,midW,midH;

    public void octree(LinkedList<Bee> abejas,ArrayList<Double> mins,double midD,double midW,double midH) {
        this.midD=midD;
        this.midW=midW;
        this.midH=midH;

        if(abejas.size()<=1){
            return;
        }
         else{

           ArrayList< LinkedList<Bee> > arbol=new ArrayList<>();
            
            for(int j=0;j<8;j++){
                LinkedList<Bee> lista=new LinkedList();
                arbol.add(lista); 
            }

            
            ArrayList<Double> mids=getMids(abejas);
            for(Bee abeja:abejas){

                arbol.get(this.hashing(abeja,mids)).add(abeja);
            }

            for(int i=0;i<8;i++){
                ArrayList<Double> minimos =getMins(arbol.get(i));

                
                double ph=Math.sqrt(Math.pow((midD)*111111,2)+Math.pow((midW)*111111,2));
                double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((midH),2));

                
                if(diagonal<100){
                    choque(arbol.get(i));
                }else {

                    
                    nuevoOctree(arbol.get(i),minimos,i);
                }
            }
        }
    }

    private int hashing(Bee abeja,ArrayList<Double> mids) {
        int hashNum=0;
        double midLatitud= mids.get(0);
        double midLongitud= mids.get(1);
        double midAltura= mids.get(2);

        double latitud= abeja.getLatitud();
        double longitud= abeja.getLongitud();
        double altura=abeja.getAltitude();

        if(latitud<=midLatitud && longitud<=midLongitud && altura<=midAltura){
            hashNum=0;
        }
        if(latitud<=midLatitud && longitud>midLongitud && altura<=midAltura){
            hashNum=1;
        }
        if(latitud>midLatitud && longitud<=midLongitud && altura<=midAltura){
            hashNum=2;
        }
        if(latitud>midLatitud && longitud>midLongitud && altura<=midAltura){
            hashNum=3;
        }
        if(latitud<=midLatitud && longitud<=midLongitud && altura>midAltura){
            hashNum=4;
        }
        if(latitud<=midLatitud && longitud>midLongitud && altura>midAltura){
            hashNum=5;
        }
        if(latitud>midLatitud && longitud<=midLongitud && altura>midAltura){
            hashNum=6;
        }
        if(latitud>midLatitud && longitud>midLongitud && altura>midAltura){
            hashNum=7;
        }

        return hashNum;
     } 

     public void nuevoOctree(LinkedList<Bee> abejas,ArrayList<Double> mins,int sector) {

       
        if(abejas.size()<=1){
            return;
        }
        else{

            ArrayList< LinkedList<Bee> > arbol=new ArrayList<>();

            
            for(int j=0;j<8;j++){
                LinkedList<Bee> lista=new LinkedList();
                arbol.add(lista);
            }

            ArrayList<Double> mids= getMids(abejas);
            for(Bee abeja: abejas){

                arbol.get(this.hashing(abeja, mids)).add(abeja);
            }

            for(int i=0;i<8;i++){
                if(arbol.get(i).size()!=0){
                    
                    double ph=Math.sqrt(Math.pow((midD)*111111,2)+Math.pow((midW)*111111,2));
                    double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((midH),2));

                    
                    if(diagonal<100){
                        choque(arbol.get(i));
                    }else {

                        
                        nuevoOctree(arbol.get(i),getMins(arbol.get(i)),i);
                    }
                }

            }
        }

     }

    public ArrayList<Double> getMins(LinkedList<Bee> abejas){
        ArrayList<Double> mins=new ArrayList();
        if(abejas.size()!=0){
            LinkedList<Double> lat = new LinkedList();
            LinkedList<Double> lon = new LinkedList();
            LinkedList<Double> alt = new LinkedList();

            for(Bee abeja: abejas){
                lat.addFirst(abeja.getLatitud()); 
                lon.addFirst(abeja.getLongitud()); 
                alt.addFirst(abeja.getAltitude()); 
            }

            double minlat=(double)Collections.min(lat);

            double minlon=(double)Collections.min(lon);

            double minalt=(double)Collections.min(alt);

            mins.add(minlat);
            mins.add(minlon);
            mins.add(minalt);
        }

        return mins;
    }

    public ArrayList<Double> getMaxs(LinkedList<Bee> abejas){
        ArrayList<Double> maxs=new ArrayList();
        if(abejas.size()!=0){
            LinkedList<Double> lat = new LinkedList();
            LinkedList<Double> lon = new LinkedList();
            LinkedList<Double> alt = new LinkedList();

            for(Bee abeja: abejas){
                lat.addFirst(abeja.getLatitud()); 
                lon.addFirst(abeja.getLongitud()); 
                alt.addFirst(abeja.getAltitude()); 
            }

            double maxlat=(double)Collections.max(lat);

            double maxlon=(double)Collections.max(lon);

            double maxalt=(double)Collections.max(alt);

            maxs.add(maxlat);
            maxs.add(maxlon);
            maxs.add(maxalt);
        }

        return maxs;
    }

    public ArrayList<Double> getMids(LinkedList<Bee> abejas){
        ArrayList<Double> mids=new ArrayList();
        if(abejas.size()!=0){
            ArrayList<Double> minimos=getMins(abejas);
            ArrayList<Double> maximos=getMaxs(abejas);

            double midlat = (maximos.get(0)-minimos.get(0))/2;
            midlat=minimos.get(0)+midlat;

            double midlon = (maximos.get(1)-minimos.get(1))/2;
            midlon=minimos.get(1)+midlon;

            double midalt = (maximos.get(2)-minimos.get(2))/2;
            midalt=minimos.get(2)+midalt;
           
            mids.add(midlat);
            mids.add(midlon);
            mids.add(midalt);
        }

        return mids;
    }

    public void choque(LinkedList<Bee> abejas) {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (Bee abeja:abejas) {
            System.out.println(abeja.getLatitud()+","+abeja.getLongitud()+","+abeja.getAltitude());
        }
    }

}
