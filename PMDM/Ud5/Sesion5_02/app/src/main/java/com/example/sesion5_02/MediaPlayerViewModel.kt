package com.example.sesion5_02

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel

class MediaPlayerViewModel: ViewModel() {
    private var mediaPlayer: MediaPlayer?= null

    // reproducir un audio almacenado como recurso en la app
// recibe el contexto y el identificador del recurso
    fun playRawAudio(context: Context, rawResId: Int) {
        stopAudio()
        //crea una instancia de MediaPlayer para reproducir un audio
        mediaPlayer = MediaPlayer.create(context, rawResId)
        //si se ha creado correctamente, reproduce el audio
        mediaPlayer?.start()
    }

    fun stopAudio() {
        //release libera los recursos del MediaPlayer y lo deja en un estado inicial
        mediaPlayer?.release()
        mediaPlayer = null
    }

    fun pauseAudio() {
        mediaPlayer?.pause()
    }

    fun resumeAudio() {
        //si no es null reproduce el audio
        //y si estuviera pausado lo reanuda desde donde estaba
        mediaPlayer?.start()
    }

    //Recibe el path del fichero en el dispositivo como String
    fun playAudioFile(filePath: String) {
        stopAudio()
        //crea una instancia de MediaPlayer para reproducir un audio
        // con apply se aplican varias funciones a la vez
        mediaPlayer = MediaPlayer().apply {
            //origen del audio
            setDataSource(filePath)
            //prepara el audio para reproducirlo (lo carga en memoria)
            prepare()
            //inicia la reproducción del audio
            start()
        }
    }



}