package sg.edu.c346.id19034609.mymovies;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYearGenre = rowView.findViewById(R.id.textViewYearGenre);
        ImageView ivRated = rowView.findViewById(R.id.imageViewRated);

        // Obtain the Android Version information based on the position
        Movie currentMovie = movieList.get(position);

        // Set values to the TextView to display the corresponding information
        if (currentMovie.getYear() == 2020) {
            tvTitle.setText(currentMovie.getTitle());
            tvTitle.setTextColor(Color.parseColor("#ffcc0000"));
        }
        else {
            tvTitle.setText(currentMovie.getTitle());
        }

        tvYearGenre.setText(currentMovie.getYear() + " · " + currentMovie.getGenre());

        if (currentMovie.getRated() == "g") {
            ivRated.setImageResource(R.drawable.rating_g);
        }
        else if (currentMovie.getRated() == "pg") {
            ivRated.setImageResource(R.drawable.rating_pg);
        }
        else if (currentMovie.getRated() == "pg13") {
            ivRated.setImageResource(R.drawable.rating_pg13);
        }
        else if (currentMovie.getRated() == "nc16") {
            ivRated.setImageResource(R.drawable.rating_nc16);
        }
        else if (currentMovie.getRated() == "m18") {
            ivRated.setImageResource(R.drawable.rating_m18);
        }
        else if (currentMovie.getRated() == "r21") {
            ivRated.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }

}

