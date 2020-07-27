package net.lishaoy.retrofitdemo.api;

import net.lishaoy.retrofitdemo.annotation.Field;
import net.lishaoy.retrofitdemo.annotation.Get;
import net.lishaoy.retrofitdemo.annotation.Post;
import net.lishaoy.retrofitdemo.annotation.Query;

import okhttp3.Call;

public interface WeatherApi {

    @Post("/v3/weather/weatherInfo")
    Call postWeather(@Field("city") String city, @Field("key") String key);

    @Get("/v3/weather/weatherInfo")
    Call getWeather(@Query("city") String city, @Query("key") String key);

}
