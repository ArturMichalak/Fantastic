package arturmichalak.fantastic.http;

import java.util.List;

import arturmichalak.fantastic.http.DTO.CategoryDTO;
import arturmichalak.fantastic.http.DTO.FakeDTO;
import arturmichalak.fantastic.http.DTO.QuestionDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Test {

    //@GET("api/test/{category}/{count}")
    //Call<List<QuestionDTO>> getTest(@Path("category") int categoryId, @Path("count") int questionCount);

    //@GET("categories")
    //Call<List<CategoryDTO>> fetchCategories();

    @GET("todos")
    Call<List<FakeDTO>> fetchFake();
}
