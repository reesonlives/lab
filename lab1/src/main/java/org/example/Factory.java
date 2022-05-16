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

public class Factory {

    public String getTop(int amount) throws IOException {

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
                    String returner = "";
                    for (int i = 0; i < amount; i++){
                        returner += states.getJSONArray(i).toString() +"\n";
                    }
                    return returner;
                }

            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
        return "failed";
    }

}
