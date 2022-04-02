import java.util.*


/*    colors for console
-----------------------------*/
const val RED    = "\u001b[31m"
const val Green  = "\u001b[32m"
const val YELLOW = "\u001b[33m"
const val RESET  = "\u001b[0m"
const val PURPLE = "\u001B[35m"
//-----------------------------


fun lv_insurance()
{
val text = """
[31m#       #     #[32m    ###                                                         
[31m#       #     #[32m     #  #    #  ####  #    # #####    ##   #    #  ####  ######[0m 
[31m#       #     #[32m     #  ##   # #      #    # #    #  #  #  ##   # #    # #      [0m
[31m#       #     #[32m     #  # #  #  ####  #    # #    # #    # # #  # #      #####  [0m
[31m#        #   #[32m      #  #  # #      # #    # #####  ###### #  # # #      #      [0m
[31m#         # #[32m       #  #   ## #    # #    # #   #  #    # #   ## #    # #      [0m
[31m#######    #[32m       ### #    #  ####   ####  #    # #    # #    #  ####  ###### [0m"""
    println(text)
    println("--------------------  ${YELLOW}With us is${Green} ireliable${RESET}    ------------------------------\n")
    println("\n${Green}Welcome to our insurance company${RESET}")

}

fun pint_() {
    println("\n${PURPLE}      -${RED}.${PURPLE}-${RED}.${PURPLE}-${RED}.${PURPLE}-${RED}.${PURPLE}-${RED}.${PURPLE}-" +
        "                                                                                 " +
        "${PURPLE}-${RED}.${PURPLE}-${RED}.${PURPLE}-${RED}.${PURPLE}-${RED}.${PURPLE}-${RED}.${PURPLE}-${RESET}\n")
    }

