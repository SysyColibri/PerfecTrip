package fr.ig2i.perfectrip.interfaces;


import java.util.ArrayList;
import java.util.List;

import fr.ig2i.perfectrip.models.Lieu;

public interface AsyncResponse {
    void processFinishCallBack(ArrayList<Lieu> lieux);
}
