import java.util.*

class InsuranceCompany(val contact:ContactInformation, private val worker:MutableList<Worker>, private val customers:MutableList<Customers>)
{
    var worker_count = worker.size
    var customers_count = customers.size

    fun getPublicInfo():String {
        return "${YELLOW}${contact.insuranceName}${RESET}\n Adress-${contact.address}, Phone-(+${contact.phoneNumber}), Mail-${contact.mail}\nWorker Count-(${worker_count}), Customers Count-(${customers_count})"
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------
    private val database = Database()

    fun add_cust(list:MutableList<Customers>,)
    {
        if(customers_count <= 10)
        {
            var b = true
            while (b) {
                println("${RED}Choose insurance category$RESET \n" +
                        "${RED}[1]${RESET}Car\n" +
                        "${RED}[2]${RESET}Health\n")
                var inputMcategoty:Int
                try {
                    inputMcategoty = Scanner(System.`in`).nextInt()
                }catch (e : Exception){
                    inputMcategoty = 9999
                }

                when (inputMcategoty) {

                    1 -> {
                        println("Input firstname")
                        val input_fName = Scanner(System.`in`).nextLine()
                        println("Input lastname")
                        val input_lName = Scanner(System.`in`).nextLine()
                        println("Input age")
                        var input_age:Int
                        try {
                            input_age = Scanner(System.`in`).nextInt()
                        } catch (e: Exception) {
                            input_age = 18
                        }
                        println("Input Profile number")
                        val input_pNumber = Scanner(System.`in`).nextLine()
                        println("Input Phone or Idram numbers")
                        val input_phone_Number = Scanner(System.`in`).nextLong()
                        println("Input insurance period")
                        val input_date = Scanner(System.`in`).nextShort()
                        println("Input Car model")
                        val input_car_model = Scanner(System.`in`).nextLine()
                        println("Input Car height")
                        val input_car_height = Scanner(System.`in`).nextFloat()
                        println("Input Car width")
                        val input_car_width = Scanner(System.`in`).nextFloat()
                        println("Input Car Year")
                        val input_car_year = Scanner(System.`in`).nextInt()
                        println("Input Engine model")
                        val input_eng_model = Scanner(System.`in`).nextLine()
                        println("Input Engine power")
                        val input_eng_pow = Scanner(System.`in`).nextInt()
                        println("Input Engine Volume")
                        val input_eng_vol = Scanner(System.`in`).nextInt()
                        println("Input Engine Cylinders count")
                        val input_eng_cyl = Scanner(System.`in`).nextInt()

                        println("Input This month")
                        val input_this_month = Scanner(System.`in`).nextInt()
                        println("Input This year")
                        val input_this_year = Scanner(System.`in`).nextInt()
                        println("Input This day")
                        val input_this_day = Scanner(System.`in`).nextInt()

                        list.add(Customers(list.size,
                            input_fName,
                            input_lName,
                            input_age,
                            input_pNumber,
                            input_phone_Number,
                            CategoryInsurance.CAR,
                            input_date,

                            Date(input_this_year,input_this_month,input_this_day),
                            Car(input_car_model,
                                input_car_height,
                                input_car_width,
                                Engine(input_eng_model, input_eng_pow, input_eng_vol, input_eng_cyl),
                                input_car_year))//all parametrs
                        )//list.add
                        b = false
                    }//case 1

                    2 -> {
                        println("Input firstname")
                        val input_fName = Scanner(System.`in`).nextLine()
                        println("Input lastname")
                        val input_lName = Scanner(System.`in`).nextLine()
                        println("Input age")
                        var input_age:Int
                        try {
                            input_age = Scanner(System.`in`).nextInt()
                        } catch (e: Exception) {
                            input_age = 18
                        }
                        println("Input Profile number")
                        val input_pNumber = Scanner(System.`in`).nextLine()
                        println("Input Phone or Idram numbers")
                        val input_phone_Number = Scanner(System.`in`).nextLong()
                        println("Input insurance period")
                        val input_date = Scanner(System.`in`).nextShort()

                        println("Input This month")
                        val input_this_month = Scanner(System.`in`).nextInt()
                        println("Input This year")
                        val input_this_year = Scanner(System.`in`).nextInt()
                        println("Input This day")
                        val input_this_day = Scanner(System.`in`).nextInt()


                        list.add(Customers(list.size,
                            input_fName,
                            input_lName,
                            input_age,
                            input_pNumber,
                            input_phone_Number,
                            CategoryInsurance.HEALTH,
                            input_date,
                            Date(input_this_year,input_this_month,input_this_day),))
                        b = false
                    }//case 2
                    else -> println("${RED}Choose right option${RESET}")
                }//when
            }
        }//if
        else
            println("${RED}Sorry, but custumers count > 10${RESET} [count must be <=10]")

    }//fun add cust

    fun delete_customers(list:MutableList<Customers>, id:Int)
    {
        if (customers_count>=1)
        {
            if (id < customers_count){
                database.delete_cust_log(id+1)
                list.removeAt(id)
            }
            else
                println("Don't found customer number")
        }
        else println("${RED}Sorry, but custumers count is equal 0${RESET} [count must be >= 1]")
    }

//------------------------------------------------------------------------------------------------------------



//------------------------------------------------------------------------------------------------------------
    fun add_worker(list:MutableList<Worker>)
    {
        if(worker_count <= 10)
        {
            println("Input firstname")
                val input_fName = Scanner(System.`in`).nextLine()
            println("Input lastname")
                val input_lName = Scanner(System.`in`).nextLine()
            println("Input age")
                val input_age = Scanner(System.`in`).nextInt()
            println("Input Profile number")
                val input_pNumber = Scanner(System.`in`).nextLine()
            println("Input Phone number")
                val input_phone_Number = Scanner(System.`in`).nextLong()
            println("Input Thick type")
                val input_thick = Scanner(System.`in`).nextLine()
            list.add(Worker(input_fName, input_lName,input_age, input_phone_Number,input_pNumber,input_thick))
        }else
            println("${RED}Sorry, but workers count > 10${RESET} [count must be <=10]")
    }//add worker


    fun delete_worker(list:MutableList<Worker>, id:Int)
    {
        if (worker_count>=1)
        {
            if (id < customers_count){
                database.delete_work_log(id+11)
                list.removeAt(id)
            }
            else println("Don't found worker number")
        }
        else println("${RED}Sorry, but worker count is equal 0${RESET} [count must be >= 1]")
    }//delete worker

//----------------------------------------------------------------------------------------------------------------------
//                                      working database

    fun check_login_pass():Int //cheker
    {
        println("${RED}Input your login${RESET}")
        val login = Scanner(System.`in`).nextLine()

        println("${RED}Input your password${RESET}")
        val pass  =  Scanner(System.`in`).nextLine()

        return database.check_login_pass(login,pass,)
    }//login pass cheker

    fun add_login_pass(id:Int) { database.addLoginPass(id) }
    fun add_login_pass_work(id:Int) { database.addLoginPass_worker(id) }
//----------------------------------------------------------------------------------------------------------------------

    fun payMoney():Boolean
    {
        println("${RED}Choose option$RESET \n" +
                "${RED}[1]${RESET}Pay\n"+
                "${RED}[0]${RESET}Back\n"
        )
        var inp_opt:Int
        try {
            inp_opt = Scanner(System.`in`).nextInt()
        }catch (e : Exception){
            inp_opt = 9999
        }
        if (inp_opt == 1) {
            println ("${YELLOW}The money was transferred from your ${RED}Idram${RESET}\n")
            return true
        }
        println( "${RED}Go back${RESET}...")
        return false
    }


}
