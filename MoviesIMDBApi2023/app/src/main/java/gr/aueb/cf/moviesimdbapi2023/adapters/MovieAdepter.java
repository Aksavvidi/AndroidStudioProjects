package gr.aueb.cf.moviesimdbapi2023.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import gr.aueb.cf.moviesimdbapi2023.R;
import gr.aueb.cf.moviesimdbapi2023.models.Movie;

public class MovieAdepter extends RecyclerView.Adapter<MovieAdepter.MovieViewHolder>{

    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdepter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);
        holder.titleTV.setText(movie.getTitle());
        holder.descriptionTV.setText(movie.getDescription());

        if (!movie.getImage().isEmpty()) {
            Picasso.get().load(movie.getImage()).into(holder.imageIV);
        }
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        private MaterialTextView titleTV;
        private MaterialTextView descriptionTV;
        private ImageView imageIV;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            descriptionTV = itemView.findViewById(R.id.descriptionTV);
            imageIV = itemView.findViewById(R.id.imageIV);
        }
    }
}
