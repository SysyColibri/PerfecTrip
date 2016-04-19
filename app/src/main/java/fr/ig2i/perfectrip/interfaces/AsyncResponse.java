package fr.ig2i.perfectrip.interfaces;


import java.util.List;

import fr.ig2i.perfectrip.models.Lieu;

public interface AsyncResponse {
    void processFinishCallBack(List<Lieu> lieux);
}
