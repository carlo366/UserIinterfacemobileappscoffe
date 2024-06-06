/*
Nama : Carloka Boas Alberto Sembiring
NIM  : 11322012
Prodi: D3 TI 1
 */
package com.example.jetcoffeetheme.model

import com.example.jetcoffeetheme.R

data class Menu(
    val id : Int ,
    val image : Int,
    val title : String,
    val price : String,
)

val dummyMenu = listOf(
    Menu(1,R.drawable.menu1, "Tiramisu Coffee Milk", "Rp 28.000"),
    Menu(2,R.drawable.menu2, "Pumpkin Spice Latte", "Rp 18.000"),
    Menu(3,R.drawable.menu3, "Light Cappuccino", "Rp 20.000"),
    Menu(4,R.drawable.menu4, "Choco Creamy Latte", "Rp 16.000"),
)

val dummyBestSellerMenu = dummyMenu.shuffled()