fun main()
{
    val worker_list = mutableListOf(Worker("Ani","Asatryan",25,374986534,"AA00215454","Director"),
            Worker("Armen","Vardanyan",31,374748965,"AA98456513","Insurancer"),
            Worker("Anahit","Manukyan",21,374659874,"AA99885544","Insurancer"),

    )//worker list
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
    val cust_list = mutableListOf(
        Customers(1,"Vigen","Ginosyan",27,"AA01256587",37493987654,CategoryInsurance.CAR,0, Date(2022,1,1),
                    Car("Mersedes-Benz w221",1.4f,2.1f,Engine("3.0 V6",295,6,6),2018) ,),//cust 1

        Customers(2,"Ruzan","Hunanyan",31,"AA88964213",37493977122,CategoryInsurance.HEALTH,0,Date(2022,2,1)),//cust2

        Customers(3,"Arman","Varosyan",22,"AA12548648",37443759812,CategoryInsurance.CAR,0,Date(2022,1, 17),
                Car("BMW M5 E60", height = 1.2f, width = 4.8f, Engine("M5",300,12,8,), 2008))//cust3

    )//list all Cust
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    val insuranceCompany = InsuranceCompany(
        ContactInformation("LV Insurance","Azatutyan 78",374984657,"lv.insurance@mail.ru"), worker_list, cust_list)
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    var allmoney = 0
    var bool1 = false
    var bool = false
    var g = true
    val a = cust_list.size
    val b = worker_list.size
    var d = true
    var h = true
    cust_list.forEach{allmoney += it.historyMoney()}
    lv_insurance()
//----------------------------------------------------------------------------------------------------------------------
    while(true) {
        println("\n${YELLOW}Choose option...$RESET \n" +
                "${RED}[1]${RESET}Log in\n" +
                "${RED}[2]${RESET}Get Information About Our Company\n" +
                "${RED}[3]${RESET}Sign up\n" +
                "${RED}[0]${RESET}Input 0 for ${RED}close programm${RESET}\n")
        var inputYOption:Int

        try {
             inputYOption = Scanner(System.`in`).nextInt()
        }catch (e : Exception){
            inputYOption = 9999
        }

        when(inputYOption)
        {
            1 ->  {
                val c = insuranceCompany.check_login_pass()
                 when (c) {
                     0 -> {
                         println("\n${RED}No correct ${YELLOW}login${RED} or ${YELLOW}password${RESET}\n")
                     }
//----------------------------------------------------------------------------------------------------------------------
                     in 1..10 -> {
                         println("${Green}Welcome to Your(Customer) page${RESET}\nMy Profil info is\n${cust_list[c - 1].getInfoCustomers()}")
                         var a = true
                         while (a) {
                             println("${Green}Choose option...$RESET \n" +
                                     "${RED}[1]${RESET}Extend the deadline\n" +
                                     "${RED}[2]${RESET}My history\n" +
                                     "${RED}[3]${RESET}Register Incident\n" +
                                     "${RED}[0]${RESET}Log out\n")
                             var input_Worker_Option:Int

                             try {
                                 input_Worker_Option = Scanner(System.`in`).nextInt()
                             }catch (e : Exception){
                                 input_Worker_Option = 9999
                             }

                             when (input_Worker_Option) {
                                 1 -> {
                                     cust_list[c - 1].extend_the_deadline()
                                     println(cust_list[c - 1].getInfoCustomers())
                                     if(insuranceCompany.payMoney())
                                         bool1 = true


                                 }
                                 2 -> {
                                     println("Total money ${cust_list[c - 1].historyMoney()}$")
                                 }
                                 3 -> {
                                     if (bool1)
                                     {
                                        println("You have ${cust_list[c-1].incident_Money()}$")
                                        allmoney= allmoney - cust_list[c-1].incident_Money()
                                         bool1=false
                                     }
                                     else
                                         println("You dont can ${YELLOW}Register Incident ${RED}(you don't pay for insurance)${RESET}")
                                 }
                                 0 -> { println("Log out")
                                        a = false }
                             }//when
                         }//while
                     }//customers account
//----------------------------------------------------------------------------------------------------------------------
                     in 11..20 -> {
                            if(worker_list[c - 11].worker_thick == "Insurancer" || worker_list[c - 11].worker_thick == "Director") {
                                println("${Green}Welcome to Your(Worker) page${RESET}\nMy Profil info is\n" +
                                        worker_list[c - 11].getInfoWorkers())
                                h = true
                                while (h) {
                                    if (worker_list[c - 11].worker_thick == "Director")
                                        println("\n" +
                                                "${RED}[1]${RESET}Get Customers Info\n" +
                                                "${RED}[2]${RESET}Add Customer\n" +
                                                "${RED}[3]${RESET}Delete Customer\n" +
                                                "${RED}[4]${RESET}All Income\n" +             ///ekamutnery
                                                "${RED}[5]${RESET}Add Worker\n" +
                                                "${RED}[6]${RESET}Delete Worker\n" +
                                                "${RED}[7]${RESET}Get Worker Info\n" +
                                                "${RED}[0]${RESET}Log out\n")
                                    else
                                        println("\n" +
                                                "${RED}[1]${RESET}Get Customers Info\n" +
                                                "${RED}[2]${RESET}Add Customer\n" +
                                                "${RED}[3]${RESET}Delete Customer\n" +
                                                "${RED}[4]${RESET}All Income\n" +             ///ekamutnery
                                                "${RED}[0]${RESET}Log out\n")
                                    //--------------------------------------------------------------
                                    var input_Worker_Option:Int

                                    try {
                                        input_Worker_Option = Scanner(System.`in`).nextInt()
                                    }catch (e : Exception){
                                        input_Worker_Option = 9999
                                    }

                                    when (input_Worker_Option) {
                                        1 -> {
                                            println("Customers Info")
                                            cust_list.forEach {
                                                println(" " + it.getInfoCustomers())
                                                pint_()
                                            }
                                        }
                                        2 -> {
                                            insuranceCompany.add_cust(cust_list)
                                            //insuranceCompany.add_login_pass(a+1)
                                            insuranceCompany.add_login_pass(cust_list.size + 1)
                                            cust_list.forEach { println(it.getInfoCustomers()) }
                                        }
                                        3 -> {
                                            cust_list.forEachIndexed { i, it -> println("${i + 1}) " + it.getInfoCustomers()) }
                                            println("Inpute number for delete customer")
                                            val input_delete_number = Scanner(System.`in`).nextInt()
                                            insuranceCompany.delete_customers(cust_list, (input_delete_number - 1))

                                            cust_list.forEachIndexed { i, it -> println("${i + 1}) " + it.getInfoCustomers()) }
                                        }//case 3
                                        4 -> {
                                            println("Insurance Income ${allmoney}$")
                                        }//case 4
                                        5 -> {
                                            if (worker_list[c - 11].worker_thick == "Director") {
                                                insuranceCompany.add_worker(worker_list)
                                                insuranceCompany.add_login_pass_work(b + 1)
                                                worker_list.forEach {
                                                    println(it.getInfoWorkers())
                                                }
                                            }
                                        }//case 5

                                        6 -> {
                                            if (worker_list[c - 11].worker_thick == "Director") {
                                                worker_list.forEachIndexed { i, it ->
                                                    println("${i + 1}) " + it.getInfoWorkers())
                                                }//forEach

                                                println("Inpute number for delete worker")
                                                val input_deleteW_number = Scanner(System.`in`).nextInt()
                                                insuranceCompany.delete_worker((worker_list),
                                                    (input_deleteW_number - 1))

                                                worker_list.forEachIndexed { i, it ->
                                                    println("${i + 1}) " + it.getInfoWorkers())
                                                }//forEach
                                            }
                                        }//case 6

                                        7 -> {
                                            if (worker_list[c - 11].worker_thick == "Director") {
                                                worker_list.forEachIndexed { i, it ->
                                                    println("${i + 1}) " + it.getInfoWorkers())
                                                    pint_()
                                                }//forEach
                                            }
                                        }//case 7

                                        0 -> {
                                            println("${RED}Log out...${RESET}")
                                            h = false
                                        }

                                    }//when
                                }//while
                            } else
                                println("${RED}Sorry${YELLOW} but You don't have access to the system.${RESET}")
                     }//worker case

//----------------------------------------------------------------------------------------------------------------------
                     777 -> {
                            d = true
                         while (d) {
                             println("${Green}Welcome to ${RED}Admin${Green} page${RESET}\n" +
                                     "${RED}[1]${RESET}Get All Info\n" +
                                     "${RED}[2]${RESET}Add Customer\n" +
                                     "${RED}[3]${RESET}Delete Customer\n" +
                                     "${RED}[4]${RESET}Add Worker\n" +
                                     "${RED}[5]${RESET}Delete Worker\n" +
                                     "${RED}[0]${RESET}Log out\n")
                             var inputAdmOption:Int

                             try {
                                 inputAdmOption = Scanner(System.`in`).nextInt()
                             }catch (e : Exception){
                                 inputAdmOption = 9999
                             }

                             when (inputAdmOption) {
                                 1 -> {
                                     println("${RED}Customers Info${RESET}")
                                     cust_list.forEach {
                                         println(" " + it.getInfoCustomers())
                                         pint_()
                                     }
                                     println("\n${PURPLE}Workers Info${RESET}\n")
                                     worker_list.forEachIndexed { i, it ->
                                         println("${i + 1}) " + it.getInfoWorkers())
                                         pint_()
                                     }//forEach
                                 }
                                 2 -> {
                                     insuranceCompany.add_cust(cust_list)
                                     insuranceCompany.add_login_pass(a)
                                     cust_list.forEach {
                                         println(it.getInfoCustomers())
                                     }//forEach
                                 }
                                 3 -> {
                                     cust_list.forEachIndexed { i, it ->
                                         println("${i + 1}) " + it.getInfoCustomers())
                                     }//forEach

                                     println("Inpute number for delete customer")
                                     val input_delete_number = Scanner(System.`in`).nextInt()
                                     insuranceCompany.delete_customers(cust_list, (input_delete_number - 1))

                                     cust_list.forEachIndexed { i, it ->
                                         println("${i + 1}) " + it.getInfoCustomers())
                                     }
                                 }//case 3
                                 4 -> {
                                     insuranceCompany.add_worker(worker_list)
                                     insuranceCompany.add_login_pass_work(b+10)
                                     worker_list.forEach { println(it.getInfoWorkers()) }
                                     }//case 4
                                 5 -> {
                                     worker_list.forEachIndexed { i, it ->
                                         println("${i + 1}) " + it.getInfoWorkers()) }//forEach

                                     println("Inpute number for delete worker")
                                     val input_deleteW_number = Scanner(System.`in`).nextInt()
                                     insuranceCompany.delete_worker((worker_list), (input_deleteW_number - 1))

                                     worker_list.forEachIndexed { i, it -> println("${i + 1}) " + it.getInfoWorkers()) }
                                 }//case 5
                                 0 -> { println("${RED}Log out...${RESET}")
                                        d = false
                                 }
                             }
                         }
                     }
                 }

//--------------------------------------------------------------
            }
            2 ->  { println(insuranceCompany.getPublicInfo()+"\n") }
            3 ->  {
                    //insuranceCompany.add_login_pass(a+1)
                insuranceCompany.add_login_pass(cust_list.size+1)
                insuranceCompany.add_cust(cust_list)
                g = true
                while (g) {
                    println("${YELLOW}[1] ${RESET}Extend the deadline\n"  +
                            "${YELLOW}[2] ${RESET}Money for pay\n" +
                            "${YELLOW}[3] ${RESET}Register Incident\n" +
                            "${YELLOW}[4] ${RESET}View my info\n" +
                            "${YELLOW}[5] ${RESET}My History\n" +
                            "${YELLOW}[0] ${RESET}Log out")
                    var chose_opt:Int

                    try {
                        chose_opt = Scanner(System.`in`).nextInt()
                    }catch (e : Exception){
                        chose_opt = 9999
                    }

                    when(chose_opt) {
                        0 -> g = false
                        1 -> {
                            cust_list[cust_list.size-1].extend_the_deadline()
                            println(cust_list[cust_list.size-1].getInfoCustomers())
                        }
                        2 -> {
                            println("Total money ${cust_list[cust_list.size-1].historyMoney()}$")
                            if(insuranceCompany.payMoney())
                                bool = true
                        }
                        3 -> {
                            if(bool) {
                                println("You have ${cust_list[cust_list.size - 1].incident_Money()}$")
                                allmoney = allmoney - cust_list[cust_list.size - 1].incident_Money()
                                bool=false

                            }
                            else
                                println("You dont can ${YELLOW}Register Incident ${RED}(you don't pay for insurance)${RESET}")
                        }
                        4 -> { println("${YELLOW}Your account info is:$RESET\n"+ cust_list[cust_list.size-1].getInfoCustomers()+"\n" ) }//
                        5 -> {
                            if(bool)
                                println("Total money ${cust_list[cust_list.size - 1].historyMoney()}$\n")
                            else
                                println("Total money 0$\n")
                        }
                    }
                }
            }
            0 -> {
                println("${RED}Program closed...${RESET}")
                return
            }
            else -> println("\n${RED}Choose right option${RESET}")
        }
    }
}//fun main