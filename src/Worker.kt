
class Worker(
   private val firstName:String,       // name
   private val lastName:String,        // surname
   private val age:Int,                // age
   private val phone_number:Long,      // phone number
   private val profileNumber:String,   // profileNumber
   val worker_thick:String             // worker thick
//
):People(firstName, lastName, age, profileNumber)
{
   fun getInfoWorkers():String
   {
      return "${RED}${firstName} ${lastName}${RESET}, (${age})${YELLOW}y/o${RESET}, ${YELLOW}Thick${RESET}-(${worker_thick})," +
              " ${YELLOW}Phone Number${RESET}(+${phone_number}) ${YELLOW}Profil Number${RESET}-(${profileNumber})"
   }


}
