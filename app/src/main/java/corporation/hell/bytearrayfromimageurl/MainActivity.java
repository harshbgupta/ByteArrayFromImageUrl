package corporation.hell.bytearrayfromimageurl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author Harsh on 25-02-2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ByteArrayGenerator().execute("https://s3-us-west-1.amazonaws.com/powr/defaults/image-slider2.jpg");
    }
}
