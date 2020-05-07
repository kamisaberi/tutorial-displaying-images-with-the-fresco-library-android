package info.devexchanges.fresco;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private SimpleDraweeView sdvImage;
    private SimpleDraweeView roundBorderImage;
    private SimpleDraweeView circleImage;
    private SimpleDraweeView fullCustomImage;

    private void findViews() {
        button = (Button) findViewById(R.id.button);
        sdvImage = (SimpleDraweeView) findViewById(R.id.sdv_image);
        roundBorderImage = (SimpleDraweeView) findViewById(R.id.round_border);
        circleImage = (SimpleDraweeView) findViewById(R.id.circle);
        fullCustomImage = (SimpleDraweeView) findViewById(R.id.full_custom_image);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        findViews();

//        final Uri imageUri = Uri.parse("https://lh3.googleusercontent.com/-voUmhKJzNHc/VSJaPfSJ2pI/AAAAAAAABKw/-oFVzRZxI40/w140-h105-p/fresh_green_grass_bokeh-wallpaper-1024x768.jpg");
        //final Uri imageUri = Uri.parse("https://i.imgur.com/tGbaZCY.jpg");
//        final Uri imageUri = Uri.parse("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Pleiades_large.jpg/1024px-Pleiades_large.jpg");
        final Uri imageUri = Uri.parse("https://upload.wikimedia.org/wikipedia/commons/f/f0/Moonset_over_ESO's_Very_Large_Telescope.jpg");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
                GenericDraweeHierarchy hierarchy = builder
                        .setFadeDuration(300)
                        .setProgressBarImage(new CustomProgressBar())
                        .build();
                //sdvImage.setHierarchy(hierarchy);
                sdvImage.setImageURI(imageUri);
                roundBorderImage.setImageURI(imageUri);
                circleImage.setImageURI(imageUri);
                fullCustomImage.setHierarchy(hierarchy);
                fullCustomImage.setImageURI(imageUri);
            }
        });
    }


    class CustomProgressBar extends Drawable {
        @Override
        public void draw(Canvas canvas) {

        }

        @Override
        public void setAlpha(int alpha) {

        }

        @Override
        public void setColorFilter(ColorFilter colorFilter) {

        }

        @Override
        public int getOpacity() {
            return 0;
        }

        @Override
        protected boolean onLevelChange(int level) {
            Log.d("TEST1" , "P : " + level);
            // level is on a scale of 0-10,000
            // where 10,000 means fully downloaded

            // your app's logic to change the drawable's
            // appearance here based on progress
            return true;
        }
    }
}
