package net.lishaoy.kotlindemo.entity

/**
"data": {
    "admin": false,
    "chapterTops": [],
    "coinCount": 0,
    "collectIds": [],
    "email": "",
    "icon": "",
    "id": 74231,
    "nickname": "persilee",
    "password": "",
    "publicName": "persilee",
    "token": "",
    "type": 0,
    "username": "persilee"
}
 */

data class LoginData(
    val admin: Boolean,
    val chapterTops: List<*>,
    val coinCount: Int,
    val collectIds: List<*>,
    val email: String?,
    val icon: String?,
    val id: String?,
    val nickname: String?,
    val password: String?,
    val publicName: String?,
    val token: String?,
    val type: Int,
    val username: String?
)