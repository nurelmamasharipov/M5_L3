import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(secondName)
        parcel.writeString(percentage)
        parcel.writeString(result)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<LoveModel> {
        override fun createFromParcel(parcel: Parcel): LoveModel = LoveModel(parcel)
        override fun newArray(size: Int): Array<LoveModel?> = arrayOfNulls(size)
    }
}
