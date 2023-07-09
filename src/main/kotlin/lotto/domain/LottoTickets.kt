package lotto.domain

const val LOTTO_SIZE = 6

data class LottoTickets(val values: List<LottoNumbers>) {
    operator fun plus(other: LottoTickets): LottoTickets {
        return this + other
    }

    fun matchCountAndHasBonusNumber(
        winningNumbers: LottoNumbers,
        bonusNumber: LottoNumber
    ): List<Pair<Int, Boolean>> {
        return values.map { numbers ->
            Pair(
                numbers.countMatchingNumbers(winningNumbers),
                numbers.containNumber(bonusNumber)
            )
        }
    }
}
