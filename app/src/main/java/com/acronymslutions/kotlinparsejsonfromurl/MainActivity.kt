package com.acronymslutions.kotlinparsejsonfromurl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import com.github.kittinunf.fuel.Fuel

import com.github.kittinunf.fuel.json.responseJson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    internal var URL = "http://acronymsolutions.in/jsondata/records.php"

    private val jsoncode = 1

    private var listView: ListView? = null

    private var playersModelArrayList: ArrayList<PlayersModel>? = null

    private var customeAdapter: CustomeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lv) as ListView

        FetchPlayers()

    }

    private fun FetchPlayers() {

        try {

            Fuel.post(URL, listOf()).responseJson { request, response, result ->

               // Log.d("Players", result.get().content)

                onTaskCompleted(result.get().content)

                progressbar.visibility= View.GONE
            }
        } catch (e: Exception) {

        } finally {

        }
    }


    fun onTaskCompleted(response: String) {
        Log.d("responsejson", response)

        playersModelArrayList = getInfo(response)

        customeAdapter = CustomeAdapter(this, playersModelArrayList!!)

        listView!!.adapter = customeAdapter
    }

    fun getInfo(response: String): ArrayList<PlayersModel> {
        val playersModelArrayList = ArrayList<PlayersModel>()
        try {
            val jsonObject = JSONObject(response)
            if (jsonObject.getString("status") == "true") {

                val dataArray = jsonObject.getJSONArray("data")

                for (i in 0 until dataArray.length()) {
                    val playersModel = PlayersModel()
                    val dataobj = dataArray.getJSONObject(i)
                    playersModel.setNames(dataobj.getString("name"))
                    playersModel.setCountrys(dataobj.getString("country"))
                    playersModel.setCitys(dataobj.getString("city"))
                    playersModelArrayList.add(playersModel)
                }
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return playersModelArrayList
    }

}