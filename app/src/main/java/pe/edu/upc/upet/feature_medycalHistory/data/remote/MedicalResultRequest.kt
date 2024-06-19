package pe.edu.upc.upet.feature_medycalHistory.data.remote

data class MedicalResultRequest(
    val resultDate: String,
    val resultType: String,
    val description: String,
    val medicalHistoryId: Int
)