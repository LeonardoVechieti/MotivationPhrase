package com.example.motivation.data

import com.example.motivation.MotivationConstants

class Phrase(val description: String, val category: Int) {
    override fun toString(): String {
        return "Phrase(description='$description', category=$category)"
    }
}

class Mock {
    private val sunny= MotivationConstants.FILTER.SUNNY
    private val happy= MotivationConstants.FILTER.HAPPY
    private val inclusive= MotivationConstants.FILTER.INCLUSIVE

     private val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", sunny),
        Phrase("O que você pode fazer agora para melhorar a sua situação?", sunny),
        Phrase("A persistência é o caminho do êxito.", sunny),
        Phrase("Motivação é a arte de fazer as pessoas fazerem o que você quer que elas façam porque elas o querem fazer.", sunny),
        Phrase("Se você traçar metas absurdamente altas e falhar, seu fracasso será muito melhor que o sucesso de todos.", sunny),
        Phrase("A melhor vingança é um sucesso estrondoso.", sunny),
        Phrase("O que você faz hoje pode melhorar todos os seus amanhãs.", sunny),
        Phrase("Acredite em milagres, mas não dependa deles.", sunny),
        Phrase("A maior barreira para o sucesso é o medo do fracasso.", sunny),
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy),
        Phrase("O que você pode fazer agora para melhorar a sua situação?", happy),
        Phrase("A persistência é o caminho do êxito.", happy),
        Phrase("Motivação é a arte de fazer as pessoas fazerem o que você quer que elas façam porque elas o querem fazer.", happy),
        Phrase("Se você traçar metas absurdamente altas e falhar, seu fracasso será muito melhor que o sucesso de todos.", happy),
        Phrase("A melhor vingança é um sucesso estrondoso.", happy),
        Phrase("O que você faz hoje pode melhorar todos os seus amanhãs.", happy),
        Phrase("Acredite em milagres, mas não dependa deles.", happy),
        Phrase("A maior barreira para o sucesso é o medo do fracasso.", happy),
        Phrase("Não sabendo que era impossível, foi lá e fez.", inclusive),
        Phrase("O que você pode fazer agora para melhorar a sua situação?", inclusive),
        Phrase("A persistência é o caminho do êxito.", inclusive),
        Phrase("Motivação é a arte de fazer as pessoas fazerem o que você quer que elas façam porque elas o querem fazer.", inclusive),
        Phrase("Se você traçar metas absurdamente altas e falhar, seu fracasso será muito melhor que o sucesso de todos.", inclusive),
    )
    fun getPhrase(categoryId: Int): String {
        val filtered = mListPhrase.filter { (it.category == categoryId || categoryId == MotivationConstants.FILTER.INCLUSIVE) }
        val rand = (filtered.indices).random()
        return filtered[rand].description
    }



}