package dev.enflowsoft.btech.interfaces;

import java.util.List;

import dev.enflowsoft.btech.models.Customer;
import dev.enflowsoft.btech.models.Item;
import dev.enflowsoft.btech.models.ListRequest;
import dev.enflowsoft.btech.models.SalesListRequest;
import dev.enflowsoft.btech.models.SalesListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IMasterService {
    @POST("getallcustomers")
    Call<List<Customer>> getallcustomers(@Body ListRequest request);

    @POST("getallitems")
    Call<List<Item>> getallitems(@Body ListRequest request);
}
