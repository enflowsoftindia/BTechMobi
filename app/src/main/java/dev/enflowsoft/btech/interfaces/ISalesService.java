package dev.enflowsoft.btech.interfaces;

import java.util.List;

import dev.enflowsoft.btech.models.InvoiceMasterResponse;
import dev.enflowsoft.btech.models.LoginRequest;
import dev.enflowsoft.btech.models.LoginResponse;
import dev.enflowsoft.btech.models.SalesListRequest;
import dev.enflowsoft.btech.models.SalesListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ISalesService {
    @POST("salesinvoicelist")
    Call<List<SalesListResponse>> salesinvoicelist(@Body SalesListRequest request);

    @POST("getinvoicemasters")
    Call<List<InvoiceMasterResponse>> getinvoicemasters(@Body SalesListRequest request);
}
