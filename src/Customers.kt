import java.util.*
import java.time.LocalDate
import java.time.Month
//val date = LocalDate.of(2016, Month.APRIL, 15)

class Customers(

    private val cost_id:Int,                            //hachaxordi id
    private val firstName:String,                       //anun
    private val lastName:String,                        //azganun
    private val age:Int,                                //tariq
    private val profileNumber:String,                   //andznagri hamar
    private val cust_phone_number:Long,                 //heraxosi hamar
    private val type_of_insurance:CategoryInsurance,    //apahovagrutyan tesaky
    private var datee:Short,                            //apahovagrman jamkety
    var time:Date,

):People( firstName, lastName, age, profileNumber,){
//------
    constructor(cost_id:Int,
                firstName:String,
                lastName:String,
                age:Int,
                profileNumber:String,
                cust_phone_number:Long,
                type_of_insurance:CategoryInsurance,
                datee:Short,
                time: Date,
                car:Car?=null):this(
        cost_id,
        firstName,
        lastName,
        age,
        profileNumber,
        cust_phone_number,
        type_of_insurance,
        datee,
        time
    ){ this.car = car }//comnstruct
//---------------------------------------------------------------------------------------------------------------------------------------------------------

    var car:Car? = null
    var date = datee


    fun getInfoCustomers():String
    {
        if (car == null)
            return "${RED}ID${RESET}-(${cost_id}) ${firstName} ${lastName}, (${age})${RED}y/o${RESET}, ${RED}Phone Number${RESET}(${cust_phone_number}), " +
                    "${RED}Profil Number${RESET}-(${profileNumber}), ${RED}Type Of Insurance${RESET}(${type_of_insurance}) " +
                    "${RED}Date${RESET}(${Green}${time.date}.${time.month}.${time.year}${RESET})${print_term()}"

        return "${RED}ID${RESET}-(${cost_id}) ${firstName} ${lastName}, (${age})${RED}y/o${RESET}, ${RED}Phone Number${RESET}(${cust_phone_number}), " +
                "${RED}Profil Number${RESET}-(${profileNumber}), ${RED}Type Of Insurance${RESET}(${type_of_insurance}) "+
                " ${RED}Date${RESET}(${Green}${time.date}.${time.month}.${time.year}${RESET})${print_term()}"+
                "\n    ${car!!.GetInfo()}"
    }

    var monthTime:Short = 0

    fun extend_the_deadline()//erkaradzgel jamkety
    {
            println("How many months do you want to extend the deadline? [1 month - 5$]")
            val input_month: Short
            try {
                input_month = Scanner(System.`in`).nextShort()
                monthTime = input_month
            } catch (e: Exception) {
                return
            }

            println("Input this day.")
            val input_this_day: Int

            try {
                input_this_day = Scanner(System.`in`).nextInt()
            } catch (e: Exception) {
                return
            }

            println("Input this month.")
            val input_this_month: Int
            try {
                input_this_month = Scanner(System.`in`).nextInt()

            } catch (e: Exception) {
                return
            }

            println("Input this year.")
            val input_this_year: Int
            try {
                input_this_year = Scanner(System.`in`).nextInt()
            } catch (e: Exception) {
                return
            }

            val money = input_month * 5
            println("You must pay ${money}$")

            date = (date + input_month).toShort()
            time = Date(input_this_year, input_this_month, input_this_day)

    }

    fun print_term():String
    {
       // val deadline_insurance = Date(time.year,time.month,time.date)
        //deadline_insurance.month = deadline_insurance.month + date.toInt()

        return " ${YELLOW}time${RESET} (${monthTime}${RESET})"
    }

    fun historyMoney():Int = (date * 5)
    fun incident_Money():Int = (date*15)




}//class Customers


