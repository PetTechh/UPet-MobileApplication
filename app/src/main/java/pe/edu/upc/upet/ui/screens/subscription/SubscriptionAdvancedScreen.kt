package pe.edu.upc.upet.ui.screens.subscription

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import pe.edu.upc.upet.ui.shared.CustomReturnButton
import pe.edu.upc.upet.ui.theme.Blue1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionAdvancedScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Blue1,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text("Subscription")
                },
                navigationIcon = {
                    CustomReturnButton(navController = navController)
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    SubscriptionStatusCardAdvanced()
                    Spacer(modifier = Modifier.height(16.dp))
                    SectionTitle("Your Benefits")
                    BenefitsList(
                        benefits = listOf(
                            "Access to all features",
                            "Unlimited searches",
                            "Priority support",
                            "Exclusive content"
                        )
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Divider(color = Color.Gray, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(24.dp))
                    ChangeSubscriptionOption(navController)
                }
            }
        }
    }
}

@Composable
fun SubscriptionStatusCardAdvanced() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF4CAF50) // Green color indicating active subscription
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Advanced Subscription",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Thank you for being a premium member. Enjoy your exclusive benefits!",
                style = TextStyle(color = Color.White),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 20.sp
        ),
        modifier = Modifier.padding(vertical = 16.dp)
    )
}

@Composable
fun BenefitsList(benefits: List<String>) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp).background(Color.White, shape = RoundedCornerShape(8.dp)).padding(8.dp)) {
        benefits.forEach { benefit ->
            BenefitItem(benefit)
        }

    }
}

@Composable
fun BenefitItem(benefit: String) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = Color(0xFF0A1B3E),
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = benefit,
            color = Color.Black,
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 16.sp
        )
    }
}

@Composable
fun ChangeSubscriptionOption(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Change your subscription",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { /* Handle change to basic subscription */ },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "Switch to Basic Subscription",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
