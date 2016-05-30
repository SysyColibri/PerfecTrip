package fr.ig2i.perfectrip.utils;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.ig2i.perfectrip.GlobalState;
import fr.ig2i.perfectrip.models.Activite;

public class FilesUtils {
    GlobalState gs = new GlobalState();

    public String getFilesLocation(Context ctx){
        return ctx.getFilesDir().getAbsolutePath();
    }
    public boolean set(Context ctx, String key, Object value){
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
        File dossier = ctx.getFilesDir();
        for(File fichier : dossier.listFiles()) {
            if(!fichier.isDirectory()) {
                if(fichier.getName() == "locomotion") {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean existsJson(Context ctx, JSONObject key){
        ArrayList<String> fileList = new ArrayList<String>(Arrays.asList(ctx.fileList()));
        for(String file : fileList){
            if(file.equals(key)) {
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

    public static void deleteAll(Context ctx){
        File dossier = ctx.getFilesDir();
        for(File fichier : dossier.listFiles()) {
            Log.i("test taille",String.valueOf(dossier.listFiles().length));
            Log.i("test delete",String.valueOf((fichier.delete())));
        }
    }

    public void seeAll(Context ctx){
        File dossier = ctx.getFilesDir();
        Log.i("test taille",String.valueOf(dossier.listFiles().length));
        for(File fichier : dossier.listFiles()) {
            if(!fichier.isDirectory()) {
                Log.i("test nom", ((Activite) get(ctx, fichier.getName())).getLieu().getName());
            }
        }
    }

    public ArrayList<Activite> getAll(Context ctx) {
        File dossier = ctx.getFilesDir();
        ArrayList<Activite> activites = new ArrayList<>();

        for(File fichier : dossier.listFiles()) {
            if(!fichier.isDirectory()) {
                if(fichier.getName().equals("locomotion")) {
                    gs.typeLocomotion = get(ctx,"locomotion").toString();
                }
                else if(fichier.getName().equals("sortie")) {
                    gs.typeLocomotion = get(ctx,"sortie").toString();
                }
                else {
                    Log.i("test", fichier.getName());
                    activites.add((Activite) (get(ctx, fichier.getName())));
                }
            }
        }

        return activites;
    }
}