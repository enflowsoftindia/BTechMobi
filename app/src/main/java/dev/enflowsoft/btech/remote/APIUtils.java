package dev.enflowsoft.btech.remote;

import dev.enflowsoft.btech.interfaces.IDeliveryService;
import dev.enflowsoft.btech.interfaces.ILoginService;
import dev.enflowsoft.btech.interfaces.IMasterService;
import dev.enflowsoft.btech.interfaces.ISalesService;
import dev.enflowsoft.btech.interfaces.ProductService;

public class APIUtils {
    private APIUtils(){
    };

    public static final String API_URL = "http://nirishaindustries.com/api/enflowsbv137api/";
    public static final String API_FILEURL = "http://nirishaindustries.com/Files/appxa/";
    public static final String PrivacyPolicy_URL = "http://nirishaindustries.com/privacypolicy";

    public static ILoginService postUserLogin(){
        return RetrofitClient.getClient(API_URL).create(ILoginService.class);
    }

    public static ISalesService postSales(){
        return RetrofitClient.getClient(API_URL).create(ISalesService.class);
    }

    public static IDeliveryService postDelivery(){
        return RetrofitClient.getClient(API_URL).create(IDeliveryService.class);
    }

    public static IMasterService postMasters(){
        return RetrofitClient.getClient(API_URL).create(IMasterService.class);
    }

    public static ProductService getProductService(){
        return RetrofitClient.getClient(API_URL).create(ProductService.class);
    }
}
