package com.zeus.daneeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.zeus.daneeapp.R
import com.zeus.daneeapp.domian.models.Location

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun PersonItem(
    modifier: Modifier = Modifier,
    name: String = "",
    status: String = "",
    species: String = "",
    gender: String = "",
    image: String = "",
    created: String = "",
    location: Location = Location()
) {
    var genero: String = ""
    if (gender == "Male"){
        genero = "Masculino"
    }else if (gender == "Female"){
        genero = "Femenino"
    }else{
        genero = gender
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .shadow(5.dp)
            .padding(
                vertical = 5.dp
            )
            .height(IntrinsicSize.Min)
            .background(color = Color.Gray, RoundedCornerShape(20.dp))

    ) {
        AsyncImage(
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                .size(80.dp)
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(100.dp))
                .clip(RoundedCornerShape(100.dp)),
            model = image,
            contentDescription = name,
        )
        Column(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    top = 10.dp,
                    bottom = 10.dp,
                    end = 20.dp
                )
                .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(space = 10.dp, alignment = Alignment.CenterVertically)
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = LocalTextStyle.current.merge(
                        TextStyle(
                            lineHeight = 0.5.em,
                        ),
                    ),
                )
                Text(
                    text = stringResource(R.string.status_specie, status, species),
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    style = LocalTextStyle.current.merge(
                        TextStyle(
                            lineHeight = 0.5.em,
                        ),
                    ),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    verticalArrangement = Arrangement.Top,

                ) {
                    Text(
                        text = stringResource(R.string.last_location, location.name),
                        color = Color.LightGray,
                        fontSize = 13.sp,
                        style = LocalTextStyle.current.merge(
                            /*TextStyle(
                                lineHeight = 0.5.em,
                            ),*/
                        ),
                    )
                    /*Text(
                        text = location.name,
                        color = Color.LightGray,
                        fontSize = 13.sp,
                        style = LocalTextStyle.current.merge(
                            TextStyle(
                                lineHeight = 0.5.em,
                            ),
                        ),
                    )*/
                    Text(
                        text = "Género:",
                        color = Color.LightGray,
                        fontSize = 13.sp,
                        style = LocalTextStyle.current.merge(
                            TextStyle(
                                lineHeight = 0.5.em,
                            ),
                        ),
                    )
                    Text(
                        text = genero,
                        color = Color.White,
                        fontSize = 13.sp,
                        style = LocalTextStyle.current.merge(
                            TextStyle(
                                lineHeight = 0.5.em,
                            ),
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(0.dp),
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    Text(
                        text = "Primera vez visto en:",
                        color = Color.LightGray,
                        fontSize = 13.sp,
                        style = LocalTextStyle.current.merge(
                            TextStyle(
                                lineHeight = 0.5.em,
                            ),
                        ),
                    )
                    Text(
                        text = "location",
                        color = Color.White,
                        fontSize = 13.sp,
                        style = LocalTextStyle.current.merge(
                            TextStyle(
                                lineHeight = 0.5.em,
                            ),
                        ),
                    )
                }
            }
        }
    }
}