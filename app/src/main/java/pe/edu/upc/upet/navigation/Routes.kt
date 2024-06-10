package pe.edu.upc.upet.navigation

sealed class Routes(val route: String) {

    data object SubscriptionAdvanced : Routes("subscription_advanced")
    data object SubscriptionBasic : Routes("subscription_basic")

    //Auth views -------------------------------------------------

    data object SignIn : Routes("sign_in")
    data object SignUp : Routes("sign_up")
    data object PostRegister : Routes("post_register")
    data object ConfirmCode : Routes("confirm_code")
    data object NewPassword : Routes("new_password")
    data object SendEmail : Routes("send_email")

    // Owner views ---------------------------------------------
    data object OwnerHome : Routes("owner_home")
    data object OwnerProfile : Routes("owner_profile")
    data object OwnerEditProfile : Routes("owner_edit_profile")
    data object OwnerClinicDetails : Routes("owner_clinic_details/{clinicId}") {
        fun createRoute(clinicId: Int) = "owner_clinic_details/$clinicId"
    }
    data object OwnerVetProfile : Routes("vet_profile/{vetId}") {
        fun createRoute(vetId: Int) = "vet_profile/$vetId"
    }
    data object OwnerClinicList : Routes("owner_clinic_list")
    data object AppointmentDetail : Routes("appointment_detail/{appointmentId}") {
        fun createRoute(appointmentId: Int) = "appointment_detail/$appointmentId"
    }
    data object AppointmentList : Routes("appointment_list")
    data object BookAppointment : Routes("book_appointment/{vetId}"){
        fun createRoute(vetId: Int) = "book_appointment/$vetId"
    }
    data object PetDetails : Routes("pet_details_Routes/{petId}") {
        fun createRoute(petId: Int) = "pet_details_Routes/$petId"
    }
    data object EditPetDetail : Routes("edit_pet_detail/{petId}") {
        fun createRoute(petId: Int) = "edit_pet_detail/$petId"
    }
    data object PetDetailsAppointment : Routes("pet_details_appointment/{vetId}/{selectedDate}/{selectedTime}") {
        fun createRoute(vetId: Int, selectedDate: String, selectedTime: String) = "pet_details_appointment/$vetId/$selectedDate/$selectedTime"
    }
    data object PetList : Routes("pet_list")
    data object RegisterPet : Routes("register_pet")

    // Vet views
    data object VetHome : Routes("vet_home")
    data object VetProfile : Routes("vet_profile")
    data object VetEditProfile : Routes("vet_edit_profile")
    data object VetAppointmentDetail : Routes("vet_appointment_detail/{appointmentId}") {
        fun createRoute(appointmentId: Int) = "vet_appointment_detail/$appointmentId"
    }
    data object VetAppointments : Routes("vet_appointments")
    data object VetEditPassword : Routes("vet_edit_password")
    data object VetPatientDetail : Routes("vet_patient_detail/{patientId}") {
        fun createRoute(patientId: Int) = "vet_patient_detail/$patientId"
    }
    data object VetPatients : Routes("vet_patients")
    
}
