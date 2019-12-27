package com.acronymslutions.kotlinparsejsonfromurl

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomeAdapter(private val context: Context, private val playersModelArrayList: ArrayList<PlayersModel>) :
    BaseAdapter() {

    override fun getViewTypeCount(): Int {
        return count
    }

    override fun getItemViewType(position: Int): Int {

        return position
    }

    override fun getCount(): Int {
        return playersModelArrayList.size
    }

    override fun getItem(position: Int): Any {
        return playersModelArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var convertView = convertView

        val holder: ViewHolder

        if (convertView == null) {

            holder = ViewHolder()

            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.lv_item, null, true)


            holder.tvname = convertView!!.findViewById(R.id.name) as TextView

            holder.tvcountry = convertView.findViewById(R.id.country) as TextView

            holder.tvcity = convertView.findViewById(R.id.city) as TextView

            convertView.tag = holder
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = convertView.tag as ViewHolder
        }

        holder.tvname!!.text = "Name: " + playersModelArrayList[position].getNames()
        holder.tvcountry!!.text = "Country: " + playersModelArrayList[position].getCountrys()
        holder.tvcity!!.text = "City: " + playersModelArrayList[position].getCitys()

        return convertView
    }

    private inner class ViewHolder {

        var tvname: TextView? = null
        var tvcountry: TextView? = null
        var tvcity: TextView? = null
    }

}