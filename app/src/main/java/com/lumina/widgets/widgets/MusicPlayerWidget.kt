package com.lumina.widgets.widgets

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

class MusicPlayerWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                MusicPlayerContent()
            }
        }
    }
}

@Composable
private fun MusicPlayerContent() {
    // Liquid glass style background
    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(ColorProvider(Color(0xCC1C1C26))) // semi-transparent dark glass
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Album art placeholder
        Text(
            text = "🎵",
            style = TextStyle(
                fontSize = 36.sp,
                color = ColorProvider(Color.White)
            )
        )

        Spacer(modifier = GlanceModifier.height(12.dp))

        Text(
            text = "Not Playing",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = ColorProvider(Color.White)
            )
        )

        Spacer(modifier = GlanceModifier.height(4.dp))

        Text(
            text = "Lumina Music",
            style = TextStyle(
                fontSize = 13.sp,
                color = ColorProvider(Color.White.copy(alpha = 0.6f))
            )
        )

        Spacer(modifier = GlanceModifier.height(16.dp))

        // Controls row
        Row(
            modifier = GlanceModifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "⏮",
                style = TextStyle(
                    fontSize = 22.sp,
                    color = ColorProvider(Color.White)
                )
            )

            Spacer(modifier = GlanceModifier.width(24.dp))

            Text(
                text = "▶",
                style = TextStyle(
                    fontSize = 28.sp,
                    color = ColorProvider(Color(0xFF8B9CFF))
                )
            )

            Spacer(modifier = GlanceModifier.width(24.dp))

            Text(
                text = "⏭",
                style = TextStyle(
                    fontSize = 22.sp,
                    color = ColorProvider(Color.White)
                )
            )
        }
    }
}

class MusicPlayerWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = MusicPlayerWidget()
}
