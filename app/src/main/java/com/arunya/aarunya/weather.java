package com.arunya.aarunya;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class weather extends AppCompatActivity {

    class WeatherInfo extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try {

                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(is);

                int data = reader.read();
                String apiDetails = "";
                char current;

                while (data != -1) {

                    current = (char) data;
                    apiDetails += current;
                    data = reader.read();

                }
                return apiDetails;


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void getWeatherInfo(View view) {

        WeatherInfo weatherInfo = new WeatherInfo();
        EditText cityEdit = (EditText) findViewById(R.id.cityName);
        TextView weatherView = (TextView) findViewById(R.id.weatherTextView);


        try {
            String WeatherApiDetails = weatherInfo.execute("http://api.openweathermap.org/data/2.5/weather?q="
                    + cityEdit.getText().toString() + "&appid=16748cf98884790842fac5cab6705dd2").get();
            Log.i("weather Api Info", WeatherApiDetails);

            JSONObject jsonObject = new JSONObject(WeatherApiDetails);

            String weather = jsonObject.getString("weather");

            JSONArray array = new JSONArray(weather);

            String main = "";
            String description = "";

            for (int i = 0; i < array.length(); i++) {

                JSONObject arrayObject = array.getJSONObject(i);
                main = arrayObject.getString("main");
                description = arrayObject.getString("description");
            }


            JSONObject weatherData = new JSONObject(jsonObject.getString("main"));

            double tempf = Double.parseDouble(weatherData.getString("temp"));
            int temp = (int) (tempf - 273.15);
            double pressure = Double.parseDouble(weatherData.getString("pressure"));
            double humidity = Double.parseDouble(weatherData.getString("humidity"));

            JSONObject cord = new JSONObject(jsonObject.getString("coord"));

            double longitude = Double.parseDouble(cord.getString("lon"));
            double latitude = Double.parseDouble(cord.getString("lat"));


            weatherView.setText("Main: " + main + "\n" +
                    "Description: " + description + "\n temp: " + temp +
                    "\n pressure: " + pressure + "\n humidity: " + humidity + "\n long: " + longitude + "\n lati: " +
                    latitude);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


    }
}
