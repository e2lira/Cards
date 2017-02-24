package gesif.mx.cards;

import android.view.View;

/**
 * Created by edgar on 24/02/17.
 */

public interface RecyclerViewItemClickListener {
    public void onClick(View view, int position);
    public void onLongClick(View view, int position);
}
