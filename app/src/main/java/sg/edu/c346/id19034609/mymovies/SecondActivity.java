package sg.edu.c346.id19034609.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ImageView ivRated;
    TextView tvTitle, tvYearGenre, tvDescription, tvWatchOn, tvTheatre;
    RatingBar rbRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ivRated = findViewById(R.id.imageViewRated);
        tvTitle = findViewById(R.id.textViewTitle);
        tvYearGenre = findViewById(R.id.textViewYearGenre);
        tvDescription = findViewById(R.id.textViewDescription);
        tvWatchOn = findViewById(R.id.textViewWatchOn);
        tvTheatre = findViewById(R.id.textViewInTheatre);
        rbRating = findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();

        tvTitle.setText(intentReceived.getStringExtra("title"));
        tvYearGenre.setText(intentReceived.getIntExtra("year",0) + " · " + intentReceived.getStringExtra("genre"));
        tvDescription.setText(intentReceived.getStringExtra("description"));
        tvWatchOn.setText("Watch on: " + intentReceived.getStringExtra( "watchDate"));
        tvTheatre.setText("In Theatre: " + intentReceived.getStringExtra("theatre"));
        rbRating.setRating(intentReceived.getFloatExtra("rating", 0));
    }
}