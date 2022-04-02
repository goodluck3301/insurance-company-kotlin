
class Worker(
   private val firstName:String,       //anun
   private val lastName:String,        //azganun
   private val age:Int,                //tariq
   private val phone_number:Long,      //heraxosi hamar
   private val profileNumber:String,   //andznagri hamar
   val worker_thick:String             //hastiq
//
):People(firstName, lastName, age, profileNumber)
{
   fun getInfoWorkers():String
   {
      return "${RED}${firstName} ${lastName}${RESET}, (${age})${YELLOW}y/o${RESET}, ${YELLOW}Thick${RESET}-(${worker_thick})," +
              " ${YELLOW}Phone Number${RESET}(+${phone_number}) ${YELLOW}Profil Number${RESET}-(${profileNumber})"
   }


}