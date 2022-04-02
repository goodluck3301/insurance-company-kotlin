import java.util.*
import kotlin.math.log

class Database() {


    private val adm_log = "adm"
    private val adm_pass = "adm"

    private var login_pass_cust = mutableMapOf(1 to "cust1", 2 to "cust2", 3 to "cust3", )
    private var login_pass_work = mutableMapOf(11 to "work1", 12 to "work2", 13 to "work3",)



    fun check_login_pass(login:String, password:String, ):Int
    {
        if(login == adm_log && password==adm_pass)
            return 777

        var l:Int

        try {
            l = login.toInt()
        }catch (e : Exception){
            l = 9999999
        }

        login_pass_cust.forEach{
            when
            {
                l == it.key && password==it.value  -> return it.key

            }
        }//forEach

        login_pass_work.forEach{
            when
            {
                l == it.key && password == it.value  -> return it.key
            }
        }//forEach

        return 0
    }//fun  check_login_pass



    fun addLoginPass(id:Int)
    {
        println("${RED}Your login is ${YELLOW}[ ${id} ]${RESET}")
        println("${RED}Input your password${RESET}")
            val password  =  Scanner(System.`in`).nextLine()
        login_pass_cust+=Pair(id,password!!)
    }

    fun addLoginPass_worker(id:Int)
    {
        println("${RED}Login is ${YELLOW}[ ${id} ]${RESET}")
        println("${RED}Input password${RESET}")
        val password  =  Scanner(System.`in`).nextLine()
        login_pass_work+=Pair(id,password!!.toString())
    }

 fun delete_cust_log(id: Int) { login_pass_cust.remove(id) }
 fun delete_work_log(id: Int) { login_pass_work.remove(id) }

}//Database class