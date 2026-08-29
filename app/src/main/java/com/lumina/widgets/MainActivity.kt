package com.lumina.widgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lumina.widgets.ui.theme.LuminaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LuminaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0F0F13),
            Color(0xFF1A1A24),
            Color(0xFF12121A)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Lumina",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Liquid Glass Widgets",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.6f),
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            GlassCard(
                title = "How to use",
                content = "Long press on home screen \u2192 Widgets \u2192 Lumina\nChoose any widget and place it."
            )

            Spacer(modifier = Modifier.height(16.dp))

            GlassCard(
                title = "Widgets",
                content = "• Music Player\n• Now Playing + Visualizer\n• Liquid Clock\n• Ambient / Mood\n• Quote\n• Custom Battery\n• Focus Timer\n• Mini Control Center\n• Dynamic Island\n• Pure Aesthetic"
            )

            Spacer(modifier = Modifier.height(16.dp))

            GlassCard(
                title = "Status",
                content = "Version 0.1.0 — Foundation\nWidgets are being built step by step."
            )

            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
fun GlassCard(
    title: String,
    content: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.12f),
                        Color.White.copy(alpha = 0.05f)
                    )
                )
            )
            .padding(1.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(23.dp))
                .background(Color(0xFF1C1C26).copy(alpha = 0.65f))
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = content,
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.75f),
                    lineHeight = 20.sp
                )
            }
        }
    }
}
