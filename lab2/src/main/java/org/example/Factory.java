package org.example;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

public class Factory {

    public BasicAircraft[] getTop(int amount) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpGet request = new HttpGet("https://opensky-network.org/api/states/all");

            CloseableHttpResponse response = httpClient.execute(request);

            try {

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String response_content = EntityUtils.toString(entity);
                    // return it as a String
                    JSONObject result = new JSONObject(response_content);
                    JSONArray states = result.getJSONArray("states");
                    BasicAircraft[] returner = new BasicAircraft[amount];
                    for (int i = 0; i < amount; i++){
                        returner[i] = new BasicAircraft(states.getJSONArray(i).getString(0),
                                                        states.getJSONArray(i).getString(1),
                                                        new Date(states.getJSONArray(i).getInt(3)*1000),
                                                        new Coordinate(states.getJSONArray(i).getDouble(5),states.getJSONArray(i).getDouble(6)),
                                                        states.getJSONArray(i).getDouble(9),
                                                        states.getJSONArray(i).getDouble(10));
                    }
                    return returner;
                }

            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
        BasicAircraft[] empty = {};
        return empty;
    }

}
