package fr.isen.jean.androiderestaurant.model

import com.google.gson.annotations.SerializedName
import fr.isen.jean.androiderestaurant.model.Items

data class Data (

  @SerializedName("name_fr" ) var nameFr : String?          = null,
  @SerializedName("name_en" ) var nameEn : String?          = null,
  @SerializedName("items"   ) var items  : ArrayList<Items> = arrayListOf()

):java.io.Serializable