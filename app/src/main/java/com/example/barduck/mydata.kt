package com.example.barduck

data class start(val name:String, val hello:String, val image: Int)

object List {
    val list = arrayListOf(
        start(
            "Vape shop BAR DUCK",
            "Добро пожаловать в магазин электронных сигарет BAR DUCK.\n" +
                    " \n" +
                    "\n" +
                    "Мы являемся большой федеральной сетью розничных магазинов, так что может быть, наш вейп шоп уже есть в вашем городе.",
            R.drawable.logostart
        ),
        start ("Vape shop BAR DUCK", "Также мы занимаемся доставкой по всей Росиии",R.drawable.explorestart),

        start ("Vape shop BAR DUCK", "Переходи быстрее и изучай ассортимент \n" +
                "=0",R.drawable.warnstart)

    )
}
