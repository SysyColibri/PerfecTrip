package fr.ig2i.perfectrip.interfaces;


import java.util.ArrayList;

import fr.ig2i.perfectrip.models.details.Details;
import fr.ig2i.perfectrip.models.lieu.Lieu;

public interface AsyncResponse {
    void processFinishCallBackLieux(ArrayList<Lieu> lieux);
    void processFinishCallBackDetails(ArrayList<Details> details);
}
