package gesif.mx.cards;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by edgar on 24/02/17.
 */

public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder> {

    List<Data> list = Collections.emptyList();
    Context context;

    /**
     *  Constructor con dos parametros
     */
    public Recycler_View_Adapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * Es importante adicionar la clase de vista que esta entrando en el componente,
     * en este caso es View_Holder que es la clase de crea los elementos de la tarjeta "Card"
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).title);
        holder.description.setText(list.get(position).description);
        holder.imageView.setImageResource(list.get(position).imageId);
        // Se debe llamar el metdodo de animacion cuando se construye la tarjeta
        animate(holder);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * Metodo para realizar la animación
     * @param viewHolder
     */
    public void animate(RecyclerView.ViewHolder viewHolder){
        final Animation animationAnticipateOvershoot = AnimationUtils.loadAnimation(context,R.anim.bounce_interpolator);
        viewHolder.itemView.setAnimation(animationAnticipateOvershoot);
    }
}
