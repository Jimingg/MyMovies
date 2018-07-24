package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17010144 on 24/7/2018.
 */

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> moviesList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context=context;
        layout_id=resource;
        moviesList=objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtain the LayoutInflater object.
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Inflate a new view hierarchy from the specified xml resource (layout_id)
        // and return the root View of the inflated hierarchy.
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI elements and bind them to their respective Java variable.
        TextView tvtitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvyear = rowView.findViewById(R.id.textViewYear);
        TextView tvgenre=rowView.findViewById(R.id.textViewGenre);
        ImageView rated =rowView.findViewById(R.id.imageViewRated);
        // Obtain the property values from the Data Class object
        // and set them to the corresponding UI elements.
        Movie currentItem = moviesList.get(position);
        tvtitle.setText(currentItem.getTitle());
        tvyear.setText(currentItem.getYear()+" -");
        tvgenre.setText(currentItem.getGenre());
        if (currentItem.getRated().equalsIgnoreCase("g")){
            rated.setImageResource(R.drawable.rating_g);
        }else if (currentItem.getRated().equalsIgnoreCase("pg")){
            rated.setImageResource(R.drawable.rating_pg);
        }else if (currentItem.getRated().equalsIgnoreCase("pg13")) {
            rated.setImageResource(R.drawable.rating_pg13);
        }else if (currentItem.getRated().equalsIgnoreCase("nc16")) {
            rated.setImageResource(R.drawable.rating_nc16);
        }else if (currentItem.getRated().equalsIgnoreCase("m18")) {
            rated.setImageResource(R.drawable.rating_m18);
        }else{
            rated.setImageResource(R.drawable.rating_r21);
        }


        // Return the View corresponding to the data at the specified position.
        return rowView;
    }
}
