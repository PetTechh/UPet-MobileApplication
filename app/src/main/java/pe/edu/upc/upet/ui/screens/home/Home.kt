package pe.edu.upc.upet.ui.screens.home
import PetProfile
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import pe.edu.upc.upet.feature_pet.domain.pets
import pe.edu.upc.upet.ui.shared.SimplePetCard
import pe.edu.upc.upet.feature_vet.domain.veterinaryClinics
import pe.edu.upc.upet.navigation.Routes
import pe.edu.upc.upet.ui.screens.pets.PetList
import pe.edu.upc.upet.ui.screens.pets.RegisterPet
import pe.edu.upc.upet.ui.screens.vets.VetCard
import pe.edu.upc.upet.ui.screens.vets.VetList
import pe.edu.upc.upet.ui.shared.SearchField
import pe.edu.upc.upet.ui.theme.Pink
import pe.edu.upc.upet.ui.theme.PinkStrong


@Composable
fun Home() {
    val navController = rememberNavController()
    val backgroundColor = Color(0xFF0B1C3F)
    Scaffold(modifier = Modifier.background(backgroundColor),
        bottomBar = {

            BottomAppBar(
                modifier = Modifier
                    .height(65.dp)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                containerColor = Color.White,

            ) {
                 BottomNavigation( backgroundColor = Color.White) {
                     BottomNavigationItem(
                            icon = { Icon(Icons.Default.Home, contentDescription = null) },
                            label = { Text("Home")},
                            selectedContentColor = Pink,
                            unselectedContentColor = Color.Gray,
                            selected = true,
                            onClick = { navController.navigate(Routes.Home) }
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Default.Pets, contentDescription = null) },
                            label = { Text("Pets") },
                            selectedContentColor = Pink,
                            unselectedContentColor = Color.Gray,
                            selected = false,
                            onClick = { navController.navigate(Routes.PetList) }
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Default.LocalHospital, contentDescription = null) },
                            label = { Text("Vets") },
                            selectedContentColor = Pink,
                            unselectedContentColor = Color.Gray,
                            selected = false,
                            onClick = { navController.navigate(Routes.VetList)}
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Default.Event, contentDescription = null) },
                            label = { Text("Appointments") },
                            selected = false,
                            selectedContentColor = Pink,
                            unselectedContentColor = Color.Gray,
                            onClick = { /* Navigate to Appointments screen */ }
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
                            label = { Text("Profile") },
                            selected = false,
                            selectedContentColor = Pink,
                            unselectedContentColor = Color.Gray,
                            onClick = { /* Navigate to Profile screen */ }
                        )
                    }



            }
        }
        ) { paddingValues ->
        NavHost(navController, startDestination = Routes.Home) {
            composable(Routes.Home) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .size(100.dp)) {
                    UserSection()
                    SearchField()
                    PetsSection(navController)
                    RecommendedVetsSection( navController)
                }
            }
            composable(Routes.PetList) {
                PetList(navController)
            }
            composable("PetProfile/{petId}") { backStackEntry ->
                val petId = backStackEntry.arguments?.getString("petId")?.toInt()

                PetProfile(petId, navController)
            }
            composable(Routes.RegisterPet) {
                RegisterPet(navController)
            }
            composable(Routes.VetList) {
                VetList(navController)
            }
        }
    }
}

@Composable
fun UserSection(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberImagePainter("https://img.freepik.com/foto-gratis/cabeza-hermosa-mujer-piel-oscura-expresion-feliz-tiene-peinado-afro-demuestra-dientes-blancos-perfectos-tiene-sonrisa-complacida-elegante-joven-afroamericana-descansa-interior_273609-2384.jpg?t=st=1714346926~exp=1714350526~hmac=9126533c34ec64fda3f2f543ac3bd74072727f80568fb53c226eac8503562d00&w=996"),
                contentDescription = "User Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
            Column(modifier = Modifier.padding(start = 20.dp)) {
                Text(
                    text = "Hello, Monica",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
                Text(
                    text = "Welcome!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }
        }
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notifications",
            tint = Color.White
        )
    }
}


@Composable
fun PetsSection(navController: NavHostController) {
    Column {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "My Pets",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Text(
                text = "Add a pet",
                style = MaterialTheme.typography.bodyMedium,
                color = PinkStrong,
                modifier = Modifier
                    .clickable {  navController.navigate(Routes.RegisterPet) }
            )
        }
        LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
            items(pets.take(4)) { pet ->
                SimplePetCard(pet, navController, onPetSelected = {
                    navController.navigate("PetProfile/${pet.id}")
                })
            }
        }

    }
}

    @Composable
    fun RecommendedVetsSection(navController: NavController ) {
        Column {
            Text(
                text = "Recommended Veterinary Clinics",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn {
                items(veterinaryClinics) { vet ->
                    VetCard(vet, onVetSelected = {navController.navigate("VetProfile/${vet.id}")})
                }

            }
        }
    }




