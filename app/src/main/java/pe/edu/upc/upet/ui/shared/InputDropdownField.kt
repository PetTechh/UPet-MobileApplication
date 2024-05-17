package pe.edu.upc.upet.ui.shared

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.upet.ui.theme.BorderPadding
import pe.edu.upc.upet.ui.theme.UpetGray1
import pe.edu.upc.upet.ui.theme.UpetOrange1
import pe.edu.upc.upet.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDropdownField(
    label: String,
    options: List<String>,
    selectedOption: MutableState<String>
) {
    val expanded = remember {
        mutableStateOf(false)
    }
    val commonPadding = BorderPadding

    LabelTextField(label, commonPadding)

    ExposedDropdownMenuBox(
        expanded = expanded.value,
        onExpandedChange = {
            expanded.value = !expanded.value
        }) {
        Box (modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded.value = true }
            .padding(start = BorderPadding)
        ){
            OutlinedTextField(
                value = selectedOption.value,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null, tint = UpetOrange1
                    )
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .size(height = 56.dp, width = 300.dp)
                    .padding(bottom = 10.dp, end = BorderPadding)
                    .border(BorderStroke(2.dp, UpetOrange1), shape = RoundedCornerShape(10.dp))
                    .background(Color.White, shape = RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(
                    color = if (selectedOption.value.isNotEmpty()) Color.Black else UpetGray1,
                    fontSize = 12.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal
                )
            )
            ExposedDropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(BorderStroke(2.dp, UpetOrange1), shape = RoundedCornerShape(0.dp))

                ,)
            {
                options.forEach {
                    DropdownMenuItem(
                        text = { Text(it,
                            color = if (selectedOption.value.isNotEmpty()) Color.Black else UpetGray1,
                            fontSize = 12.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal
                        ) },
                        onClick = {
                            selectedOption.value = it
                            expanded.value = false },
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    if (it != options.last()) {
                        Divider(color = UpetOrange1, thickness = 0.dp)
                    }
                }
            }
        }
    }
}