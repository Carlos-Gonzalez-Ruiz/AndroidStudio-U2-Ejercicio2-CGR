package com.carlosgonzalez.ejercicio2_fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.carlosgonzalez.ejercicio2_fragment.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private val locationList = listOf(
        Location("Sevilla","https://imagenes.elpais.com/resizer/gn41At16UrsNd2hLjwF6ZD-rR4c=/414x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/Q7LLSRYJESSEIRMG4CVDKO3YY4.jpg", "37.3828300", "-5.9731700"),
        Location("Barcelona", "https://fotos.hoteles.net/articulos/guia-barcelona-ciudad-2400-1.jpg", "41.38879 ", "2.15899"),
        Location("Madrid", "https://elasombrario.publico.es/wp-content/uploads/sites/1/2018/08/Snapseed.jpg", "40.4165", "-3.70256"),
        Location("Lisboa", "https://static1.hoy.es/www/multimedia/201801/17/media/cortadas/LISBOA%20(2)-k2OD-U50655755530WCD-624x385@Hoy.jpg", "38.71667", "-9.13333"),
        Location("Galicia", "https://fotos.hoteles.net/articulos/ourense-ciudad-galicia-3099-1.jpg", "42.75508", "-7.86621"),
        Location("Cádiz", "https://www.cadizturismo.com/storage/app/media/uploaded-files/p-cadiz_turismo.jpg", "36.52672", "-6.2891"),
        Location("Huelva", "https://fotos.hoteles.net/articulos/guia-huelva-ciudad-6159-1.jpg", "37.26638", "-6.94004"),
        Location("Salamanca", "https://fotos.hoteles.net/articulos/guia-salamanca-ciudad-4109-1.jpg", "40.96882", "-5.66388"),
        Location("Santander", "https://tequilainteligente.com/wp-content/uploads/2021/05/IN-EXTRATEGIA-900X600-2021-05-25T101343.569.png", "43.46230569", "-3.80998030"),
        Location("París", "https://viajes.nationalgeographic.com.es/medio/2021/03/03/sena_4ffb342d_1254x836.jpg", "48.85341", "2.3488"),
        Location("Londres", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/City_of_London%2C_seen_from_Tower_Bridge.jpg/800px-City_of_London%2C_seen_from_Tower_Bridge.jpg", "51.5085300", "-0.1257400"),
        Location("Roma", "https://unapausaagradable.es/wp-content/uploads/2020/08/por-que-roma-es-la-ciudad-eterna-1160x711.jpg", "45.5838300", "11.7181900"),
        Location("Albacete", "https://images.ecestaticos.com/hopy9-pEDG6YxsIzSR38AbY_4ts=/33x3:1849x1026/1600x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F052%2F0e9%2Fce1%2F0520e9ce13efcc5a0e37ce3769ec431d.jpg", "38.9942400", "-1.8564300"),
        Location("Valencia", "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/valencia-1613049469.jpg", "39.4697500", "-0.3773900"),
        Location("Murcia", "https://1000sitiosquever.com/public/images/supima-2250-la-catedral.jpg", "37.98704", "-1.13004")
    )

    override fun onViewCreated(view : View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Establecer titulo de arriba al nombre de la aplicación.
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = LocationAdapter(locationList) { location ->
                navigateTo(location)
            }
        }
    }

    /* Abrir Google Maps mediante un intent con las coordanadas de Location */
    private fun navigateTo(location : Location) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll=${location.latitude},${location.longitude}"))
        intent.setPackage("com.google.android.apps.maps")

        startActivity(intent)
    }
}