package fr.ig2i.perfectrip;


import android.content.Context;
import android.widget.AbsListView;
import android.widget.Toast;


public class ScrollListener implements AbsListView.OnScrollListener {

    private int visibleThreshold = 0;
    private int currentPage = 0;
    private int previousTotal = 0;
    private boolean loading = true;
    private Context ctx;

    public ScrollListener() {
    }

    public ScrollListener(Context ctx) {
        this.ctx = ctx;
    }

    public ScrollListener(int visibleThreshold, Context ctx) {
        this.visibleThreshold = visibleThreshold;
        this.ctx = ctx;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
                currentPage++;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            //Faire l'appel HTTP ici
            Toast.makeText(ctx, "scrolled !!!!!!", Toast.LENGTH_SHORT).show();
            /*HTTPNextPageTokenUtils caller = new HTTPNextPageTokenUtils() {
                @Override
                public void onResponseReceived(Object result) {

                }
            };*/
            loading = true;
        }

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }
}
