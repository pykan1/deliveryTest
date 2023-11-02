package com.example.delivery.screen.main.tabs

import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.delivery.R
import com.example.delivery.images.MainResImages
import com.example.delivery.screen.bucket.BucketScreen
import io.github.skeptick.libres.compose.painterResource

object Bucket : Tab {

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 3.toUShort(),
            title = "Корзина",
            icon = painterResource(image = R.drawable.bucket)
        )

    @Composable
    override fun Content() {
        Navigator(BucketScreen())
    }

}