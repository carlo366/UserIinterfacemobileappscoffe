/*
Nama : Carloka Boas Alberto Sembiring
NIM  : 11322012
Prodi: D3 TI 1
 */
package com.example.jetcoffeetheme.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeSection(
    title : String,
    modifier: Modifier = Modifier,
    content: @Composable ()-> Unit
)
{
    Column(modifier){
        SectionText(title, modifier)
        content()
    }
}