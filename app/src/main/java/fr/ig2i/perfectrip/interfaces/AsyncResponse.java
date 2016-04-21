package fr.ig2i.perfectrip.interfaces;


import java.util.ArrayList;

import fr.ig2i.perfectrip.models.Lieu;

public interface AsyncResponse {
    void processFinishCallBack(ArrayList<Lieu> lieux);
}
