package lotto.model

class Lottos(
    private val lottos: List<Lotto>,
) {
    fun matchlottos(winningNumber: WinningNumber): UserPrize {
        return UserPrize(matches = lottos.groupingBy { lotto -> winningNumber.calculatePrize(lotto) }.eachCount())
    }

    fun getLottos(): List<Lotto> {
        return lottos
    }

    fun combineLottos(
        manualLottos: Lottos,
        autoLottos: Lottos,
    ): Lottos {
        val combinedList = manualLottos.getLottos() + autoLottos.getLottos()
        return Lottos(combinedList)
    }
}
