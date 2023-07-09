package lotto.domain

class WinningTicket(
    private val winningNumbers: LottoNumbers,
    private val bonusNumber: LottoNumber
) {
    init {
        require(!winningNumbers.containNumber(bonusNumber))
    }

    fun getMatchingResult(myTickets: LottoTickets): LottoResult {
        return myTickets
            .matchCountAndHasBonusNumber(winningNumbers, bonusNumber)
            .groupingBy { (matchCount, hasBonusNumber) -> LottoRank.of(matchCount, hasBonusNumber) }
            .eachCount()
            .let { LottoResult(it) }
    }
}
