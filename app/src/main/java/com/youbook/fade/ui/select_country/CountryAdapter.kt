package com.youbook.fade.ui.select_country

import CountryFlags.getCountryFlagByCountryCode
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.youbook.fade.databinding.ItemCountryBinding
import com.youbook.fade.ui.login.LoginActivity
import com.youbook.fade.ui.login.ResultItem
import com.youbook.fade.utils.Utils.visible

class CountryAdapter(
    private val context: Context,
    private val selectedCountry: LoginActivity.SelectedCountry,
    private val itemClick: ((item: ResultItem, position: Int) -> Unit)? = null
) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    private val countryList = ArrayList<ResultItem?>()

    class ViewHolder(val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding = ItemCountryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countryList[position]

        if (selectedCountry.selectedCountryId == "${country!!.id}") {
            holder.binding.ivCheckMark.visible(true)
        } else {
            holder.binding.ivCheckMark.visible(false)
        }
        holder.binding.tvCountry.text = country!!.name.toString()
        holder.binding.tvFlag.text = getCountryFlagByCountryCode(country.iso2!!)
        holder.binding.tvCountryCode.text = "+${country.phonecode.toString()}"

        holder.itemView.setOnClickListener {
            itemClick!!.invoke(country, position)
        }
    }

    override fun getItemCount(): Int = countryList.size

    fun updateList(newNotification: ArrayList<ResultItem?>) {
        countryList.clear()
        countryList.addAll(newNotification)
        notifyDataSetChanged()
    }
}