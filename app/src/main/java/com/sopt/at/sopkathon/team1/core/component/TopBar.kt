package com.sopt.at.sopkathon.team1.core.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.sopkathon.team1.R
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.defaultSopkatonColors
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.defaultSopkatonTypography

@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_menu_hamburger),
            contentDescription = "",
            tint = defaultSopkatonColors.White,
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = "쪼매못났슈",
            style = defaultSopkatonTypography.title_sb_18.merge(
                defaultSopkatonColors.White
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_profile),
            contentDescription = "",
            tint = defaultSopkatonColors.White,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    TopBar()
}