package com.example.holidaymoviecollection.data.local

import com.example.holidaymoviecollection.R
import com.example.holidaymoviecollection.data.local.entities.Movie

object DatabaseSeeder {
    fun getPredefinedMovies(): List<Movie> = listOf(
        Movie(1, "Home Alone (1990)", R.drawable.home_alone_1990),
        Movie(2, "Elf (2003)", R.drawable.elf_2003),
        Movie(3, "Jingle All the Way (1996)", R.drawable.jingle_all_the_way_1996),
        Movie(4, "The Chronicles of Narnia: The Lion, the Witch and the Wardrobe (2005)", R.drawable.the_chronicles_of_narnia_2005),
        Movie(5, "The Polar Express (2004)", R.drawable.the_polar_express_2004),
        Movie(6, "Klaus (2019)", R.drawable.klaus_2019),
        Movie(7, "Little Women (2019)", R.drawable.little_women_2019),
        Movie(8, "The Holiday (2006)", R.drawable.the_holiday_2006),
        Movie(9, "Eternal Sunshine of the Spotless Mind (2004)", R.drawable.eternal_sunshine_of_the_spotless_mind_2004),
        Movie(10, "Krampus (2015)", R.drawable.krampus_2015),
        Movie(11, "The Thing (1982)", R.drawable.the_thing_1982),
        Movie(12, "Die Hard 2 (1990)", R.drawable.die_hard_2_1990),
        Movie(13, "Wind River (2017)", R.drawable.wind_river_2017),
    )
}
