package dev.alexmorgan.unbearable2.main_activity

import javax.inject.Inject
import kotlin.random.Random

class BearNameGenerator @Inject constructor(private val random: Random) {

    fun randomName(): String {
        return names[random.nextInt(names.size)]
    }

    companion object {
        val names = arrayOf(
            "Beary Manilow",
            "Pat Bearnatar",
            "Cindy Clawford",
            "Halley Beary",
            "Katy Beary",
            "Bing Clawsby",
            "Kamala Bearris",
            "Paw Rudd",
            "Bearman Mao",
            "Pawdry Hepburn",
            "Pawly Shore",
            "Bear Grylls",
            "Beary Larkin",
            "Paw McCartney",
            "Bearny Sanders",
            "Grizzly Adams",
            "Winnie the Pooh",
            "Drew Bearey",
            "Jim Bearrey",
            "Nick Furry",
            "Beary Stiles",
            "Amy Bearah Growler",
            "Simon Growl",
            "Drew Bearymore",
            "Bearock Obama",
            "Roary McIlroy",
            "Benedict Cumbearbatch",
            "Beary Gibb",
            "Bearbra Walters",
            "Roger Federbear",
            "Jude Claw",
            "Beary White"
        )
        // Paw, claw, bear, fur, roar, growl, hibernate, honey
    }
}