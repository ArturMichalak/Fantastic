package arturmichalak.fantastic.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {
    private static volatile Retrofit retrofit;
    private static String BASE_URL = "http://aspdotnetserver.azurewebsites.net/api/";
    private static final Object mutex = new Object();

    public static Retrofit getInstance(String url) {
        if (retrofit == null) {
            synchronized (mutex) {
                if (retrofit == null) {
                    if (!url.equals("")) BASE_URL = url;
                    retrofit = new retrofit2.Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
