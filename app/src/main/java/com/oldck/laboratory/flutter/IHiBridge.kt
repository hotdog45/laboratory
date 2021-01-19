package com.oldck.laboratory.flutter


interface IHiBridge<P, Callback> {
    fun onBack(p: P?)
    fun goToNative(p: P)
    fun getHeaderParams(callback: Callback)
}