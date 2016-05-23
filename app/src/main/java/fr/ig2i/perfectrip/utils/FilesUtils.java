package fr.ig2i.perfectrip.utils;

import android.content.Context;

import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FilesUtils {
    public String getFilesLocation(Context ctx){
        return ctx.getFilesDir().getAbsolutePath();
    }
    public boolean set(Context ctx, String key, String value){
        try{
            FileOutputStream outputStream = ctx.openFileOutput(key, Context.MODE_PRIVATE);
            outputStream.write(value.getBytes());
            outputStream.close();
            return true;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public String get(Context ctx, String key){
        try{
            FileInputStream inputStream = ctx.openFileInput(key);
            byte[] buffer =   new byte[(int) inputStream.getChannel().size()];
            inputStream.read(buffer);
            inputStream.close();
            String result = new String(buffer);
            return result;
        }
        catch(IOException e) {
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

    public boolean delete(Context ctx, String key){
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
