package com.rockycamacho.diversify.test

import timber.log.Timber

class TestTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        tag?.let {
            print("[$tag]   ")
        }
        println(message)
        t?.printStackTrace()
    }
}
