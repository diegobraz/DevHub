package com.example.devhub.ui

const val DETAIL_ARGUMENT_KEY = "user"

sealed class Screen(val route: String){
    object home : Screen(route = "home_screen/{$DETAIL_ARGUMENT_KEY}"){
        fun passUser(user: String): String{
           return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_KEY}", newValue = user)
        }
    }
    object  login: Screen( route = "login_screen")
}
