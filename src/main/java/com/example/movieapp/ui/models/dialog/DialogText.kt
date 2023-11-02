package com.example.movieapp.ui.models.dialog

//안에 들어가는 내용
sealed class DialogText {
    abstract var text: String?
    abstract var id: Int?

    //text와 id 받아서 둘 중 하나가 null이면 다른 값을 보여줌
    class Default() : DialogText() {
        override var text: String? = null
        override var id: Int? = null

        constructor(text: String) : this() {
            this.text = text
        }

        constructor(text: Int) : this() {
            this.id = text
        }
    }

    //여긴 평점까지 같이 받음
    class Rating() : DialogText() {
        override var text: String? = null
        override var id: Int? = null
        var rating: Float = 0.0f

        constructor(text: String, rating: Float) : this() {
            this.text = text
            this.rating = rating
        }

        constructor(text: Int, rating: Float) : this() {
            this.id = text
            this.rating = rating
        }
    }
}