package dev.enflowsoft.btech.interfaces;

import java.util.List;

import dev.enflowsoft.btech.models.Category;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ProductService {
    @POST("getcategories")
    Call<List<Category>> getcategories();

}
