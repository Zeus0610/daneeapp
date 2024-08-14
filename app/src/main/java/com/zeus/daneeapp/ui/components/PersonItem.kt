package com.zeus.daneeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zeus.daneeapp.R

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun PersonItem(
    modifier: Modifier = Modifier,
    name: String = "",
    text: String = ""
) {
    Row(
        modifier = modifier
            .shadow(5.dp,)
            .padding(15.dp)
            .height(IntrinsicSize.Min)
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .border(2.dp, Color.Blue, RoundedCornerShape(100.dp))
                .clip(RoundedCornerShape(100.dp))
            ,
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = name
        )
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = name,
                color = Color.Cyan,
                fontSize = 13.sp,
            )
            Text(
                text = text,
                fontSize = 11.sp,
            )
        }
    }
}