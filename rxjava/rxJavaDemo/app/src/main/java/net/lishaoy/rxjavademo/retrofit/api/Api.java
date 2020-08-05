package net.lishaoy.rxjavademo.retrofit.api;

import net.lishaoy.rxjavademo.retrofit.bean.ProjectBean;
import net.lishaoy.rxjavademo.retrofit.bean.ProjectItem;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("project/tree/json")
    Observable<ProjectBean> getProject();

    @GET("project/list/{pageIndex}/json")
    Observable<ProjectItem> getProjectItem(@Path("pageIndex") int pageIndex, @Query("cid") int cid);

}
