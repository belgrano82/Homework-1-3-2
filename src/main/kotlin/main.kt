fun main() {

    print("Введите сумму трансфера: ")
    val getTransferAmount = readln().toInt()
    print("Введите карту или платёжную систему, которую будете использовать: ")
    val getTypeOfTransfer = readln()
    val finalCommissions = calculateCommissionAmount(getTransferAmount, cardType = getTypeOfTransfer)
    println("Комиссия при переводе $getTransferAmount р., используя \"$getTypeOfTransfer\", составит $finalCommissions.")

}


fun calculateCommissionAmount(transferAmount: Int, cardType: String = "VK pay", monthTransferAmount: Int = 0): Int {

    val totalTransfer = transferAmount + monthTransferAmount
    return checkCommissionFromTypeOfTransfer(cardType, totalTransfer)
}

fun checkCommissionFromTypeOfTransfer(typeOfTransfer: String, transferAmount: Int): Int {

    var sumOfCommission = 0
    when (typeOfTransfer) {
        "Vk pay" -> sumOfCommission = 0
        "Mastercard", "Maestro" -> if (transferAmount > 75_000) sumOfCommission =
            (transferAmount * 0.006 + 20).toInt() else sumOfCommission = 0

        "Visa", "Мир" -> if ((transferAmount * 0.0075) < 35) sumOfCommission = 35 else sumOfCommission =
            (transferAmount * 0.0075).toInt()
    }
    return sumOfCommission

}

