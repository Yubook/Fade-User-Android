package com.youbook.fade

import android.os.Parcel
import android.os.Parcelable
import com.youbook.fade.ui.barber_details.Category
import com.youbook.fade.ui.barber_details.Subcategory

class Service() : Parcelable{
    var image: String? = null
    var is_active: Int? = null
    var name: String? = null
    var id: Int? = null
    var category: Category? = null
    var subcategory: Subcategory? = null
    var time: Double? = null

    constructor(parcel: Parcel) : this() {
        image = parcel.readString()
        is_active = parcel.readValue(Int::class.java.classLoader) as? Int
        name = parcel.readString()
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        time = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(image)
        parcel.writeValue(is_active)
        parcel.writeString(name)
        parcel.writeValue(id)
        parcel.writeValue(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<com.youbook.fade.Service> {
        override fun createFromParcel(parcel: Parcel): com.youbook.fade.Service {
            return com.youbook.fade.Service(parcel)
        }

        override fun newArray(size: Int): Array<com.youbook.fade.Service?> {
            return arrayOfNulls(size)
        }
    }
}