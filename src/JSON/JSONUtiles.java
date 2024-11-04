package JSON;
import org.json.*;
import UI.Menu;
import java.io.*;

public class JSONUtiles {

    public static void guardarJSONObject(JSONObject obj, String nombre) {
        try(FileWriter file = new FileWriter(nombre)){
            file.write(obj.toString(4));
        }catch(IOException | JSONException e){
            e.printStackTrace();
        }
    }

    public static void guardarJSONArray(JSONArray array, String nombre) {
        try(FileWriter file = new FileWriter(nombre)){
            file.write(array.toString(4));
        }catch(IOException | JSONException e){
            e.printStackTrace();
        }
    }

    public static String leerArchivo(String nombre) {
       StringBuilder contenido = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(nombre));
            String linea;

            while((linea = br.readLine()) != null){
                contenido.append(linea);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return contenido.toString();
    }
}
