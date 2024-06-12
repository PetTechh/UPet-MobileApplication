package pe.edu.upc.upet.ui.screens.vetviews

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import pe.edu.upc.upet.feature_vets.data.remote.VetUpdateRequest
import pe.edu.upc.upet.feature_vets.data.repository.VetRepository
import pe.edu.upc.upet.ui.screens.ownerviews.getVet
import pe.edu.upc.upet.ui.shared.CustomTextField
import pe.edu.upc.upet.ui.shared.SuccessDialog
import pe.edu.upc.upet.ui.shared.TopBar
import pe.edu.upc.upet.ui.theme.Pink

@Composable
fun VetEditProfile(navController: NavHostController) {

    val vet = getVet() ?: return

    var name by remember { mutableStateOf(vet.name) }
    var description by remember { mutableStateOf(vet.description) }
    var experience by remember { mutableStateOf(vet.experience.toString()) }

    val showSuccessDialog = remember { mutableStateOf(false) }

    if (showSuccessDialog.value) {
        SuccessDialog(onDismissRequest = {
            showSuccessDialog.value = false
            navController.navigateUp()
        }, titleText = "Profile Updated",
            messageText = "Your profile has been updated successfully.",
            buttonText = "OK")
    }

    Scaffold(
        topBar = {
            TopBar(navController = navController, title = "Edit Profile")
        },
        modifier = Modifier.padding(16.dp)
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    CustomTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = "Name",
                        leadingIcon = Icons.Default.Person,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = "Description",
                        leadingIcon = Icons.Default.Person,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomTextField(
                        value = experience,
                        onValueChange = { experience = it },
                        label = "Experience",
                        leadingIcon = Icons.Default.Person,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {

                             VetRepository().updateVet(
                                 vet.id,
                                 VetUpdateRequest(
                                     name = name,
                                     description = description,
                                     experience = experience.toInt()
                                 ),
                             ) {
                                 if (it) {
                                     showSuccessDialog.value = true
                                 }
                             }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Pink),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Save Changes", color = Color.White)
                    }
                }
            }
        }
    }
}