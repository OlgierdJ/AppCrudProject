/*package com.example.appcrudproject;

import android.telecom.Call;
import android.util.JsonReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import retrofit2.http.Body;
import retrofit2.http.POST;

public class EntityService<T extends Entity> {
    final Class<T> typeParameterClass;
    final String Api;
    final String Controller;
    public EntityService(Class<T> typeParameterClass, String Api, String Controller) {
        this.typeParameterClass = typeParameterClass;
        this.Api = Api;
        this.Controller = Controller;
    }
    public T Get(int id){
        try {

            URL url = new URL(Api+"/"+Controller+"/"+id);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();
                Gson gson = new Gson();
                T entity = gson.fromJson(inline, typeParameterClass);
                return entity;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<T> Get(){
        try {

            URL url = new URL(Api+"/"+Controller);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();
                Type userListType = new TypeToken<ArrayList<T>>(){}.getType();
                Gson gson = new Gson();
                ArrayList<T> entityArray = gson.fromJson(inline, userListType);
                return entityArray;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public T Create(T entity){
        try {

            URL url = new URL(Api+"/"+Controller);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            //conn.connect();
            Gson gson = new Gson();
            String data = gson.toJson(entity,typeParameterClass);
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = conn.getOutputStream();
            stream.write(out);
            conn.connect();
            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                // String response = conn.getResponseMessage();
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                entity = gson.fromJson(inline, typeParameterClass);
                return entity;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public T Update(T entity){
        try {

            URL url = new URL(Api+"/"+Controller+"/"+entity.getId());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();
            Gson gson = new Gson();

            String data = gson.toJson(entity,typeParameterClass);
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = conn.getOutputStream();
            stream.write(out);

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
               // String response = conn.getResponseMessage();
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                entity = gson.fromJson(inline, typeParameterClass);
                return entity;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public T Delete(int id){
        try {

            URL url = new URL(Api+"/"+Controller+"/"+id);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();
                Gson gson = new Gson();
                T entity = gson.fromJson(inline, typeParameterClass);
                return entity;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
*/