package com.example.jetcoffeetheme.component

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcoffeetheme.R
import com.example.jetcoffeetheme.menudetail
import com.example.jetcoffeetheme.model.Menu
import com.example.jetcoffeetheme.ui.theme.JetCoffeeThemeTheme

@Composable
fun MenuItem(
    menu: Menu,
    modifier: Modifier = Modifier,
    onDetailClick: (Menu) -> Unit
) {
    val context = LocalContext.current // Get the current context

    ElevatedCard(
        modifier = modifier
            .width(140.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
    ) {
        Column {
            Image(
                painter = painterResource(menu.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = menu.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = menu.price,
                    style = MaterialTheme.typography.titleSmall
                )
                Button(
                    onClick = {
                        val intent = Intent(context, menudetail::class.java) // Use the context to create the intent
                        context.startActivity(intent) // Start the activity
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Lihat Detail")
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MenuItemPreview() {
    val menu = Menu(1, R.drawable.menu2, "Hot Pumpkin Spice Latte Premium", "Rp 18.000")
    JetCoffeeThemeTheme {
        MenuItem(
            menu = menu,
            modifier = Modifier.padding(8.dp),
            onDetailClick = {}
        )
    }
}
