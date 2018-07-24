package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Movie_details extends AppCompatActivity {
    ImageView Rated;
    RatingBar rb;
    TextView tvTitle,
            tvYear,
            tvGenre,
            tvDescription,
            tvWatch,
            tvTheatre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_item);
        Rated=findViewById(R.id.imageViewRated);
        tvTitle=findViewById(R.id.textViewTitle);
        tvYear=findViewById(R.id.textViewYear);
        tvGenre=findViewById(R.id.textViewGenre);
        tvDescription=findViewById(R.id.textViewDescription);
        tvWatch=findViewById(R.id.textViewDate);
        tvTheatre=findViewById(R.id.textViewTheatre);
        rb=findViewById(R.id.ratingBarMovie);

        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String genre = intentReceived.getStringExtra("genre");
        String description = intentReceived.getStringExtra("desc");
        String date = intentReceived.getStringExtra("Date");
        String theatre = intentReceived.getStringExtra("theatre");
        String rated = intentReceived.getStringExtra("rated");
        int rating=intentReceived.getIntExtra("rating",0);

        tvTitle.setText(title);
        tvYear.setText(year+"-");
        tvGenre.setText(genre);

        tvDescription.setText(description);
        tvWatch.setText("Watch on: "+date);
        tvTheatre.setText("In Theatre: "+theatre);
        rb.setRating(rating);

        if(rated.equalsIgnoreCase("g")){
            Rated.setImageResource(R.drawable.rating_g);

        }else if(rated.equalsIgnoreCase("pg")) {
            Rated.setImageResource(R.drawable.rating_pg);

        }else if(rated.equalsIgnoreCase("pg13")) {
            Rated.setImageResource(R.drawable.rating_pg13);

        }else if(rated.equalsIgnoreCase("nc16")) {
            Rated.setImageResource(R.drawable.rating_nc16);

        }else if(rated.equalsIgnoreCase("m18")) {
            Rated.setImageResource(R.drawable.rating_m18);

        }else{
            Rated.setImageResource(R.drawable.rating_r21);
        }
    }
}
