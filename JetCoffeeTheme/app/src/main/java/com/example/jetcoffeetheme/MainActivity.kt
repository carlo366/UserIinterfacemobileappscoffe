/*
Nama : Carloka Boas Alberto Sembiring
NIM  : 11322012
Prodi: D3 TI 1
 */
package com.example.jetcoffeetheme

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcoffeetheme.component.CategoryItem
import com.example.jetcoffeetheme.component.DetailMenuActivity
import com.example.jetcoffeetheme.component.HomeSection
import com.example.jetcoffeetheme.component.MenuItem
import com.example.jetcoffeetheme.component.Search
import com.example.jetcoffeetheme.model.ButtomBarItem
import com.example.jetcoffeetheme.model.Menu
import com.example.jetcoffeetheme.model.dummyBestSellerMenu
import com.example.jetcoffeetheme.model.dummyCategory
import com.example.jetcoffeetheme.model.dummyMenu
import com.example.jetcoffeetheme.ui.theme.JetCoffeeThemeTheme

fun onDetailClick(context: Context, menu: Menu) {
    val intent = Intent(context, DetailMenuActivity::class.java)

    // Kirim data menu melalui intent
    intent.putExtra("menu_id", menu.id)

    context.startActivity(intent)
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeeThemeTheme {
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Scaffold(
        bottomBar = { BottomAppBarComposable() }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Banner()
            CategoryRowComposable()
            HomeSection(
                title = stringResource(R.string.section_category),
                content = { MenuRow(dummyMenu, onDetailClick = { menu -> onDetailClick(context, menu) }) }
            )
            HomeSection(
                title = stringResource(R.string.section_best_seller_menu),
                content = { MenuRow(dummyBestSellerMenu, onDetailClick = { menu -> onDetailClick(context, menu) }) }
            )
        }
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        Search()
    }
}

@Composable
fun CategoryRowComposable(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(dummyCategory) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier,
    onDetailClick: (Menu) -> Unit  // Perbarui parameter untuk handle klik detail
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu) { menu ->
            MenuItem(menu, modifier = Modifier, onDetailClick = onDetailClick)
        }
    }
}



@Composable
fun BottomAppBarComposable(
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        val navigationItems = listOf(
            ButtomBarItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home
            ),
            ButtomBarItem(
                title = stringResource(R.string.menu_favorite),
                icon = Icons.Default.Favorite
            ),
            ButtomBarItem
            (
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle
            )
        )
        navigationItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(item.title)
                },
                selected = item.title == navigationItems[0].title,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetCoffeeAppPreview() {
    JetCoffeeThemeTheme {
        JetCoffeeApp()
    }
}


