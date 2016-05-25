package fr.ig2i.perfectrip.utils;

import android.content.Context;

import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import fr.ig2i.perfectrip.models.Activite;

public class FilesUtils {
    public String getFilesLocation(Context ctx){
        return ctx.getFilesDir().getAbsolutePath();
    }
    public boolean set(Context ctx, String key, Activite value){
        try{
            FileOutputStream outputStream = ctx.openFileOutput(key, Context.MODE_PRIVATE);
            ObjectOutputStream objStream = new ObjectOutputStream(outputStream);

            objStream.writeObject(value);
            objStream.close();
            outputStream.close();
            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Object get(Context ctx, String key){
        try{
            FileInputStream inputStream = ctx.openFileInput(key);
            ObjectInputStream objInput = new ObjectInputStream(inputStream);
            Object result = objInput.readObject();
            objInput.close();
            inputStream.close();
            return result;
        }
        catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean existsString(Context ctx, String key){
        ArrayList<String> fileList = new ArrayList<String>(Arrays.asList(ctx.fileList()));
        for(String file : fileList){
            if(file.equals(key)){
                return true;
            }
        }
        return false;
    }

    public static boolean existsJson(Context ctx, JSONObject key){
        ArrayList<String> fileList = new ArrayList<String>(Arrays.asList(ctx.fileList()));
        for(String file : fileList){
            if(file.equals(key)){
                return true;
            }
        }
        return false;
    }

    public static boolean delete(Context ctx, String key){
        try{
            ctx.deleteFile(key);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
