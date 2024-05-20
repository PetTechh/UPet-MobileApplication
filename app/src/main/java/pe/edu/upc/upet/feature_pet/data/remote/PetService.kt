package pe.edu.upc.upet.feature_pet.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PetService {

    @GET("pets")
    fun getAll(): Call<List<PetResponse>>
    @GET("pets/{petowner_id}")
    fun getByOwnerId(@Path("petowner_id") petowner_Id: Int): Call<List<PetResponse>>

    @POST("pets")
    fun createPet(@Body petRequest: PetRequest): Call<PetResponse>

}