package dev.enflowsoft.btech.remote;

import dev.enflowsoft.btech.interfaces.ProductService;

public class APIUtils {
    private APIUtils(){
    };

    public static final String API_URL = "http://nirishaindustries.com/api/enflowsbv137api/";
    public static final String API_FILEURL = "http://nirishaindustries.com/Files/appxa/";
    public static final String PrivacyPolicy_URL = "http://nirishaindustries.com/privacypolicy";

    public static ProductService getProductService(){
        return RetrofitClient.getClient(API_URL).create(ProductService.class);
    }
}