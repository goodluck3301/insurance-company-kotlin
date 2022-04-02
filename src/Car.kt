class Car(val model:String,val height:Float,val width:Float,val engine:Engine, val year:Int) {

    fun GetInfo():String
    {
        return "${model} ${height}x${width}, " +
                "${YELLOW}Engine${RESET}(${engine.model}, ${YELLOW}pow.-${RESET}(${engine.power}), " +
                "${YELLOW}vol.-${RESET}(${engine.volume}), ${YELLOW}Cyl.Count${RESET}(${engine.numberOfCylinders}), ${YELLOW}Year${RESET}($year)"
    }//fun get info

}