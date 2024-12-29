fun main() {
    
    myNormalPhone.switchOn()
    myNormalPhone.checkPhoneScreenLight()
    
    myFoldablePhone.switchOn()
    myFoldablePhone.checkPhoneScreenLight()
    
    myFoldablePhone.flipOpen()
    myFoldablePhone.switchOn()
    myFoldablePhone.checkPhoneScreenLight()
    
    myFoldablePhone.flipClosed()
    myFoldablePhone.switchOn()
    myFoldablePhone.checkPhoneScreenLight()
}

val myNormalPhone: Phone = Phone()

val myFoldablePhone: FoldablePhone = FoldablePhone()

open class Phone(var isScreenLightOn: Boolean = false){ //important: fun, class, val, var ... all have to be open if you want something to inherit it
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    open fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.\n")
    }
}

class FoldablePhone(var isScreenUnfolded: Boolean = false): Phone() {
        
    override fun switchOn() {
        if (isScreenUnfolded) {
            isScreenLightOn = true
        }
    }

    fun flipOpen() {
        isScreenUnfolded = true
        println("The flip phone has been flipped open.")
    }

    fun flipClosed() {
        isScreenUnfolded = false
        isScreenLightOn = false // else, if it is already on, it stays on when flipped shut
        println("The flip phone has been flipped shut.")
    }

    override fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The flip phone screen's light is $phoneScreenLight.\n")
    }
}