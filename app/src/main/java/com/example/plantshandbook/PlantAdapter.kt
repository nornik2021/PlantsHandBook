package com.example.plantshandbook

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plantshandbook.databinding.PlantItemBinding

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    val plantList = ArrayList<Plant>() // список , отсюда адаптер берет данные
    class PlantHolder(item: View): RecyclerView.ViewHolder(item) { // с помощью этого класса сохраняются ссылки на элементы
        val binding = PlantItemBinding.bind(item)
        fun bind(plant: Plant) = with(binding){
            im.setImageResource(plant.imageId)
            tvTitle.text = plant.title

        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)// саздоем вью с помощью LayoutInflater
            return PlantHolder(view)
    }

        override fun onBindViewHolder(holder: PlantHolder, position: Int) { // выдает только что созданный элемент PlantHolder
        holder.bind(plantList[position]) // запускаем функцию bind
    }

        override fun getItemCount(): Int { // метод который должен знать сколько элементов внутри списка
        return plantList.size
    }
        fun addPlant(plant: Plant) { // в этой функции мы выводим элеметны списка по одному с помощью кнопки
            plantList.add(plant)
            notifyDataSetChanged()
        }


       /* fun addAll(list: List<Plant>) { // пример функции которая передаст весь список элеметов сразу
            plantList.clear() // очищаем старый список
            plantList.addAll(list) // добавляем в список новые элементы
            notifyDataSetChanged() // команда на вывод списка
        }*/
}