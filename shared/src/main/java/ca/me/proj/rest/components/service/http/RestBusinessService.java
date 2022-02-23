package ca.me.proj.rest.components.service.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RestBusinessService {

    public HttpURLConnection getApiConnection(String theURL) {
        try {
            // the URL: "https://the API address..."
            URL urlForGetRequest = new URL(theURL);
            return (HttpURLConnection) urlForGetRequest.openConnection();

        } catch (Exception ex) {
            // Something is wrong
            log.error(getClass().getName() + "::getAPIConnection: Unable to get connection.");
            log.error(ex.getMessage());
            log.debug(getClass().getName(), ex);
            return null;
        }
    }

    public Integer doGetRequest(HttpURLConnection connection) {
        try {

            connection.setRequestMethod("GET");

            return connection.getResponseCode();

        } catch (IOException ex) {
            // Something is wrong
            log.error(getClass().getName() + "::doGetRequest: Unable to do get request.");
            return null;
        }
    }

    public Integer doPostRequest(HttpURLConnection connection, String request,
            String acceptLanguage) {
        try {

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language",
                    acceptLanguage == null ? "en" : acceptLanguage);

            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(request.getBytes());
            outputStream.flush();
            outputStream.close();

            return connection.getResponseCode();

        } catch (IOException e) {
            log.error(getClass().getName() + "::doPostRequest: Unable to do post request.");
            return null;
        }
    }

    public Integer doPutRequest(HttpURLConnection connection, String request,
            String acceptLanguage) {
        try {

            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language",
                    acceptLanguage == null ? "en" : acceptLanguage);

            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(request.getBytes());
            outputStream.flush();
            outputStream.close();

            return connection.getResponseCode();

        } catch (IOException e) {
            log.error(getClass().getName() + "::doPostRequest: Unable to do put request.");
            return null;
        }
    }

    public Integer doDeleteRequest(HttpURLConnection connection, String acceptLanguage) {
        try {

            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language",
                    acceptLanguage == null ? "en" : acceptLanguage);
            connection.connect();

            return connection.getResponseCode();

        } catch (IOException e) {
            log.error(getClass().getName() + "::doDeleteRequest: Unable to do delete request.");
            return null;
        }
    }

    public String getData(String url, String sourceMethod) {

        HttpURLConnection connection = getApiConnection(url);

        // Get response code
        Integer responseCode = doGetRequest((HttpURLConnection) connection);
        if (responseCode == null) {
            log.error(sourceMethod + ": HTTP error code : null");
            return null;
        } else if (responseCode != HttpURLConnection.HTTP_OK) {
            log.error(sourceMethod + ": HTTP error code : " + responseCode);
            return null;
        }

        return getResponse(connection);

    }

    // post operation to the API and get results
    public String postData(String data, String url, String sourceMethod, Locale locale) {

        HttpURLConnection connection = getApiConnection(url);

        // Get response code
        Integer responseCode = doPostRequest(connection, data, locale.toLanguageTag());
        if (responseCode == null) {
            log.error(sourceMethod + ": HTTP error code : null");
            return null;
        } else if (responseCode != HttpURLConnection.HTTP_OK) {
            log.error(sourceMethod + ": HTTP error code : " + responseCode);
            return null;
        }

        return getResponse(connection);

    }

    public Integer saveData(String data, String url, String sourceMethod, Locale locale) {

        HttpURLConnection connection = getApiConnection(url);

        // Get response code
        Integer responseCode = doPutRequest(connection, data, locale.toLanguageTag());
        if (responseCode == null) {
            log.error(sourceMethod + ": HTTP error code : null");
            return null;
        } else if (responseCode != HttpURLConnection.HTTP_OK) {
            log.error(sourceMethod + ": HTTP error code : " + responseCode);
            return null;
        }

        return responseCode;
    }

    private String getResponse(URLConnection connection) {
        try {
            String readLine = null;
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();

            // return the JSON string
            return response.toString();

        } catch (Exception ex) {
            log.error(
                    getClass().getName() + "::getResponse: Unable to get responsing json string.");
            return null;
        }
    }
}
