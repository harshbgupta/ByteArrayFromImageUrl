package corporation.hell.bytearrayfromimageurl;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Harsh on 25-02-2017.
 */

public class ByteArrayGenerator extends AsyncTask<String, Integer, String> {

    public static final String TAG = "ByteArrayGenerator==>";
    HttpURLConnection connection = null;

    public ByteArrayGenerator(){
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... params) {
        String result = "";
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(30000);
            connection.setConnectTimeout(30000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            BufferedInputStream bis = new BufferedInputStream (connection.getInputStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(baos);
            int value ;
            while ((value = bis.read()) != -1) {
                bos.write(value);
            }
            result = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
            bos.close();
            baos.close();
            bis.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG,"byte Array==>"+result);
    }
}