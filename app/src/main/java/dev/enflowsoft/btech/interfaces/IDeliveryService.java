package dev.enflowsoft.btech.interfaces;

import java.util.List;

import dev.enflowsoft.btech.models.DeliveryListRequest;
import dev.enflowsoft.btech.models.DeliveryListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IDeliveryService {
    @POST("deliverychallanlist")
    Call<List<DeliveryListResponse>> deliverychallanlist(@Body DeliveryListRequest request);
}
