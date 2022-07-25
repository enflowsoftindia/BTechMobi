package dev.enflowsoft.btech.interfaces;

import java.util.List;

import dev.enflowsoft.btech.models.Category;
import dev.enflowsoft.btech.models.LoginRequest;
import dev.enflowsoft.btech.models.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ILoginService {
    @POST("userlogin")
    Call<LoginResponse> callUserLogin(@Body LoginRequest request);
}
