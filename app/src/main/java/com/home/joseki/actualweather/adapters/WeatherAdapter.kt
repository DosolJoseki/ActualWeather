package com.home.joseki.actualweather.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.home.joseki.actualweather.R
import com.home.joseki.actualweather.model.WeatherItem
import io.reactivex.annotations.NonNull
import java.util.ArrayList

class WeatherAdapter(private val context: Context) : RecyclerView.Adapter<WeatherAdapter.ProjectViewHolder>() {
    private val weatherItems = ArrayList<WeatherItem>()

    fun setItems(list: List<WeatherItem>) {
        weatherItems.addAll(list)
        notifyDataSetChanged()
    }

    fun clearItems() {
        weatherItems.clear()
        notifyDataSetChanged()
    }

    inner class ProjectViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        private val tvTemp: TextView = itemView.findViewById(R.id.tvTemp)
        private val tvPressure: TextView = itemView.findViewById(R.id.tvPressure)
        private val tvWind: TextView = itemView.findViewById(R.id.tvWind)

        fun bind(item: WeatherItem) {
            tvDate.text = item.dt_txt
            tvTemp.text = String.format(context.getString(R.string.temp_info), item.main!!.temp)
            tvPressure.text = item.main.pressure
            tvWind.text = item.wind!!.speed + "  " + item.wind!!.deg
        }
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): ProjectViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.weather_item, viewGroup, false)
        return ProjectViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull projectViewHolder: ProjectViewHolder, i: Int) {
        projectViewHolder.bind(weatherItems[i])
    }

    override fun getItemCount(): Int {
        return weatherItems.size
    }
}