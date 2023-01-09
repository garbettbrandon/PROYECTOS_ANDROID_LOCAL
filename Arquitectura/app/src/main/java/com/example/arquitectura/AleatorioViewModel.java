package com.example.arquitectura;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AleatorioViewModel extends ViewModel {
    MutableLiveData<Integer> datoObservable;
    ModelAleatorio datos;

    public LiveData<Integer> getDatoAleatorio(){
        if (datoObservable == null){
            datoObservable = new MutableLiveData<Integer>();
            datos = new ModelAleatorio();
            //generarAleatorio();
        }
        return datoObservable;
    }

    public void nuevoAleatorio(){
        //Actividad Asincrona
        new Thread(()->{
            //Petición a servidor remoto
            datos.generarAleatorio();
            //Que se entere todo el mundo ue ya llegó el dato
            datoObservable.postValue(datos.getAleatorio());
        }).start();
    }
}
