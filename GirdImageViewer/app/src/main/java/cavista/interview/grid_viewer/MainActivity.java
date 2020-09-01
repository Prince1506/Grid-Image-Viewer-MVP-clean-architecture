package cavista.interview.grid_viewer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.galleryactivity.R;

import cavista.interview.grid_viewer.core.di.CoreDI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CoreDI.getDStvComponent().inject(this);
    }
}