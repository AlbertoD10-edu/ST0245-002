import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
public class Reader
{
    LinkedList<Double> lat = new LinkedList();
    LinkedList<Double> lon = new LinkedList();
    LinkedList<Double> alt = new LinkedList();
    LinkedList<Bee> bees=new LinkedList();
    public void leer (String dir) throws IOException{
        try (BufferedReader br=new BufferedReader(new FileReader(dir))){
            String line;
            while ((line=br.readLine())!=null){
                splitString(line);
            } 
            System.out.println("Si encontró el archivo");
        } catch (IOException e){
            e.printStackTrace();
        }
        getMaxMin();
     }

    public void splitString(String s){
        String [] str=s.split(",");  
        try{
            this.lat.addFirst(Double.parseDouble(str[0]));
            this.lon.addFirst(Double.parseDouble(str[1]));
            this.alt.addFirst(Double.parseDouble(str[2]));
            Bee bee=new Bee(Double.parseDouble(str[0]),Double.parseDouble(str[1]),Double.parseDouble(str[2]));
            bees.addFirst(bee);
        } catch (Exception e){
        }
    }

    public void getMaxMin(){
        double minlat=(double)Collections.min(lat);

        double maxlat=(double)Collections.max(lat);

        double minlon=(double)Collections.min(lon);

        double maxlon=(double)Collections.max(lon);

        double minalt=(double)Collections.min(alt);

        double maxalt=(double)Collections.max(alt);

        ArrayList<Double> mins=new ArrayList();
        mins.add(minlat);
        mins.add(minlon);
        mins.add(minalt);
        double midD=(minlat-maxlat);
        double midW=(maxlon-minlon);
        double midH=(maxalt-minalt);
        double diagonal=Math.sqrt(Math.pow(midD*111111,2)+Math.pow(midW*111111,2)+Math.pow(midH,2));
        
        if (diagonal>100) {
            Octree octree=new Octree();
            octree.octree(bees,mins,midD/2,midW/2,midH/2);
        } else {
            choque(); 
        }
    }

    public void choque() {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (int i=0;i<bees.size();++i) {
            Bee bee=bees.poll();
            System.out.println(bee.getLatitud()+","+bee.getLongitud()+","+bee.getAltitude());
        }
    }
}
