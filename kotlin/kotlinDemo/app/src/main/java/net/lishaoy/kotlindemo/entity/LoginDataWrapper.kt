package net.lishaoy.kotlindemo.entity

/**
{
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
    },
    "errorCode": 0,
    "errorMsg": ""
}
 */


data class LoginDataWrapper<T>(
    val data: T,
    val errorCode: Int,
    var errorMsg: String
)