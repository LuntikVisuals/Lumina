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
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

class AmbientWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                AmbientContent()
            }
        }
    }
}

@Composable
private fun AmbientContent() {
    val moods = listOf(
        "Calm" to "🌙",
        "Focus" to "🌟",
        "Energy" to "⚡",
        "Dream" to "🌌",
        "Soft" to "🌸"
    )
    val (mood, emoji) = moods.random()

    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(ColorProvider(Color(0xCC1C1C26)))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = emoji,
            style = TextStyle(fontSize = 32.sp)
        )

        Spacer(modifier = GlanceModifier.height(10.dp))

        Text(
            text = mood,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = ColorProvider(Color.White)
            )
        )

        Spacer(modifier = GlanceModifier.height(4.dp))

        Text(
            text = "Current mood",
            style = TextStyle(
                fontSize = 12.sp,
                color = ColorProvider(Color.White.copy(alpha = 0.55f))
            )
        )
    }
}

class AmbientWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = AmbientWidget()
}
